package entity;

import lombok.*;

import java.io.Serializable;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Supplier  implements Serializable {


    private String id;
    private String name;
    private String email;
    private String phone;
    private boolean status;

    private Address address;

}
