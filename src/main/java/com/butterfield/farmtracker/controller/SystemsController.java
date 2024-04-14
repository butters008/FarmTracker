package com.butterfield.farmtracker.controller;

import com.butterfield.farmtracker.database.dao.TypeDAO;
import com.butterfield.farmtracker.database.entity.Type;
import com.butterfield.farmtracker.formBean.TypeFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
public class SystemsController {

    @Autowired
    private TypeDAO typeDAO;

    @RequestMapping(value = "/systems/systems-dashboard", method = RequestMethod.GET)
    public ModelAndView systems_dashboard_view() throws Exception {
        ModelAndView response = new ModelAndView();

        //TODO: Going to have to refactor once I re-implement Auth
        List<Type> typeList = typeDAO.findAll();

        System.out.println(typeList.size());
        response.addObject("typesList", typeList);

        response.setViewName("systems/systems-dashboard");
        return response;
    }

    @RequestMapping(value = "/systems/add_new_type", method = RequestMethod.POST)
    public ModelAndView add_new_type(@Valid TypeFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        Type type = new Type();
        type.setType_id(form.getType_id());
        type.setType_name(form.getType_name());
        typeDAO.save(type);

        response.setViewName("systems/systems-dashboard");
        return response;
    }
}
