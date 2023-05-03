package com.example.techsavvy.entity;

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
public class Order implements Serializable {
    @Id
    private String id;

    @OneToOne
    @JoinColumn(name = "payments_id")
    private Payments payments;

    @ManyToOne
    @JoinColumn(name = "shipping_company_id")
    private ShippingCompany shippingCompany;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    private Date bookingDate;
    private String notes;

    private boolean statusPayment;

    private String statusDelivery;

    private float totalMoney;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "voucher_id")
    private Voucher voucher;

}
