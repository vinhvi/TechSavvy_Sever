package com.example.techsavvy.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_product")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private Type type;
    private String name;
    private String origin;
    private float price;
    private int counts;
    private String describes;
    private boolean status;
    private String lo;


}
