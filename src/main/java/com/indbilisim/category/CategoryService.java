package com.indbilisim.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ibrahimsengul
 * Created by ibrahimm on 6.7.2017.
 */

@Service
public class CategoryService {


    @Autowired
    CategoryRepository categoryRepository;


    public void categorySave(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> findCategoryAll ()
    {

       return categoryRepository.findAll();


    }

    public List<Category> getCategory(String adi)
    {
        return categoryRepository.getCategory(adi);
    }

}
