package entity;

import lombok.*;

import java.io.Serializable;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Specification  implements Serializable {


    private int id;
    private String name;

    private String describes;

    private Product product;

}
