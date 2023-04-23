package com.example.techsavvy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "tb_currentCustomer")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrentCustomer {
    @Id
    private String id;
    @Column(nullable = false, unique = true)
    private String firstName;
    @Column(nullable = false, unique = true)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private Date dateOfBirth;
    @Column(nullable = false, unique = true)
    private int sex;
    @Column(nullable = false, unique = true)
    private String phone;
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private Address address;

}
