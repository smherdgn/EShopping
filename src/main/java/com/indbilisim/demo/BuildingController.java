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

    private static final String PAGE_DEFAULT = "redirect:/building/search";

    private static final String PAGE_EDIT = BASE_PATH + "edit";

    private static final String PAGE_SEARCH = BASE_PATH + "search";

    private static final String PAGE_VIEW = BASE_PATH + "view";

    private static final String PAGE_QUERY = BASE_PATH + "query";

    private static final String PAGE_POPUP = BASE_PATH + "popup";


    @Autowired
    private BuildingService buildingService;


    @Autowired(required = true)
    private HttpServletRequest request;


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(Model model) {


        return PAGE_EDIT;
    }


    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String getQuery(Model model) {

        model.addAttribute("items", buildingService.findAll());
        return PAGE_QUERY;
    }

    @RequestMapping(value = "/popup", method = RequestMethod.GET)
    public String getQuery(Model model, @RequestParam(value = "uavt", required = false) String uavt) {

        model.addAttribute("uavt", uavt);
        return PAGE_POPUP;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getSearch(Model model) {

        return PAGE_SEARCH;
    }

    /*
     * @RequestMapping(value = "/files", method = RequestMethod.GET, produces = "application/json")
     * @ResponseBody
     * public List<String> getFiles(@RequestParam(value = "referenceid", required = false) String referenceId)
     * {
     * List<String> inboxLists = new ArrayList<>();
     * List<Pair<String, String>> listPair = new ArrayList<>();
     * Pair<String, String> pair = new ImmutablePair<>("referenceid", referenceId);
     * listPair.add(pair);
     * List<RecordComponent> components = searchService.getResults(listPair, "OR");
     * String documents = "";
     * for (int i = 0; i < components.size(); i++) {
     * if (components.get(i).getMimeType().startsWith("image")) {
     * documents = components.get(i).getObjectId() + ";" + components.get(i).getName();
     * inboxLists.add(documents);
     * }
     * }
     * return inboxLists;
     * }
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getView(Model model, @PathVariable Long id) {

        Building building = buildingService.findById(id);

        if (building == null) {
            LOGGER.debug("Item not found");

            return PAGE_DEFAULT;
        }
        model.addAttribute("form", building);

        return PAGE_VIEW;

    }


}
