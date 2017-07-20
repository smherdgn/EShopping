package com.indbilisim.category;

import com.indbilisim.base.BaseEntity;

/**
 * Created by alikumru on 12.07.2017.
 */
public class Category extends BaseEntity {
    private String category_name;
    private String category_gender;

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_gender() {
        return category_gender;
    }


    public void setCategory_gender(String category_gender) {
        this.category_gender = category_gender;
    }
}
