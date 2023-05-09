package com.example.techsavvy.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

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
    private String typeDiscount;
    private float discountForProduct;
    private Date start;
    private Date end;
    private boolean enable;


}
