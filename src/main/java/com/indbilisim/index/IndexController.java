package com.indbilisim.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by semih on 19.07.2017.
 */
@Controller
@RequestMapping(headers = "Accept=text/html", value = "/index")
public class IndexController {

    private static final String BASE_PATH = "/index/index";


    @RequestMapping(method = RequestMethod.GET)
    public String getAdd(Model model) {


        return BASE_PATH;
    }

}
