package com.indbilisim.product;

import com.indbilisim.common.FormMode;
import com.indbilisim.customer.Customer;
import com.indbilisim.customer.CustomerService;
import com.indbilisim.product.ProductService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;



@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerService customerService;

    private Customer customer;

    protected static final String MODE        = "mode";
    protected static final String MODE_CREATE = "create";
    protected static final String MODE_UPDATE = "update";
    protected static final String SAVE_ACTION = "saveAction" ;
    protected static final String MODE_DELETE = "delete";


    //--- Variables names ( to be used in JSP with Expression Language )
    private static final String MAIN_ENTITY_NAME = "product";

    //--- JSP pages names ( View name in the MVC model )
    private static final String JSP_FORM   = "product/form";

    //--- SAVE ACTION ( in the HTML form )
    private static final String SAVE_ACTION_CREATE   = "/product/create";
    private static final String SAVE_ACTION_UPDATE   = "/product/update";

    @RequestMapping( value="/product",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)


   @ResponseBody
    public List<Product> findAllAsListItems() {

        List<Product> items = new LinkedList<Product>();
 {
            items.add(new Product( ) );
        }
        return items;
    }


    @RequestMapping("/insert")
    public String formForCreate(Model model) {

        //--- Populates the model with a new instance
        Product product = new Product();
        populateModel( model, product, FormMode.CREATE);
        model.addAttribute("form", new Product());
        return "/product/insert";
    }
    private void populateModel(Model model, Product product, FormMode formMode) {
        //--- Main entity
        model.addAttribute(MAIN_ENTITY_NAME, product);
        if ( formMode == FormMode.CREATE ) {
            model.addAttribute(MODE, MODE_CREATE); // The form is in "create" mode
            model.addAttribute(SAVE_ACTION, SAVE_ACTION_CREATE);
            //--- Other data useful in this screen in "create" mode (all fields)
        }
        else if ( formMode == FormMode.UPDATE ) {
            model.addAttribute(MODE, MODE_UPDATE); // The form is in "update" mode
            model.addAttribute(SAVE_ACTION, SAVE_ACTION_UPDATE);
            //--- Other data useful in this screen in "update" mode (only non-pk fields)
        }
        else if (formMode==FormMode.DELETE){
            model.addAttribute( MODE, MODE_DELETE );
        }
    }

}
