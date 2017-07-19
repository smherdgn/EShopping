package com.indbilsim.ecommerce.Order;

import com.indbilisim.base.BaseEntity;
import com.indbilsim.ecommerce.Bill.Bill;
import com.indbilsim.ecommerce.Customer.Customer;
import com.indbilsim.ecommerce.OrderDetail.OrderDetail;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author ibrahimsengul
 *         Created by ibrahimm on 10.7.2017.
 */

@Entity
public class Order extends BaseEntity {

    @NotNull
    private float amouth;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @NotNull
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private OrderDetail orderDetail;

    @NotNull
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private Bill bill;

    public float getAmouth() {
        return amouth;
    }

    public void setAmouth(float amouth) {
        this.amouth = amouth;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
