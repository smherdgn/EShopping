package com.indbilsim.ecommerce.Bill;

import com.indbilisim.base.BaseEntity;
import com.indbilsim.ecommerce.Address.Address;
import com.indbilsim.ecommerce.Order.Order;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * @author ibrahimsengul
 *         Created by ibrahimm on 10.7.2017.
 */

@Entity
public class Bill extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Address address;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
