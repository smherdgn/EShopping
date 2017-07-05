package com.indbilisim.selectvalues;

import com.indbilisim.fieldsproperties.LocationFieldsProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author aakbulak <alper.akbulak@indbilisim.com.tr>
 * @since 0.0.3
 * 20.10.2016
 */
@Service
@Transactional(readOnly = true)
public class LocationSelectValuesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationSelectValues.class);

    @Autowired
    private LocationSelectValuesRepository locationSelectValuesRepository;

    @Transactional
    public boolean delete(Long id) {

        LocationSelectValues locationSelectValues = locationSelectValuesRepository.findOne(id);
        locationSelectValuesRepository.delete(locationSelectValues);
        return true;

    }

    /**
     * @return SelectValue datalarını liste şeklinde döner
     */
    public List<LocationSelectValues> findAll() {

        List<LocationSelectValues> locationSelectValuesList = locationSelectValuesRepository.findAll();
        return locationSelectValuesList;
    }

    public List<LocationSelectValues> findByfieldsProperties(LocationFieldsProperties locationFieldsProperties) {

        List<LocationSelectValues> locationSelectValuesList = locationSelectValuesRepository
                .findByLocationFieldsProperties(locationFieldsProperties);
        return locationSelectValuesList;
    }

    /**
     * @param id
     * @return SelectValue datalarını object olarak döner
     */
    public LocationSelectValues findSelectValuesById(Long id) {

        return locationSelectValuesRepository.findOne(id);
    }

    /**
     * hasData data var mı?
     */
    public boolean hasData() {

        return locationSelectValuesRepository.count() > 0;
    }

    @Transactional
    public LocationSelectValues save(LocationSelectValues locationSelectValues) {

        try {
            locationSelectValuesRepository.save(locationSelectValues);
        } catch (Exception e) {
            LOGGER.warn("Kayıt Yapılamadı" + e.getMessage());
        }
        return locationSelectValues;
    }
}
