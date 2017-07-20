package com.indbilisim.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String getCategory(Model model, @ModelAttribute("form") Category category) {



        model.addAttribute("message","deneme deneme");

        model.addAttribute("categoryList", categoryService.getCategory   ("abc"));

        model.addAttribute("getCategoryAll", categoryService.findCategoryAll());


        return "/category";
    }


    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public String getCategoryy(Category category) {

        categoryService.categorySave(category);

        return "redirect:/categoryAdd/category";
    }


}
