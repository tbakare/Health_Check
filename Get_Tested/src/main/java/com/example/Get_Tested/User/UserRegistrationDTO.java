package com.example.Get_Tested.User;

public class UserRegistrationDTO {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String albertaHealthNumber;
    private String treatyNumber;
    private String mailingAddress;
    private String emailAddress;
    private String username;
    private String password;

    // Default constructor
    public UserRegistrationDTO() {}

    // Constructor with all fields
    public UserRegistrationDTO(String firstName, String lastName, String dateOfBirth, String albertaHealthNumber,
                               String treatyNumber, String mailingAddress, String emailAddress, String username,
                               String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.albertaHealthNumber = albertaHealthNumber;
        this.treatyNumber = treatyNumber;
        this.mailingAddress = mailingAddress;
        this.emailAddress = emailAddress;
        this.username = username;
        this.password = password;
    }

    // Getters and setters for all fields

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAlbertaHealthNumber() {
        return albertaHealthNumber;
    }

    public void setAlbertaHealthNumber(String albertaHealthNumber) {
        this.albertaHealthNumber = albertaHealthNumber;
    }

    public String getTreatyNumber() {
        return treatyNumber;
    }

    public void setTreatyNumber(String treatyNumber) {
        this.treatyNumber = treatyNumber;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
