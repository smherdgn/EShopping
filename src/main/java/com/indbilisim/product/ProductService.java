package com.indbilisim.product;

import com.indbilisim.common.FormMode;
import com.indbilisim.demo.BuildingService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
@Transactional(readOnly = true)
@Service
public class ProductService {


    @PersistenceContext
    private EntityManager em;
    @Autowired
    private ProductRepository productRepository;


    @Transactional
    public boolean save(Product product) {

        boolean result;
        try {

            productRepository.save(product);
            result = true;
        } catch (Exception e) {
            result = false;
        }
        return result;

    }

    public Page<Product> findByIdPage(Long id) {

        Product product = productRepository.findOne(id);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        Pageable pageable = new PageRequest(1, 1);
        Page<Product> productPage = new PageImpl<Product>(productList, pageable, 1);
        return productPage;
    }



    public boolean hasData() {

        return productRepository.count() > 0;
    }



    public Product findById(Long id) {

        Product product = productRepository.findOne(id);

        return product;
    }

    @Transactional
    public void delete(Product product) {

        productRepository.delete(product);
    }





}
