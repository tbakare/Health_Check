package com.example.Get_Tested.Test;

import com.example.Get_Tested.LabRequisition.LabRequisition;
import com.example.Get_Tested.Order.Order;
import com.example.Get_Tested.User.User;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tests")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "lab_requisition_id")
    private LabRequisition labRequisition;

    @Enumerated(EnumType.STRING)
    @Column(name = "test_type")
    private TestType testType;

    @Column(name = "kit_output")
    private String kitOutput;

    @Column(name = "result")
    private String result;

    @Column(name = "date_completed")
    private LocalDate dateCompleted;

    public Test() {}

    public Test(Order order, TestType testType, String kitOutput) {
        this.order = order;
        this.testType = testType;
        this.kitOutput = kitOutput;
    }

    // Getters and setters for all the fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LabRequisition getLabRequisition() {
        return labRequisition;
    }

    public void setLabRequisition(LabRequisition labRequisition) {
        this.labRequisition = labRequisition;
    }

    public TestType getTestType() {
        return testType;
    }

    public void setTestType(TestType testType) {
        this.testType = testType;
    }

    public String getKitOutput() {
        return kitOutput;
    }

    public void setKitOutput(String kitOutput) {
        this.kitOutput = kitOutput;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public LocalDate getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(LocalDate dateCompleted) {
        this.dateCompleted = dateCompleted;
    }
}
