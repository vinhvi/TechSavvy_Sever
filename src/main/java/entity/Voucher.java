package entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Voucher implements Serializable {

    private String id;
    private String name;
    private int scoreNeed;
    private float discount;
    private Date startDate;
    private Date endDate;
    private String content;


}
