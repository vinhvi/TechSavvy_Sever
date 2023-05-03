package com.example.techsavvy.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_shipping_company")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShippingCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String phone;
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private Address address;

}
