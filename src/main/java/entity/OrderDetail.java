package entity;

import lombok.*;

import java.io.Serializable;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OrderDetail implements Serializable {

    private int id;


    private Order order;


    private Options options;

    private int quantity;

    private float unitPrice;


}
