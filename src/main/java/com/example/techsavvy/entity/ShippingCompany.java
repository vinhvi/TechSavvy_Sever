package com.example.techsavvy.entity;
import jakarta.persistence.*;
import lombok.*;

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
    private String address;
    private String email;
    private String phone;


}
