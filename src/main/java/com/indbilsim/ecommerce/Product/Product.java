package com.indbilsim.ecommerce.Product;

import com.indbilisim.base.BaseEntity;
import com.indbilsim.ecommerce.Category.Category;
import com.indbilsim.ecommerce.CategoryDetail.CategoryDetail;
import com.indbilsim.ecommerce.ProductDetail.ProductDetail;

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
public class Product extends BaseEntity {

    @NotNull
    private String productName;

    @NotNull
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private ProductDetail productDetail;

    @NotNull
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private CategoryDetail categoryDetail;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    public CategoryDetail getCategoryDetail() {
        return categoryDetail;
    }

    public void setCategoryDetail(CategoryDetail categoryDetail) {
        this.categoryDetail = categoryDetail;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
