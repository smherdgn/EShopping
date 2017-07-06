package com.indbilisim.fieldsdataprop;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.indbilisim.base.BaseEntity;
import com.indbilisim.fieldsproperties.LocationFieldsProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Alper AKBULAK <alper.akbulak@indbilisim.com.tr>
 * @since 0.0.11
 * <p/>
 * Bu properties tablosu olacak ve her tabloya göre içine kayıt eklenecektir.
 */
@Table(name = "X_LOCATION_FIELDSDATAPROP")
@Entity
public class LocationFieldsDataProp extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * Table ile bağlantı sağlamak için
     */
    @Column
    @NotNull
    private Long tableId;

    /**
     * value alanının içerisine field adı yazılacaktır.
     */
    @Column
    private String fieldValue;

    @JsonIgnore
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LocationFieldsProperties locationFieldsPropertiess;



    public String getFieldValue() {

        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {

        this.fieldValue = fieldValue;
    }

    public LocationFieldsProperties getLocationFieldsPropertiess() {

        return locationFieldsPropertiess;
    }

    public void setLocationFieldsPropertiess(LocationFieldsProperties locationFieldsProperties) {

        this.locationFieldsPropertiess = locationFieldsProperties;
    }

    public Long getTableId() {

        return tableId;
    }

    public void setTableId(Long tableId) {

        this.tableId = tableId;
    }

}
