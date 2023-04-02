package com.example.techsavvy.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@MappedSuperclass
@Data
@Getter
@Setter

public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private Date ngaySinh;
    @Column(nullable = false, unique = true)
    private int sex;
    @Column(nullable = false, unique = true)
    private String phone;
    @Column(nullable = false, unique = true)
    private String password;

}