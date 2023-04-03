package com.example.Get_Tested.SelfTestingKit;

import com.example.Get_Tested.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "self_testing_kit")
public class SelfTestingKit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serial_number", unique = true)
    @NotBlank(message = "Serial number is required")
    private String serialNumber;

    @Column(name = "expiry_date")
    @NotNull(message = "Expiry date is required")
    private LocalDate expiryDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @NotNull(message = "Status is required")
    private KitStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    // constructors, getters, and setters


    public SelfTestingKit(String serialNumber, LocalDate expiryDate, KitStatus status) {
        this.serialNumber = serialNumber;
        this.expiryDate = expiryDate;
        this.status = status;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public KitStatus getStatus() {
        return status;
    }

    public void setStatus(KitStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
