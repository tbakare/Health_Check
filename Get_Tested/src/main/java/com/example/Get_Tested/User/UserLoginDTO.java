package com.example.Get_Tested.User;

public class UserLoginDTO {
    private String username;
    private String password;

    // Default constructor
    public UserLoginDTO() {}

    // Constructor with all fields
    public UserLoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters for all fields

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

