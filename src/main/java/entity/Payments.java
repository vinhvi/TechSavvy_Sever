package entity;

import lombok.*;

import java.io.Serializable;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payments  implements Serializable {


    private int id;

    private String content;
    private boolean status;


}
