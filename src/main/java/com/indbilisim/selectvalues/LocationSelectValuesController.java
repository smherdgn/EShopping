package com.indbilisim.selectvalues;

import com.indbilisim.base.JsonListType;
import com.indbilisim.fieldsproperties.LocationFieldsPropertiesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Alper AKBULAK <alper.akbulak@indbilisim.com.tr>
 * @since 0.0.11
 * 20.10.2016
 */
@Controller
@RequestMapping(headers = "Accept=text/html", value = "/locationselectvalues")
public class LocationSelectValuesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationSelectValues.class);

    private static final String BASE_PATH = "/locationselectvalues/selectvalues-";

    private static final String PAGE_DEFAULT = "redirect:/locationselectvalues/search";

    private static final String PAGE_EDIT = BASE_PATH + "edit";

    private static final String PAGE_SEARCH = BASE_PATH + "search";

    private static final String PAGE_VIEW = BASE_PATH + "view";

    @Autowired
    LocationSelectValuesService locationSelectValuesService;

    @Autowired
    LocationFieldsPropertiesService locationFieldsPropertiesService;

    @RequestMapping(value = "/findbyTableNameAndFieldName", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<JsonListType> findByInput(@RequestParam("q") String searchText) {

        return locationFieldsPropertiesService.findByfieldNameContaining(searchText);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(Model model) {

        LocationSelectValues locationSelectValues = new LocationSelectValues();
        model.addAttribute("form", locationSelectValues);
        return PAGE_EDIT;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String getDelete(@PathVariable Long id) {

        LocationSelectValues locationSelectValues = locationSelectValuesService.findSelectValuesById(id);
        try {
            locationSelectValuesService.delete(locationSelectValues.getId());
            //MessageUtils.success("Property silindi.");
        } catch (Exception e) {
            //MessageUtils.error("Property silinemedi.");
            LOGGER.error("Delete error", e);
        }
        return PAGE_DEFAULT;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getEdit(Model model, @PathVariable Long id) {

        LocationSelectValues locationSelectValues = locationSelectValuesService.findSelectValuesById(id);
        if (locationSelectValues == null) {
            LOGGER.debug("Item not found");
            //MessageUtils.warning("Kayıt bulunamadı.");
            return PAGE_DEFAULT;
        }
        model.addAttribute("form", locationSelectValues);
        return PAGE_EDIT;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getSearch(Model model) {

        List<LocationSelectValues> locationSelectValuesList = locationSelectValuesService.findAll();
        model.addAttribute("items", locationSelectValuesList);
        return PAGE_SEARCH;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getView(Model model, @PathVariable Long id) {

        LocationSelectValues locationSelectValues = locationSelectValuesService.findSelectValuesById(id);
        if (locationSelectValues == null) {
            LOGGER.debug("Item not found");
            // MessageUtils.error("Kayıt Bulunamadı");
            return PAGE_DEFAULT;
        }
        model.addAttribute("form", locationSelectValues);
        return PAGE_VIEW;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postAdd(@Valid @ModelAttribute("form") LocationSelectValues form, BindingResult result) {

        if (result.hasErrors()) {
            LOGGER.debug("Validation error");
            //   MessageUtils.error("Form değerleri eksik yada yanlış");
            return PAGE_EDIT;
        }

        if (form.getLocationFieldsProperties() != null && form.getLocationFieldsProperties().getId() != null) {
            form.setLocationFieldsProperties(locationFieldsPropertiesService.findFieldsPropertiesById(form
                    .getLocationFieldsProperties().getId()));
        }
        locationSelectValuesService.save(form);
        //  MessageUtils.success("Kayıt Başarılı");
        LOGGER.debug("Data successfully Added");
        return PAGE_DEFAULT;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String postEdit(@Valid @ModelAttribute("form") LocationSelectValues form, BindingResult result,
                           @PathVariable Long id) {

        if (result.hasErrors()) {
            LOGGER.debug("Validation error");
            //   MessageUtils.error("Form değerleri eksik yada yanlıştır.");
            return PAGE_EDIT;
        }
        LocationSelectValues locationSelectValues = locationSelectValuesService.findSelectValuesById(id);
        if (locationSelectValues != null) {
            locationSelectValues.setLocationFieldsProperties(locationFieldsPropertiesService
                    .findFieldsPropertiesById(form.getLocationFieldsProperties().getId()));
            locationSelectValues.setSelectValue(form.getSelectValue());
            locationSelectValues.setLocationFieldsProperties(form.getLocationFieldsProperties());
            locationSelectValuesService.save(locationSelectValues);

            //    MessageUtils.success("Kayıt Güncelleme Başarılı");
            LOGGER.debug("Data Successfully Updated");
        }
        //  MessageUtils.error("Kayıt Güncelleme başarısız");
        LOGGER.debug("Data could not be updated");
        return PAGE_EDIT;
    }
}
