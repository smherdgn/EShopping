package com.indbilisim.fieldsproperties;

import com.indbilisim.fieldsproperties.enums.LocationFieldsIsNull;
import com.indbilisim.fieldsproperties.enums.LocationFieldsPropertiesType;
import com.indbilisim.fieldsproperties.enums.LocationFieldsTableNames;
import com.indbilisim.page.CustomPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;

/**
 * @author Alper AKBULAK <alper.akbulak@indbilisim.com.tr>
 * @since 0.0.11
 * 20.10.2016
 */
@Controller
@RequestMapping(headers = "Accept=text/html", value = "/locationfieldsproperties")
public class LocationFieldsPropertiesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationFieldsProperties.class);

    private static final String BASE_PATH = "/locationfieldsproperties/fieldsproperties-";

    private static final String PAGE_DEFAULT = "redirect:/locationfieldsproperties/search";

    private static final String PAGE_EDIT = BASE_PATH + "edit";

    private static final String PAGE_SEARCH = BASE_PATH + "search";

    private static final String PAGE_VIEW = BASE_PATH + "view";

    @Autowired
    LocationFieldsPropertiesService locationFieldsPropertiesService;


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(Model model) {

        LocationFieldsProperties locationFieldsProperties = new LocationFieldsProperties();
        model.addAttribute("form", locationFieldsProperties);
        modelDefauldValues(model);
        return PAGE_EDIT;
    }

    @RequestMapping(value = "/pageable", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public CustomPage getAllData(@RequestParam(value = "sort", required = false) String sortStr,
                                 @RequestParam(value = "order", required = false) String order,
                                 @RequestParam(value = "offset", required = false) int offset,
                                 @RequestParam(value = "limit", required = false) int limit) {

        Pageable pageable = new PageRequest(offset / limit, limit);

        Page<LocationFieldsProperties> locationFieldsPropertiesList = locationFieldsPropertiesService.findAll(pageable);
        CustomPage pageableCst = new CustomPage(locationFieldsPropertiesList);

        return pageableCst;

    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String getDelete(@PathVariable Long id) {

        LocationFieldsProperties locationFieldsProperties = locationFieldsPropertiesService
                .findFieldsPropertiesById(id);
        try {
            locationFieldsPropertiesService.delete(locationFieldsProperties.getId());
            //MessageUtils.success(translator.getMessage("general.success.deleted"));
        } catch (Exception e) {
            //   MessageUtils.error(translator.getMessage("general.error.notdeleted"));
            LOGGER.error("Delete error ", e);
        }
        return PAGE_DEFAULT;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getEdit(Model model, @PathVariable Long id) {

        LocationFieldsProperties locationFieldsProperties = locationFieldsPropertiesService
                .findFieldsPropertiesById(id);
        if (locationFieldsProperties == null) {
            LOGGER.debug("Item not found");
            //  MessageUtils.error(translator.getMessage("general.error.datanotfound"));
            return PAGE_DEFAULT;
        }

        modelDefauldValues(model);
        model.addAttribute("form", locationFieldsProperties);
        return PAGE_EDIT;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getSearch(Model model) {

        return PAGE_SEARCH;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getView(Model model, @PathVariable Long id) {

        LocationFieldsProperties locationFieldsProperties = locationFieldsPropertiesService
                .findFieldsPropertiesById(id);
        if (locationFieldsProperties == null) {
            LOGGER.debug("Item Not Found");
            // MessageUtils.error(translator.getMessage("general.error.datanotfound"));
            return PAGE_DEFAULT;
        }
        model.addAttribute("form", locationFieldsProperties);
        return PAGE_VIEW;
    }

    private void modelDefauldValues(Model model) {

        model.addAttribute("fieldsPropertiesTypes", Arrays.asList(LocationFieldsPropertiesType.values()));
        model.addAttribute("locationFieldsTableNames", Arrays.asList(LocationFieldsTableNames.values()));
        model.addAttribute("fieldsIsNull", Arrays.asList(LocationFieldsIsNull.values()));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postAdd(Model model, @Valid @ModelAttribute("form") LocationFieldsProperties form,
                          // @RequestParam(value = "txtEmail", required = false) String isNull,
                          BindingResult result) {

        if (result.hasErrors()) {
            LOGGER.debug("Validation error");
            //  MessageUtils.error(translator.getMessage("general.error.formdataNotFound"));
            modelDefauldValues(model);
            return PAGE_EDIT;
        }
        try {
            locationFieldsPropertiesService.save(form);
        } catch (TransactionSystemException es) {
            //   MessageUtils.error(translator.getMessage("general.error.uniqeConstraintException"));
            modelDefauldValues(model);
            return PAGE_EDIT;
        }

        //  MessageUtils.success(translator.getMessage("general.success.saved"));
        LOGGER.debug("Data successfully Added");
        return PAGE_DEFAULT;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String postEdit(Model model, @Valid @ModelAttribute("form") LocationFieldsProperties form,
                           BindingResult result, @PathVariable Long id) {

        modelDefauldValues(model);
        if (result.hasErrors()) {
            LOGGER.debug("Validation error");
            //     MessageUtils.error(translator.getMessage("general.error.formdataNotFound"));

            return PAGE_EDIT;
        }
        LocationFieldsProperties locationFieldsProperties = locationFieldsPropertiesService
                .findFieldsPropertiesById(id);
        if (locationFieldsProperties != null) {
            locationFieldsProperties.setTableName(form.getTableName());
            locationFieldsProperties.setFieldName(form.getFieldName());
            locationFieldsProperties.setIsNullable(form.getIsNullable());
            locationFieldsProperties.setRegExp(form.getRegExp());
            locationFieldsProperties.setFieldType(form.getFieldType());
            locationFieldsProperties.setLocationSelectValuesList(form.getLocationSelectValuesList());
            locationFieldsPropertiesService.save(locationFieldsProperties);

            //   MessageUtils.success(translator.getMessage("general.success.updated"));
            LOGGER.debug("Data successfully Updated");
        }

        return PAGE_DEFAULT;
    }

}
