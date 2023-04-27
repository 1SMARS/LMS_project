package com.libraryapp.controllers;
import java.util.List;

import com.libraryapp.AccountSettingsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.libraryapp.entities.User;
import com.libraryapp.security.CurrentUserFinder;
import com.libraryapp.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	

	private final UserService usService;
	private final CurrentUserFinder currentUserFinder;

	public AdminController(UserService userService, CurrentUserFinder currentUserFinder) {
		this.usService = userService;
		this.currentUserFinder = currentUserFinder;
	}


	@GetMapping
	public String adminHome(Model model) {
		User currentUser = currentUserFinder.getCurrentUser();
		model.addAttribute("currentUser", currentUser);
		return "admin/admin-home.html";
	}

	@GetMapping(value="/manageaccounts")
	public String manageAuthorities(@RequestParam (required = false) String firstName,
									@RequestParam (required = false) String lastName,
									Model model) {
		List<User> users = usService.userSearcher(firstName, lastName);

		model.addAttribute("users", users);
		model.addAttribute("firstName", firstName);
		model.addAttribute("lastName", lastName);
		return "admin/admin-manage-accounts.html";
	}

	@GetMapping(value="/manageaccount")
	public String manageAccount(@RequestParam Long userId,
								Model model) {

		User user = usService.findById(userId);
		model.addAttribute("user", user);
		return "admin/admin-manage-account.html";
	}

	@PutMapping(value="/confirmaccountsettings")
	public String confirmAccountChanges(@RequestParam boolean accStatus,
										@RequestParam String role,
										@RequestParam Long userId,
										Model model) {
		model.addAttribute("role", role);
		model.addAttribute("accStatus", accStatus);
		model.addAttribute("user", usService.findById(userId));
		return "admin/admin-confirm-account-settings.html";
	}

	@PutMapping(value="/saveaccountsettings")
	public String saveAccountSettings(@RequestParam boolean accStatus,
									  @RequestParam String role,
									  @RequestParam Long userId) {
		User user = usService.findById(userId);
		user.setRole(role);
		user.setEnabled(accStatus);
		usService.save(user);
		return "redirect:/admin/accountsettingssaved";
	}

	@GetMapping(value="/accountsettingssaved")
	public String accountSettingsSaved() {
		return "admin/admin-account-settings-saved.html";
	}

}
