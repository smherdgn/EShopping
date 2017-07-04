package com.indbilisim.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * ???
 *
 * @author Semih Erdoğan <semih.erdogan@indbilisim.com.tr>
 * @since 0.0.11
 */
public interface BuildingRepository extends JpaRepository<Building, Long> {
}
