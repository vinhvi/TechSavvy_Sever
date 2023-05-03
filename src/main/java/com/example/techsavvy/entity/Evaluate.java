package com.example.techsavvy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_evaluate")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Evaluate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;

    private int value;

    private Date evaluationDate;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

}
