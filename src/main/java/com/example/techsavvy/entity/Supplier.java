package com.example.techsavvy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

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
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
