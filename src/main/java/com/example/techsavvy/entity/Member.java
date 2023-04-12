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
    @Column(nullable = false, unique = true)
    private String address;

    private int score;

    @ManyToMany
    @JoinTable(name = "members_roles",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<Role> roles = new LinkedHashSet<>();


}
