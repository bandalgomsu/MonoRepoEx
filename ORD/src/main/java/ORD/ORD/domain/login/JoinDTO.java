package ORD.ORD.domain.login;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class JoinDTO {

    private String userId;


    private String pw;

    private String email;


}
