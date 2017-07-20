package com.indbilisim.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ???
 *
 * @author Semih Erdoğan <semih.erdogan@indbilisim.com.tr>
 * @since 0.0.11
 */
@Service
@Transactional(readOnly = true)
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public void save(Customer customer) {
        BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder();
        customer.setPasswordConfirm(bCryptPasswordEncoder.encode(customer.getPasswordConfirm()));
        customer.setRole(Role.USER);
        customerRepository.save(customer);
    }

    public Customer findByUsername(String username) {
        return null;
    }

}
