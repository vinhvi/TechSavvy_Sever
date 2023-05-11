package entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Answer implements Serializable {


    private int id;
    private String content;
    private Date replyDate;

    private Question question;

    private Account account;

}
