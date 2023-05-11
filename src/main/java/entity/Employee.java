package entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends Person   implements Serializable {
    private Date importDate;

    private Account account;

}
