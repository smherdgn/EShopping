package com.indbilisim.fieldsproperties;

import com.indbilisim.fieldsproperties.enums.LocationFieldsTableNames;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Alper AKBULAK <alper.akbulak@indbilisim.com.tr>
 * @since 0.0.11
 *        20.10.2016
 */
public interface LocationFieldsPropertiesRepository extends JpaRepository<LocationFieldsProperties, Long> {

    Page<LocationFieldsProperties> findAll(Pageable pageable);

    List<LocationFieldsProperties> findByfieldNameContaining(String fieldName);

    List<LocationFieldsProperties> findBytableName(LocationFieldsTableNames tableName);
}
