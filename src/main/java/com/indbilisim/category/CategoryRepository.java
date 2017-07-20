package com.indbilisim.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author ibrahimsengul
 * Created by ibrahimm on 6.7.2017.
 */


public interface CategoryRepository extends JpaRepository<Category,Long > {

    @Query(value = "select c from Category as c where c.categoryName=:adi")
    public List<Category> getCategory(@Param("adi") String adi);

}
