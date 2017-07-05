package com.indbilisim.fieldsdataprop;

import com.indbilisim.fieldsproperties.LocationFieldsProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Alper AKBULAK <alper.akbulak@indbilisim.com.tr>
 * @since 0.0.3
 * 18.10.2016
 */
@Service
@Transactional(readOnly = true)
public class LocationFieldsDataPropService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationFieldsDataProp.class);

    @Autowired
    private LocationFieldsDataPropRepository locationFieldsDataPropRepository;

    @Transactional
    public boolean delete(Long fieldsDataPropId) {

        LocationFieldsDataProp locationFieldsDataProp1 = locationFieldsDataPropRepository.findOne(fieldsDataPropId);
        locationFieldsDataPropRepository.delete(locationFieldsDataProp1);
        return true;
    }

    /**
     * Bütün propertyleri dönecektir.
     *
     * @return all properties of FieldsDataProps
     */
    public List<LocationFieldsDataProp> findAll() {

        List<LocationFieldsDataProp> locationFieldsDataPropList = locationFieldsDataPropRepository.findAll();
        return locationFieldsDataPropList;
    }

    /**
     * Bütün propertyleri dönecektir.
     *
     * @return all properties of FieldsDataProps
     */
    public Page<LocationFieldsDataProp> findAll(Pageable pageable) {

        Page<LocationFieldsDataProp> locationFieldsDataPropList = locationFieldsDataPropRepository.findAll(pageable);
        return locationFieldsDataPropList;
    }

    @Transactional
    public LocationFieldsDataProp findByfieldsPropertiessAndTableId(LocationFieldsProperties locationFieldsProperties,
                                                                    Long tableId) {

        LocationFieldsDataProp locationFieldsDataProp = null;
        try {
            locationFieldsDataProp = locationFieldsDataPropRepository.findByLocationFieldsPropertiessAndTableId(
                    locationFieldsProperties, tableId);
        } catch (Exception e) {
            LOGGER.error("Kayıt Bulunamadı" + e.getMessage());
        }
        return locationFieldsDataProp;
    }

    /**
     * @param id
     * @return fieldsDataProp datası döner
     */
    public LocationFieldsDataProp findFieldsDataPropById(Long id) {

        return locationFieldsDataPropRepository.findOne(id);
    }

    /**
     * hasData data var mı? Kontrolü için count 0'dan büyükse true dönecek
     */
    public boolean hasData() {

        return locationFieldsDataPropRepository.count() > 0;
    }

    @Transactional
    public LocationFieldsDataProp save(LocationFieldsDataProp locationFieldsDataProp) {

        try {
            locationFieldsDataPropRepository.save(locationFieldsDataProp);
        } catch (Exception e) {
            LOGGER.warn("Kayıt Yapılamadı" + e.getMessage());
        }
        return locationFieldsDataProp;
    }

}
