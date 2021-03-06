package com.indbilisim.category;

import com.indbilisim.common.FormMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;
import java.util.SplittableRandom;

/**
 * @author ibrahimsengul
 * Created by ibrahimm on 6.7.2017.
 */


@Controller
@RequestMapping("/categoryAdd")
public class CategoryController {


    @Autowired
    CategoryService categoryService;





    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String category(Model model) {
        model.addAttribute("categoryForm", new Category());
        model.addAttribute("categoryList",categoryService.findCategoryAll());
        model.addAttribute("options", FormMode.values());
        return "category/category";
    }



  /*  @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String getCategory(Model model, @ModelAttribute("form") Category category) {


        model.addAttribute("getCategoryAll", categoryService.findCategoryAll());


        return "/category";
    } */


    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public String getCategory(@ModelAttribute("categoryForm") Category categoryForm,FormMode options) {

            categoryService.categorysave(categoryForm);



        return "redirect:/categoryAdd/category";
    }



}
