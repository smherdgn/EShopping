package com.indbilsim.ecommerce.ProductDetail;

import com.indbilisim.base.BaseEntity;
import com.indbilsim.ecommerce.Image.Image;
import com.indbilsim.ecommerce.Product.Product;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * @author ibrahimsengul
 *         Created by ibrahimm on 10.7.2017.
 */
@Entity
public class ProductDetail extends BaseEntity {

    private String color;

    private String size;

    private float price;

    @NotNull
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productDetail")
    private Image image;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
