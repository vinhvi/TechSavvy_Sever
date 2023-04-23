package com.example.techsavvy.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_images")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    private String id;
    private String name;
    private String imageUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

}
