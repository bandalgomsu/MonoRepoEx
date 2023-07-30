package ORD.ORD.domain.login;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Getter
@Setter
public class JoinDTO {


    @NotBlank(message = "아이디를 입력해주세요")
    @Size(min=3,max = 20, message = "아이디는 3~20글자 입니다")
    private String userId;

    @NotBlank(message = "패스워드를 입력해주세요")
    @Size(min=8 , max = 20,message = "패스워드는 8~20글자 입니다")
    private String pw;


    @NotBlank(message = "이메일을 입력해주세요")
    @Pattern(message = "이메일 형태가 올바르지 않습니다",regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$")
    private String email;


}
