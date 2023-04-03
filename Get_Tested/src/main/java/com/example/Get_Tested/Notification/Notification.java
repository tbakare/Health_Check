package com.example.Get_Tested.Notification;

import com.example.Get_Tested.User.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private boolean isRead;

    private LocalDateTime createdAt;

    // Constructors
    public Notification() {
        this.createdAt = LocalDateTime.now();
    }

    public Notification(String message, User user) {
        this.message = message;
        this.user = user;
        this.isRead = false;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters

    // Getters for id, message, and createdAt

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Setter for isRead

    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }

    // Getters for user

    public User getUser() {
        return user;
    }

    // Setter for user

    public void setUser(User user) {
        this.user = user;
    }

    // Methods

    // Method to mark the notification as read
    public void markAsRead() {
        this.isRead = true;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
