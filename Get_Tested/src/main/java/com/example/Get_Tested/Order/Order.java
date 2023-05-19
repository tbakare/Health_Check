package com.example.Get_Tested.Order;

import com.example.Get_Tested.LabRequisition.LabRequisition;
import com.example.Get_Tested.SexualPartner.SexualPartner;
import com.example.Get_Tested.Test.Test;
import com.example.Get_Tested.User.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "sexual_partner_id")
    private SexualPartner sexualPartner;

    @Enumerated(EnumType.STRING)
    @Column(name = "kit_type")
    private KitType kitType;

    @Column(name = "date_ordered")
    private LocalDate dateOrdered;

    @Column(name = "date_sent")
    private LocalDate dateSent;

    @Column(name = "date_received")
    private LocalDate dateReceived;

    @OneToMany(mappedBy = "order")
    private List<Test> tests;

    @OneToOne()
    @JoinColumn(name = "lab_requisition_id")
    private LabRequisition labRequisition;

    public Order() {}

    public Order(User user, KitType kitType, LocalDate dateOrdered) {
        this.user = user;
        this.kitType = kitType;
        this.dateOrdered = dateOrdered;
    }

    // Getters and setters for all the fields

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

    public SexualPartner getSexualPartner() {
        return sexualPartner;
    }

    public void setSexualPartner(SexualPartner sexualPartner) {
        this.sexualPartner = sexualPartner;
    }

    public KitType getKitType() {
        return kitType;
    }

    public void setKitType(KitType kitType) {
        this.kitType = kitType;
    }

    public LocalDate getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(LocalDate dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public LocalDate getDateSent() {
        return dateSent;
    }

    public void setDateSent(LocalDate dateSent) {
        this.dateSent = dateSent;
    }

    public LocalDate getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(LocalDate dateReceived) {
        this.dateReceived = dateReceived;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public LabRequisition getLabRequisition() {
        return labRequisition;
    }

    public void setLabRequisition(LabRequisition labRequisition) {
        this.labRequisition = labRequisition;
    }
}
