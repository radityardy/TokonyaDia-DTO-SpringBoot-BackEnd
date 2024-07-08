package com.enigmacamp.tokonyadia.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "m_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "birth_date", nullable = false)
    private Date birthDate;
    @Column(name = "deleted", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isDeleted = Boolean.FALSE;

    @Override
    public String toString() {
        return "id= " + id +
                ", fullName= " + name +
                ", address= " + address +
                ", phone= " + phone +
                ", birthDate= " + birthDate +
                ", deleted= " + isDeleted;
    }
}

