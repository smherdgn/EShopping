package com.indbilisim.selectvalues;

import com.indbilisim.base.BaseEntity;
import com.indbilisim.fieldsproperties.LocationFieldsProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Table(name = "X_LOCATION_SELECTVALUES")
@Entity
public class LocationSelectValues extends BaseEntity {

    @Column
    @NotNull
    @Size(min = 1, max = 255)
    private String selectValue;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LocationFieldsProperties locationFieldsProperties;

    public LocationFieldsProperties getLocationFieldsProperties() {

        return locationFieldsProperties;
    }

    public void setLocationFieldsProperties(LocationFieldsProperties locationFieldsProperties) {

        this.locationFieldsProperties = locationFieldsProperties;
    }

    public String getSelectValue() {

        return selectValue;
    }

    public void setSelectValue(String selectValue) {

        this.selectValue = selectValue;
    }
}
