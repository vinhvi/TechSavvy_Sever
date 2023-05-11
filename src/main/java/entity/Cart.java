package entity;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart   implements Serializable {

    private int id;

    private Date importDate;



    private List<CartItems> cartItems = new ArrayList<>();


    private Customer customer;

}
