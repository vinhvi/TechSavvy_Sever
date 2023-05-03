package com.example.techsavvy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tb_voucher")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Voucher {
    @Id
    private String id;
    private String name;
    private int scoreNeed;
    private float discount;
    private Date startDate;
    private Date endDate;
    private String content;


}
