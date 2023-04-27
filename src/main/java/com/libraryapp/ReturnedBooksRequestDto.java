package com.libraryapp;

public class ReturnedBooksRequestDto {
    private Long userId;
    private String firstName;
    private String lastName;
    private Long selectedBookId;
    private Long removeBookId;
    private String selectedBookIdsInString;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getSelectedBookId() {
        return selectedBookId;
    }

    public void setSelectedBookId(Long selectedBookId) {
        this.selectedBookId = selectedBookId;
    }

    public Long getRemoveBookId() {
        return removeBookId;
    }

    public void setRemoveBookId(Long removeBookId) {
        this.removeBookId = removeBookId;
    }

    public String getSelectedBookIdsInString() {
        return selectedBookIdsInString;
    }

    public void setSelectedBookIdsInString(String selectedBookIdsInString) {
        this.selectedBookIdsInString = selectedBookIdsInString;
    }
}
