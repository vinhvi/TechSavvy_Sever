package com.example.techsavvy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_employee")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends Person implements Serializable {

    private Date importDate;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

}
