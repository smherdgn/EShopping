package com.indbilisim.otherfields;

import com.indbilisim.fieldsdataprop.LocationFieldsDataProp;
import com.indbilisim.fieldsproperties.LocationFieldsProperties;
import com.indbilisim.selectvalues.LocationSelectValues;

import java.util.List;

/**
 * @Author Semih Erdoğan <semih.erdogan@indbilisim.com.tr>
 * @since 0.0.3
 */
public class LocationOtherFields {

    private LocationFieldsProperties locationFieldsProperties;

    private LocationFieldsDataProp locationFieldsDataProp;

    private List<LocationSelectValues> locationSelectValues;

    public LocationFieldsDataProp getLocationFieldsDataProp() {

        return locationFieldsDataProp;
    }

    public void setLocationFieldsDataProp(LocationFieldsDataProp locationFieldsDataProp) {

        this.locationFieldsDataProp = locationFieldsDataProp;
    }

    public LocationFieldsProperties getLocationFieldsProperties() {

        return locationFieldsProperties;
    }

    public void setLocationFieldsProperties(LocationFieldsProperties locationFieldsProperties) {

        this.locationFieldsProperties = locationFieldsProperties;
    }

    public List<LocationSelectValues> getLocationSelectValues() {

        return locationSelectValues;
    }

    public void setLocationSelectValues(List<LocationSelectValues> locationSelectValues) {

        this.locationSelectValues = locationSelectValues;
    }
}
