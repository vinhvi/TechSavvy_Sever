package entity;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItems  implements Serializable {

    private int id;


    private Product product;


    private Cart cart;

    private Integer quantity;
}
