package br.com.tech.challenge.auth.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {

    private String token;
    private long expiresIn;
}
