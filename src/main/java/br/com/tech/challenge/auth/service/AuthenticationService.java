package br.com.tech.challenge.auth.service;

import br.com.tech.challenge.auth.dto.LoginCustomerDto;
import br.com.tech.challenge.auth.dto.RegisterCustomerDto;
import br.com.tech.challenge.auth.model.Customer;
import br.com.tech.challenge.auth.repository.CustomerRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final CustomerRepository customerRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            CustomerRepository customerRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Customer signup(RegisterCustomerDto input) {
        Customer customer = new Customer();

        customer.setCpf(input.getCpf());
        customer.setName(input.getName());
        customer.setEmail(input.getEmail());
        customer.setPassword(passwordEncoder.encode(input.getPassword()));

        return customerRepository.save(customer);
    }

    public Customer authenticate(LoginCustomerDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getCpf(),
                        input.getPassword()
                )
        );

        return customerRepository.findByCpf(input.getCpf())
                .orElseThrow();
    }
}
