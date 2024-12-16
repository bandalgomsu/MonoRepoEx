package ORD.ORD.domain.load;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoadDTO {

    @Pattern(regexp = "^([0-9a-zA-Z!@#$%^&*()_+]{11}$)|(-load )([0-9a-zA-Z!@#$%^&*()_+]{11}$)")

    private String code;


    private int clear;
}
