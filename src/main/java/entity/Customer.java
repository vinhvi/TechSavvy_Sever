package entity;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends Person implements Serializable {
    private String typeCustomer;
    private int score;


    private Account account;


}
