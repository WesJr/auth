package br.com.tech.challenge.auth.repository;

import br.com.tech.challenge.auth.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Customer, Integer> {

    Optional<Customer> findByCpf(String cpf);
}
