package com.indbilsim.ecommerce.Order;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ibrahimsengul
 *         Created by ibrahimm on 10.7.2017.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
