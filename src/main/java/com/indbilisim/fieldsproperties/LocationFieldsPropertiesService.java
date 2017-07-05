package com.indbilisim.fieldsproperties;

import com.indbilisim.base.JsonListType;
import com.indbilisim.fieldsproperties.enums.LocationFieldsTableNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alper AKBULAK <alper.akbulak@indbilisim.com.tr>
 * @since 0.0.11
 * 20.10.2016
 */
@Service
@Transactional(readOnly = true)
public class LocationFieldsPropertiesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationFieldsProperties.class);

    @Autowired
    private LocationFieldsPropertiesRepository locationFieldsPropertiesRepository;

    @Transactional
    public boolean delete(Long id) {

        LocationFieldsProperties locationFieldsProperties = locationFieldsPropertiesRepository.findOne(id);
        locationFieldsPropertiesRepository.delete(locationFieldsProperties);
        return true;
    }

    public Page<LocationFieldsProperties> findAll(Pageable pageable) {

        Page<LocationFieldsProperties> locationFieldsPropertiesList = locationFieldsPropertiesRepository
                .findAll(pageable);
        return locationFieldsPropertiesList;
    }

    public List<JsonListType> findByfieldNameContaining(String searchKeys) {

        List<LocationFieldsProperties> buildings = locationFieldsPropertiesRepository
                .findByfieldNameContaining(searchKeys);

        List<JsonListType> result = new ArrayList<>();
        List<JsonListType> childs = new ArrayList<>();
        JsonListType jsonListGroup = new JsonListType();

        for (LocationFieldsProperties locationFieldsProperties : buildings) {
            JsonListType jsonListChild = new JsonListType();
            jsonListChild.setId(locationFieldsProperties.getId());
            jsonListChild.setText(locationFieldsProperties.getTableName() + "."
                    + locationFieldsProperties.getFieldName());
            childs.add(jsonListChild);
        }
        jsonListGroup.setChildren(childs);
        result.add(jsonListGroup);
        return result;
    }

    @Transactional
    public List<LocationFieldsProperties> findBytableName(LocationFieldsTableNames tableNames) {

        List<LocationFieldsProperties> locationFieldsPropertiesList = null;

        locationFieldsPropertiesList = locationFieldsPropertiesRepository.findBytableName(tableNames);

        return locationFieldsPropertiesList;
    }

    /**
     * @param id
     * @return fieldsProperties datası döner
     */
    public LocationFieldsProperties findFieldsPropertiesById(Long id) {

        return locationFieldsPropertiesRepository.findOne(id);
    }

    /**
     * hasData data var mı? Kontrolü için count 0'dan büyükse true dönecek
     */
    public boolean hasData() {

        return locationFieldsPropertiesRepository.count() > 0;
    }

    @Transactional
    public LocationFieldsProperties save(LocationFieldsProperties locationFieldsProperties) {

        try {
            locationFieldsPropertiesRepository.save(locationFieldsProperties);
        } catch (Exception e) {
            LOGGER.warn("Kayıt yapılamadı " + e.getMessage());
        }
        return locationFieldsProperties;
    }
}
