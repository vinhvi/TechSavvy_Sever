package com.example.techsavvy.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_specification")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Specification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private String describes;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
