package com.example.Get_Tested.LabRequisition;

import com.example.Get_Tested.Nurse.Nurse;
import com.example.Get_Tested.Order.Order;
import com.example.Get_Tested.Test.Test;
import com.example.Get_Tested.User.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lab_requisitions")
public class LabRequisition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "labRequisition", cascade = CascadeType.ALL)
    private Set<Test> tests = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nurse_id", nullable = false)
    private Nurse nurse;

    @OneToOne(mappedBy = "labRequisition")
    private Order order;

    @Column(name = "date_ordered", nullable = false)
    private LocalDate dateOrdered;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private LabRequisitionStatus status;

    public LabRequisition() {
    }

    public LabRequisition(User user, Set<Test> tests, Nurse nurse, LocalDate dateOrdered, LabRequisitionStatus status) {
        this.user = user;
        this.tests = tests;
        this.nurse = nurse;
        this.dateOrdered = dateOrdered;
        this.status = status;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public LocalDate getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(LocalDate dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public LabRequisitionStatus getStatus() {
        return status;
    }

    public void setStatus(LabRequisitionStatus status) {
        this.status = status;
    }
}

