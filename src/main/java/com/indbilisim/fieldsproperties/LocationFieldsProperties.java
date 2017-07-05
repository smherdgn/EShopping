package com.indbilisim.fieldsproperties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.indbilisim.base.BaseEntity;
import com.indbilisim.fieldsdataprop.LocationFieldsDataProp;
import com.indbilisim.fieldsproperties.enums.LocationFieldsPropertiesType;
import com.indbilisim.fieldsproperties.enums.LocationFieldsTableNames;
import com.indbilisim.selectvalues.LocationSelectValues;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Table(name = "X_LOCATION_FIELDSPROPERTIES")
@Entity
public class LocationFieldsProperties extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * Diğer tablonun adının tutulacağı alan
     */

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private LocationFieldsTableNames tableName;

    /**
     * Kullanılacak alanın adı
     */
    @Column()
    @NotNull
    @Size(min = 2, max = 255)
    private String fieldName;

    /**
     * ENUM Kullanılacak
     */
    @NotNull
    @Enumerated(EnumType.STRING)
    private LocationFieldsPropertiesType fieldType;

    /**
     * isNullable alanın boş geçilip geçilemeyeceği özelliğini
     * tanımlayacaktır.
     */

    @NotNull
    @Column
    private boolean isNullable;

    /**
     * regExp ile istenirse regexp patterni
     * yazılabilmesini sağlayacağız
     */
    @Column
    private String regExp;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "locationFieldsPropertiess")
    private List<LocationFieldsDataProp> locationFieldsDataProp;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "locationFieldsProperties")
    private List<LocationSelectValues> locationSelectValuesList;


    public String getFieldName() {

        return fieldName;
    }

    public void setFieldName(String fieldName) {

        this.fieldName = fieldName;
    }

    public LocationFieldsPropertiesType getFieldType() {

        return fieldType;
    }

    public void setFieldType(LocationFieldsPropertiesType fieldType) {

        this.fieldType = fieldType;
    }

    public boolean getIsNullable() {

        return isNullable;
    }

    public void setIsNullable(boolean nullable) {

        isNullable = nullable;
    }

    public List<LocationFieldsDataProp> getLocationFieldsDataProp() {

        return locationFieldsDataProp;
    }

    public void setLocationFieldsDataProp(List<LocationFieldsDataProp> locationFieldsDataProp) {

        this.locationFieldsDataProp = locationFieldsDataProp;
    }

    public List<LocationSelectValues> getLocationSelectValuesList() {

        return locationSelectValuesList;
    }

    public void setLocationSelectValuesList(List<LocationSelectValues> locationSelectValuesList) {

        this.locationSelectValuesList = locationSelectValuesList;
    }

    public String getRegExp() {

        return regExp;
    }

    public void setRegExp(String regExp) {

        this.regExp = regExp;
    }

    public LocationFieldsTableNames getTableName() {

        return tableName;
    }

    public void setTableName(LocationFieldsTableNames tableName) {

        this.tableName = tableName;
    }

    public boolean isNullable() {

        return isNullable;
    }

    public void setNullable(boolean nullable) {

        isNullable = nullable;
    }
}
