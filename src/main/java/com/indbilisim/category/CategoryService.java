package com.indbilisim.category;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author ibrahimsengul
 * Created by ibrahimm on 6.7.2017.
 */

@Service
public class CategoryService {


    @Autowired
    CategoryRepository categoryRepository;

    private static final Logger LOGGER = Logger.getLogger( Category.class.getName() );

    public boolean categorysave(Category category) {

        boolean result;

            try {
                categoryRepository.save(category);
                result = true;
            } catch (Exception e) {
                result = false;
                LOGGER.info("Kayıt Yapılamadı" + e);
            }
            return result;
        }


    public void categoryDelete (Category category){

        categoryRepository.delete(category);
    }

    public void update(Category category){


    }

    public List<Category> findCategoryAll ()
    {

       return categoryRepository.findAll();
    }



}
