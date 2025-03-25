package br.com.tech.challenge.auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterCustomerDto {

    private String name;
    private String email;
    private String cpf;
    private String password;
}
