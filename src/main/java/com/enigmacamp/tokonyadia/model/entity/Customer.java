package com.enigmacamp.tokonyadia.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "m_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "deleted")
    private boolean isDeleted = Boolean.FALSE;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
