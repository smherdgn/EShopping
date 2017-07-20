package com.indbilisim.order;

import com.indbilisim.base.BaseEntity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by alikumru on 17.07.2017.
 */
public class Order extends BaseEntity {

    @NotNull
    @Size(max = 10)
    private long amount;
    @NotNull
    private Date orderDate;
    @ManyToOne
    private String customerId;


    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
