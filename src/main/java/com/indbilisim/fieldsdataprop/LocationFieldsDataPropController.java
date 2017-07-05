package com.indbilisim.fieldsdataprop;

import com.indbilisim.fieldsproperties.LocationFieldsPropertiesService;
import com.indbilisim.page.CustomPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Alper AKBULAK <alper.akbulak@indbilisim.com.tr>
 * @since 0.0.11
 * 18.10.2016
 */
@Controller
@RequestMapping(headers = "Accept=text/html", value = "/locationfieldsdataprop")
public class LocationFieldsDataPropController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationFieldsDataProp.class);

    private static final String BASE_PATH = "/locationfieldsdataprop/fieldsdataprop-";

    private static final String PAGE_DEFAULT = "redirect:/locationfieldsdataprop/search";

    private static final String PAGE_EDIT = BASE_PATH + "edit";

    private static final String PAGE_SEARCH = BASE_PATH + "search";

    private static final String PAGE_VIEW = BASE_PATH + "view";

    @Autowired
    LocationFieldsDataPropService locationFieldsDataPropService;

    @Autowired
    LocationFieldsPropertiesService locationFieldsPropertiesService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(Model model) {

        LocationFieldsDataProp locationFieldsDataProp = new LocationFieldsDataProp();
        model.addAttribute("form", locationFieldsDataProp);
        return PAGE_EDIT;
    }

    @RequestMapping(value = "/pageable", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public CustomPage getAllData(@RequestParam(value = "sort", required = false) String sortStr,
                                 @RequestParam(value = "order", required = false) String order,
                                 @RequestParam(value = "offset", required = false) int offset,
                                 @RequestParam(value = "limit", required = false) int limit) {

        Pageable pageable = new PageRequest(offset / limit, limit);

        Page<LocationFieldsDataProp> locationFieldsPropertiesList = locationFieldsDataPropService.findAll(pageable);
        CustomPage pageableCst = new CustomPage(locationFieldsPropertiesList);

        return pageableCst;

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String getDelete(@PathVariable Long id) {

        LocationFieldsDataProp locationFieldsDataProp = locationFieldsDataPropService.findFieldsDataPropById(id);
        try {
            locationFieldsDataPropService.delete(locationFieldsDataProp.getId());
            //MessageUtils.success("Property silindi");
        } catch (Exception e) {
            //  MessageUtils.error("Property silinemedi");
            LOGGER.error("Delete error", e);
        }
        return PAGE_DEFAULT;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getEdit(Model model, @PathVariable Long id) {

        LocationFieldsDataProp locationFieldsDataProp = locationFieldsDataPropService.findFieldsDataPropById(id);
        if (locationFieldsDataProp == null) {
            LOGGER.debug("Item not found");
            //  MessageUtils.warning("Kayıt Bulunamadı");
            return PAGE_DEFAULT;
        }
        model.addAttribute("form", locationFieldsDataProp);
        return PAGE_EDIT;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getSearch(Model model) {

        return PAGE_SEARCH;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getView(Model model, @PathVariable Long id) {

        LocationFieldsDataProp locationFieldsDataProp = locationFieldsDataPropService.findFieldsDataPropById(id);
        if (locationFieldsDataProp == null) {
            LOGGER.debug("Item not found");
            //  MessageUtils.error("Kayıt Bulunamadı");
            return PAGE_DEFAULT;
        }
        model.addAttribute("form", locationFieldsDataProp);
        return PAGE_VIEW;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postAdd(@Valid @ModelAttribute("form") LocationFieldsDataProp form, BindingResult result) {

        if (result.hasErrors()) {
            LOGGER.debug("Validation error");
            //   MessageUtils.error("Form değerleri eksik yada yanlış");
            return PAGE_EDIT;
        }
        if (form.getLocationFieldsPropertiess() != null && form.getLocationFieldsPropertiess().getId() != null) {
            form.setLocationFieldsPropertiess(locationFieldsPropertiesService.findFieldsPropertiesById(form
                    .getLocationFieldsPropertiess().getId()));
        }
        locationFieldsDataPropService.save(form);
        // MessageUtils.success("Kayıt Başarılıdır");
        LOGGER.debug("Data successfully Added");
        return PAGE_DEFAULT;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String postEdit(@Valid @ModelAttribute("form") LocationFieldsDataProp form, BindingResult result,
                           @PathVariable Long id) {

        if (result.hasErrors()) {
            LOGGER.debug("Validation error");
            // MessageUtils.error("Form değerleri eksik yada yanlış");
            return PAGE_EDIT;
        }
        LocationFieldsDataProp locationFieldsDataProp = locationFieldsDataPropService.findFieldsDataPropById(id);
        if (locationFieldsDataProp != null) {
            locationFieldsDataProp.setFieldValue(form.getFieldValue());
            locationFieldsDataProp.setTableId(form.getTableId());
            locationFieldsDataProp.setLocationFieldsPropertiess(form.getLocationFieldsPropertiess());

            locationFieldsDataPropService.save(locationFieldsDataProp);

            // MessageUtils.success("Kayıt güncelleme başarılı");
            LOGGER.debug("Data successfully Updated");
        }
        //  MessageUtils.error("Kayıt güncelleme başarısız");
        LOGGER.debug("Data could not be updated");
        return PAGE_EDIT;
    }
}
