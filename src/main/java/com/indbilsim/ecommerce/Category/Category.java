package com.indbilsim.ecommerce.Category;

import com.indbilisim.base.BaseEntity;
import com.indbilsim.ecommerce.CategoryDetail.CategoryDetail;
import com.indbilsim.ecommerce.Product.Product;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * @author ibrahimsengul
 *         Created by ibrahimm on 10.7.2017.
 */

@Entity
public class Category extends BaseEntity {

    @NotNull
    private String categoryName;

    private String gender;

    @NotNull
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private CategoryDetail categoryDetail;

    @NotNull
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private Product product;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public CategoryDetail getCategoryDetail() {
        return categoryDetail;
    }

    public void setCategoryDetail(CategoryDetail categoryDetail) {
        this.categoryDetail = categoryDetail;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
