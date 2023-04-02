package com.example.techsavvy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customers_id")
    private Member member;
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails = new ArrayList<>();


    private Date ngayDat;

    private String diaChiGiaoHang;

    private Date ngayGiao;

    private String notes;

    private boolean statusPayment;

    private boolean statusGH;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "payments_id")
    private Payments payments;

    @ManyToOne
    @JoinColumn(name = "shipping_company_id")
    private ShippingCompany shippingCompany;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "current_customer_id")
    private CurrentCustomer currentCustomer;

}
