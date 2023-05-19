package com.example.Get_Tested.Visit;

import com.example.Get_Tested.Order.Order;
import com.example.Get_Tested.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private VisitReason reason;
    private String symptoms;
    private PartnerGender partnerGender;
    private boolean hivStatus;
    private boolean syphillisStatus;

    @ManyToOne
    private Order orders;

    @ManyToOne
    private User user;


}
