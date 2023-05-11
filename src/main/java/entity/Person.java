package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@MappedSuperclass
@Data
@Getter
@Setter
public abstract class Person {
    @Id
    @Column(nullable = false, unique = true)
    private String id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private Date dateOfBirth;
    @Column(nullable = false)
    private int sex;
    @Column(nullable = false, unique = true)
    private String phone;
    @OneToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "address_id")
    private Address address;


}
