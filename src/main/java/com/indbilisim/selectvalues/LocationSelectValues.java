package com.indbilisim.selectvalues;

import com.indbilisim.base.BaseEntity;
import com.indbilisim.fieldsproperties.LocationFieldsProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author aakbulak <alper.akbulak@indbilisim.com.tr>
 * @since 0.0.3
 * 20.10.2016
 * LocationSelectValues alanında FieldProperties dataları tutulacak
 */
@Table(name = "X_LOCATION_SELECTVALUES", indexes = {
        @Index(name = "X_Location_SelectValues_" + "selectValue" + "_Indx", columnList = "selectValue"),
        @Index(name = "X_Location_FieldsDataProp_" + "locationfieldsproperties_id" + "_Indx", columnList = "locationfieldsproperties_id")})
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
