package uz.pdp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterForm {
    private String fullName;
    private String age;
    private String address;
    private String profession;
    private Integer counterMessage=0;
    private Long chatId;
    private boolean isSentToAdmin=false;

}
