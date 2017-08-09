package com.indbilisim.product;

import com.indbilisim.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "Product_Table")
@Entity
public class Product extends BaseEntity {


    private String product_name;
    private String category_id;
    private long product_detail_id;

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public long getProduct_detail_id() {
        return product_detail_id;
    }

    public void setProduct_detail_id(long product_detail_id) {
        this.product_detail_id = product_detail_id;
    }

    public Product() {
        this.product_name = product_name;
        this.category_id = category_id;
        this.product_detail_id = product_detail_id;
    }

    public String getProduct_name() {

        return product_name;

    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
}
