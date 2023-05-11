package entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question  implements Serializable {


    private int id;
    private String content;
    private Date questionDate;
    private boolean reply;

    private Product product;

    private Account account;

}
