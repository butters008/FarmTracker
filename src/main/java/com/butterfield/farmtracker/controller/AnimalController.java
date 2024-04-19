package com.butterfield.farmtracker.controller;

import com.butterfield.farmtracker.database.dao.TypeDAO;
import com.butterfield.farmtracker.database.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AnimalController {
    @Autowired
    TypeDAO typeDAO;

    @RequestMapping(value = "/animal/animal-dashboard", method = RequestMethod.GET)
    public ModelAndView animal_dashboard_view() throws Exception {
        ModelAndView response = new ModelAndView();

        List<Type> typeList = typeDAO.findAll();
        response.addObject("typeList", typeList);

        response.setViewName("animal/animal-dashboard");
        System.out.println("Inside Animal Dashboard");



        return response;
    }

}
