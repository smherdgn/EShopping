package com.indbilisim.category;

import com.indbilisim.base.BaseEntity;

import javax.persistence.*;

/**
 * @author ibrahimsengul
 * Created by ibrahimm on 6.7.2017.
 */

@Table
@Entity
public class Category extends BaseEntity {




    private String categoryName ;
    private String categoryDescription;
    private String ustCategory;

    public String getUstCategory() {
        return ustCategory;
    }

    public void setUstCategory(String ustCategory) {
        this.ustCategory = ustCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
