package br.com.tech.challenge.auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginCustomerDto {

    private String cpf;
    private String password;
}
