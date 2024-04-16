package com.butterfield.farmtracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AnimalController {
    @RequestMapping(value = "/animal/animal-dashboard", method = RequestMethod.GET)
    public ModelAndView animal_dashboard_view() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("animal/animal-dashboard");
        System.out.println("Inside Animal Dashboard");



        return response;
    }

}
