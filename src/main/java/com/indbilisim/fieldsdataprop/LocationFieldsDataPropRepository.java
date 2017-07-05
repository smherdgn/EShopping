package com.indbilisim.fieldsdataprop;

import com.indbilisim.fieldsproperties.LocationFieldsProperties;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Alper AKBULAK <alper.akbulak@indbilisim.com.tr>
 * @since 0.0.3
 * 18.10.2016
 */
public interface LocationFieldsDataPropRepository extends JpaRepository<LocationFieldsDataProp, Long> {

    LocationFieldsDataProp findByLocationFieldsPropertiessAndTableId(
            LocationFieldsProperties locationFieldsPropertiess, Long tableId);
}
