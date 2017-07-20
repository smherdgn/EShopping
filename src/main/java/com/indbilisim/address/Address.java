package com.indbilisim.address;

import com.indbilisim.base.BaseEntity;

import javax.persistence.ManyToOne;

public class Address extends BaseEntity {

    private String primaryAddress;
    private String secondaryAddress;
    @ManyToOne
    private long customerId;

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

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }


}
