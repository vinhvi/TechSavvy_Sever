package entity;

import lombok.*;

import java.io.Serializable;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShippingCompany   implements Serializable {


    private int id;
    private String name;
    private String email;
    private String phone;

    private Address address;

}
