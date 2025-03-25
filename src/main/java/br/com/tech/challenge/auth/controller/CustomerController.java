package br.com.tech.challenge.auth.controller;

import br.com.tech.challenge.auth.model.Customer;
import br.com.tech.challenge.auth.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/me")
    public ResponseEntity<Customer> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Customer currentCustomer = (Customer) authentication.getPrincipal();

        return ResponseEntity.ok(currentCustomer);
    }

    @GetMapping("/")
    public ResponseEntity<List<Customer>> allUsers() {
        List <Customer> users = customerService.allCustomers();

        return ResponseEntity.ok(users);
    }

}
