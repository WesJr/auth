package br.com.tech.challenge.auth.service;

import br.com.tech.challenge.auth.model.Customer;
import br.com.tech.challenge.auth.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> allCustomers() {
        List<Customer> users = new ArrayList<>();

        customerRepository.findAll().forEach(users::add);

        return users;
    }
}
