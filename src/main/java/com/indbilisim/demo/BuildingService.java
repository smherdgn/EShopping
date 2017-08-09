package com.indbilisim.demo;

import com.indbilisim.product.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * ???
 *
 * @author Semih Erdoğan <semih.erdogan@indbilisim.com.tr>
 * @since 0.0.11
 */
@Service
@Transactional(readOnly = true)
public class BuildingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuildingService.class);


    @Autowired
    private BuildingRepository buildingRepository;

    @Transactional
    public void delete(Building building) {

        buildingRepository.delete(building);
    }

    public List<Building> findAll() {

        return buildingRepository.findAll();
    }

    /**
     * Retrieves an entity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the entity with the given id or {@literal null} if none found
     * @throws IllegalArgumentException if {@code id} is {@literal null}
     */
    public Building findById(Long id) {

        Building building = buildingRepository.findOne(id);

        return building;

    }


    public Page<Building> findByIdPage(Long id) {

        Building building = buildingRepository.findOne(id);
        List<Building> buildingList = new ArrayList<>();
        buildingList.add(building);
        Pageable pageable = new PageRequest(1, 1);
        Page<Building> buildingPage = new PageImpl<Building>(buildingList, pageable, 1);
        return buildingPage;

    }

    public boolean hasData() {

        return buildingRepository.count() > 0;
    }

    public Long getCount() {

        return buildingRepository.count();
    }


    /**
     * Saves the business instance and returns the newly saved instance.
     *
     * @param building the business to be saved
     * @return {@link Building} the business that has just been saved
     */
    @Transactional
    public boolean save(Building building) {

        boolean result;

            try {
                buildingRepository.save(building);
                result = true;
            } catch (Exception e) {
                result = false;
                LOGGER.error("Kayıt Yapılamadı" + e);
            }
            return result;
    }
}
