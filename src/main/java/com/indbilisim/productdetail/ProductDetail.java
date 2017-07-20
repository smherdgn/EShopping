package com.indbilisim.productdetail;

import com.indbilisim.base.BaseEntity;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

public class ProductDetail extends BaseEntity {

    @NotNull
    private int size;
    @NotNull
    private String color;
    @NotNull
    private double price;
    @NotNull
    @OneToMany
    private long productId;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
