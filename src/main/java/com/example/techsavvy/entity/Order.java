package com.example.techsavvy.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_orders")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "payments_id")
    private Payments payments;

    @ManyToOne
    @JoinColumn(name = "shipping_company_id")
    private ShippingCompany shippingCompany;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    private Date bookingDate;

    private String address;

    private Date deliveryDate;

    private String notes;

    private boolean statusPayment;

    private boolean statusDelivery;


    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "current_customer_id")
    private CurrentCustomer currentCustomer;

}
