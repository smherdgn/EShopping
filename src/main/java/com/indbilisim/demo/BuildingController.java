package com.indbilisim.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * ???
 *
 * @author Semih Erdoğan <semih.erdogan@indbilisim.com.tr>
 * @since 0.0.11
 */
@Controller
@RequestMapping(headers = "Accept=text/html", value = "/building")
public class BuildingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuildingController.class);

    private static final String BASE_PATH = "/building/building-";



    private static final String PAGE_SEARCH = BASE_PATH + "search";

    @Autowired
    private BuildingService buildingService;


    @Autowired(required = true)
    private HttpServletRequest request;


    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String getAdd(Model model) {


        return PAGE_SEARCH;
    }




}
