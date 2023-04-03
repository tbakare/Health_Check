package com.example.Get_Tested.Medication;

import com.example.Get_Tested.Result.Result;
import com.example.Get_Tested.User.User;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "medications",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"result_id", "medication_name"})})
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "result_id", nullable = false)
    private Result result;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "medication_name", nullable = false)
    private String medicationName;

    @Column(name = "medication_description", nullable = false)
    private String medicationDescription;

    public Medication() {}

    public Medication(Result result, String medicationName, String medicationDescription) {
        this.result = result;
        this.medicationName = medicationName;
        this.medicationDescription = medicationDescription;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getMedicationDescription() {
        return medicationDescription;
    }

    public void setMedicationDescription(String medicationDescription) {
        this.medicationDescription = medicationDescription;
    }
}
