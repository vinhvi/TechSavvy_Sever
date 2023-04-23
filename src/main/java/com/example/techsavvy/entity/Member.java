package com.example.techsavvy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tb_members")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member extends Person {
    private int score;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "account_id")
    private Account account;

}
