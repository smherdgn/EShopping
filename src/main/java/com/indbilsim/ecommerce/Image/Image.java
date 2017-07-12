package com.indbilsim.ecommerce.Image;

import com.indbilisim.base.BaseEntity;
import com.indbilsim.ecommerce.ProductDetail.ProductDetail;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * @author ibrahimsengul
 *         Created by ibrahimm on 10.7.2017.
 */
@Entity
public class Image extends BaseEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductDetail productDetail;

    @Lob
    private byte[] imageBytes;

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }
}
