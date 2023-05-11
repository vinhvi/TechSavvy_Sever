package entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Discount  implements Serializable {

    private String id;
    private String content;
    private String typeDiscount;
    private float discountForProduct;
    private Date start;
    private Date end;
    private boolean enable;


}
