package com.indbilisim.bill;

import com.indbilisim.base.BaseEntity;

import javax.persistence.ManyToOne;

/**
 * Created by alikumru on 18.07.2017.
 */
public class Bill extends BaseEntity {


    private String address;
    @ManyToOne
    private long orderId;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
}
