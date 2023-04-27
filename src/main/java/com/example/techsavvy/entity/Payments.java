package com.example.techsavvy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_payments")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payments  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;
    private boolean status;


}
