package com.example.techsavvy.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_supplier")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String phone;
    private String address;
    private boolean status;

}
