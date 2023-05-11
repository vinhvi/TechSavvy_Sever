package entity;

import lombok.*;

import java.io.Serializable;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Image implements Serializable {

    private String id;
    private String name;
    private String imageUrl;

    private Product product;

}
