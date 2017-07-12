package com.indbilsim.ecommerce.OrderDetail;

import com.indbilisim.base.BaseEntity;
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
public class OrderDetail extends BaseEntity {

    @NotNull
    private float price;

    @NotNull
    private int quantity;

    @NotNull
    private float total;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Order order;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
