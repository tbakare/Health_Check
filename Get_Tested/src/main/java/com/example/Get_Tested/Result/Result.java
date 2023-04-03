package com.example.Get_Tested.Result;

import com.example.Get_Tested.Test.Test;
import com.example.Get_Tested.User.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "results")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "status")
    private ResultStatus status;

    @Column(name = "description")
    private String description;

    @Column(name = "date_created")
    private LocalDateTime dateCreated;

//    @ManyToOne
//    private Nurse nurse;

    public Result() {}

    public Result(Test test, ResultStatus status, String description) {
        this.test = test;
        this.status = status;
        this.description = description;
        this.dateCreated = LocalDateTime.now();
    }

    // Getters and setters for all the fields


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ResultStatus getStatus() {
        return status;
    }

    public void setStatus(ResultStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}
