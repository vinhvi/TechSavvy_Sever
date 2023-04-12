package com.example.techsavvy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tb_currentCustomer")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrentCustomer extends Person {

    @Column(nullable = false, unique = true)
    private String address;

}
