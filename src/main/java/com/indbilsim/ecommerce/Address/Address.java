package com.indbilsim.ecommerce.Address;

import com.indbilisim.base.BaseEntity;
import com.indbilsim.ecommerce.Bill.Bill;
import com.indbilsim.ecommerce.Customer.Customer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author ibrahimsengul
 *         Created by ibrahimm on 10.7.2017.
 */

@Entity
@Table
public class Address extends BaseEntity {


    @NotNull
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
    private Bill bill;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    private String primaryAddress;

    private String secondaryAddress;

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(String primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public String getSecondaryAddress() {
        return secondaryAddress;
    }

    public void setSecondaryAddress(String secondaryAddress) {
        this.secondaryAddress = secondaryAddress;
    }
}
