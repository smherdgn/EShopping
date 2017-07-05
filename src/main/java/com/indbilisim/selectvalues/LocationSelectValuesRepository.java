package com.indbilisim.selectvalues;

import com.indbilisim.fieldsproperties.LocationFieldsProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author aakbulak <alper.akbulak@indbilisim.com.tr>
 * @since 0.0.3
 * 20.10.2016
 */
public interface LocationSelectValuesRepository extends JpaRepository<LocationSelectValues, Long> {

    List<LocationSelectValues> findByLocationFieldsProperties(LocationFieldsProperties locationFieldsProperties);
}
