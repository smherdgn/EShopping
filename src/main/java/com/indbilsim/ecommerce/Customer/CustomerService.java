package com.indbilsim.ecommerce.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ibrahimsengul
 *         Created by ibrahimm on 10.7.2017.
 */

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public void getCustomer(Long customer) {
        customerRepository.getOne(customer);
    }
}
