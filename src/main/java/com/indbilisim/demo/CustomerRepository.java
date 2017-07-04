package com.indbilisim.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by semih on 04.07.2017.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}