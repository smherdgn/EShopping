package com.indbilisim.customer;

import com.indbilisim.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by alikumru on 12.07.2017.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {



}

