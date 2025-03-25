package br.com.tech.challenge.auth.controller;

import br.com.tech.challenge.auth.dto.LoginCustomerDto;
import br.com.tech.challenge.auth.dto.RegisterCustomerDto;
import br.com.tech.challenge.auth.model.Customer;
import br.com.tech.challenge.auth.response.LoginResponse;
import br.com.tech.challenge.auth.service.AuthenticationService;
import br.com.tech.challenge.auth.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Customer> register(@RequestBody RegisterCustomerDto registerUserDto) {
        Customer registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginCustomerDto loginCustomerDto) {
        Customer authenticatedUser = authenticationService.authenticate(loginCustomerDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();

        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());


        return ResponseEntity.ok(loginResponse);
    }
}
