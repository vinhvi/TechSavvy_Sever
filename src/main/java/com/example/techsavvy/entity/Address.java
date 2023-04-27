package com.example.techsavvy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_address")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private String city;
    private String district;
    private String wards;
    private String street;

}
