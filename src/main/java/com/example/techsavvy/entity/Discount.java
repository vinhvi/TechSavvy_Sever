package com.example.techsavvy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "tb_discounts")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Discount {
    @Id
    private String id;
    private String content;
    private Date start;
    private Date end;
    private float discountForProduct;


}
