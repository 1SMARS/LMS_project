package com.libraryapp;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class AccountSettingsDTO {
    @NotNull
    private Long userId;
    @NotNull
    private String role;
    @NotNull
    private boolean accStatus;
}
