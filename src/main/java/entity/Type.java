package entity;

import lombok.*;

import java.io.Serializable;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Type  implements Serializable {

    private int id;

    private String name;

    private boolean status;

}
