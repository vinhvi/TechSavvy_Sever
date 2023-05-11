package entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Evaluate implements Serializable {


    private int id;

    private String content;

    private int value;

    private Date evaluationDate;


    private Product product;


    private Account account;

}
