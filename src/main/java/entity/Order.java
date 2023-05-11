package entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    private String id;

    private Payments payments;


    private ShippingCompany shippingCompany;


    private Employee employee;
    private Date bookingDate;
    private String notes;

    private boolean statusPayment;

    private String statusDelivery;

    private float totalMoney;


    private Customer customer;


    private Voucher voucher;

}
