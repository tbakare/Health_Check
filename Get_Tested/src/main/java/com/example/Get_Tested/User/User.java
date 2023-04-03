package com.example.Get_Tested.User;


import com.example.Get_Tested.LabRequisition.LabRequisition;
import com.example.Get_Tested.Medication.Medication;
import com.example.Get_Tested.Message.Message;
import com.example.Get_Tested.Order.Order;
import com.example.Get_Tested.Result.Result;
import com.example.Get_Tested.Role.Role;
import com.example.Get_Tested.SelfTestingKit.SelfTestingKit;
import com.example.Get_Tested.SexualPartner.SexualPartner;
import com.example.Get_Tested.Test.Test;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "alberta_health_number")
    private String albertaHealthNumber;

    @Column(name = "treaty_number")
    private String treatyNumber;

    @Column(name = "mailing_address")
    private String mailingAddress;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @OneToMany(mappedBy = "user")
    private List<Test> tests;

    @OneToMany(mappedBy = "user")
    private List<Medication> medications;

    @OneToMany(mappedBy = "user")
    private List<Result> results;

    @ManyToMany (mappedBy = "users")
    private Set<Message> messages = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private List<SelfTestingKit> selfTestingKits;

    @OneToMany(mappedBy = "user")
    private List<SexualPartner> sexualPartners;

    @OneToMany(mappedBy = "user")
    private List<LabRequisition> labRequisitions;

    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User() {}

    public User(String firstName, String lastName, LocalDate dateOfBirth, String albertaHealthNumber, String treatyNumber,
                String mailingAddress, String emailAddress, String username, String password) {
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

    public User(String firstName, String lastName, String dateOfBirth, String albertaHealthNumber, String treatyNumber, String mailingAddress, String emailAddress, String username, String encode) {
    }

    // Getters and setters for all the fields


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public List<SelfTestingKit> getSelfTestingKits() {
        return selfTestingKits;
    }

    public void setSelfTestingKits(List<SelfTestingKit> selfTestingKits) {
        this.selfTestingKits = selfTestingKits;
    }

    public List<SexualPartner> getSexualPartners() {
        return sexualPartners;
    }

    public void setSexualPartners(List<SexualPartner> sexualPartners) {
        this.sexualPartners = sexualPartners;
    }

    public List<LabRequisition> getLabRequisitions() {
        return labRequisitions;
    }

    public void setLabRequisitions(List<LabRequisition> labRequisitions) {
        this.labRequisitions = labRequisitions;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}

