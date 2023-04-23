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
    private String id;
    private String name;
    private String email;
    private String phone;
    private boolean status;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private Address address;

}
