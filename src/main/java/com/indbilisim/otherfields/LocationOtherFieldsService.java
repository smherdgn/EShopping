package com.indbilisim.otherfields;

import com.indbilisim.fieldsdataprop.LocationFieldsDataPropService;
import com.indbilisim.fieldsproperties.LocationFieldsProperties;
import com.indbilisim.fieldsproperties.LocationFieldsPropertiesService;
import com.indbilisim.fieldsproperties.enums.LocationFieldsPropertiesType;
import com.indbilisim.fieldsproperties.enums.LocationFieldsTableNames;
import com.indbilisim.selectvalues.LocationSelectValuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Semih Erdoğan <semih.erdogan@indbilisim.com.tr>
 * @since 0.0.3
 */
@Service
@Transactional
public class LocationOtherFieldsService {

    @Autowired
    LocationFieldsPropertiesService locationFieldsPropertiesService;

    @Autowired
    LocationFieldsDataPropService locationFieldsDataPropService;

    @Autowired
    LocationSelectValuesService locationSelectValuesService;

    public List<LocationOtherFields> fillFieldsDataBytableId(LocationFieldsTableNames tableName, Long tableId) {

        List<LocationOtherFields> fieldsList = new ArrayList<>();
        List<LocationFieldsProperties> locationFieldsPropertiesList = locationFieldsPropertiesService
                .findBytableName(tableName);

        for (LocationFieldsProperties prop : locationFieldsPropertiesList) {
            LocationOtherFields other = new LocationOtherFields();
            other.setLocationFieldsProperties(prop);
            if (other.getLocationFieldsProperties().getFieldType() == LocationFieldsPropertiesType.SELECT) {
                other.setLocationSelectValues(locationSelectValuesService.findByfieldsProperties(prop));
            }
            other.setLocationFieldsDataProp(locationFieldsDataPropService.findByfieldsPropertiessAndTableId(
                    other.getLocationFieldsProperties(), tableId));
            fieldsList.add(other);
        }
        return fieldsList;

    }

    public List<LocationOtherFields> findFieldsBytableName(LocationFieldsTableNames tableName) {

        List<LocationOtherFields> fieldsList = new ArrayList<>();

        List<LocationFieldsProperties> locationFieldsPropertiesList = locationFieldsPropertiesService
                .findBytableName(tableName);

        for (LocationFieldsProperties prop : locationFieldsPropertiesList) {
            LocationOtherFields other = new LocationOtherFields();
            other.setLocationFieldsProperties(prop);
            if (other.getLocationFieldsProperties().getFieldType() == LocationFieldsPropertiesType.SELECT) {
                other.setLocationSelectValues(locationSelectValuesService.findByfieldsProperties(prop));
            }
            fieldsList.add(other);
        }
        return fieldsList;
    }

    public List<LocationOtherFields> saveDatas(List<LocationOtherFields> locationOtherFieldses, Long tableId) {

        for (LocationOtherFields other : locationOtherFieldses) {
            other.getLocationFieldsDataProp().setTableId(tableId);
            locationFieldsDataPropService.save(other.getLocationFieldsDataProp());
        }
        return locationOtherFieldses;
    }

}
