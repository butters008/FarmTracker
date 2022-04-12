package com.butterfield.farmtracker.controller;

import com.butterfield.farmtracker.database.dao.HerdDAO;
import com.butterfield.farmtracker.database.entity.Animal;
import com.butterfield.farmtracker.formBean.HerdFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
public class HerdController {

    @Autowired
    private HerdDAO herdDAO;

    //For right now I am going to hard code in list of cows
    @RequestMapping(value = "/herd/list", method = RequestMethod.GET)
    public ModelAndView listAllCows() throws Exception {
        ModelAndView response = new ModelAndView();

        List<Animal> animals = herdDAO.findByAnimalType("cow");
        response.addObject("cows", animals);

        return response;
    }

    //For right now I am going to hard code in list of cows
    @RequestMapping(value = "/herd/herdinfo", method = RequestMethod.GET)
    public ModelAndView getCowsById1(@RequestParam("cowId") String cowId) throws Exception {
        ModelAndView response = new ModelAndView();

        Animal animal = herdDAO.findByAnimalId1(cowId);
        log.info(animal.toString());

        response.setViewName("herd/herdinfo");
        response.addObject("cow", animal);
        return response;

    }

    @RequestMapping(value = "/herd/addAnimal", method = RequestMethod.GET)
    public ModelAndView addAnimalInital() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("herd/addAnimal");
        return response;
    }

    @RequestMapping(value = "/herd/animal", method = RequestMethod.GET)
    public ModelAndView setupAnimalPage(@Valid HerdFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("herd/addAnimal");
        return response;
    }


    @RequestMapping(value = "/herd/submitAnimal", method = RequestMethod.GET)
    public ModelAndView submitAnimal(@Valid HerdFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();

        //TODO: Will add error handling in later
        log.info(form.toString());

        //Putting the animal in the DB
        Animal animal = new Animal();
        animal.setAnimalId1(form.getAnimalId1());
        animal.setAnimalId2(form.getAnimalId2());
        animal.setAnimalType(form.getAnimalType());
        animal.setHerdStatus(form.getHerdStatus());
//        animal.setDateOfBirth(form.getDateOfBirth());
//        animal.setDateOfDeath(form.getDateOfDeath());

        log.info(animal.toString());

        herdDAO.save(animal);

        //TODO: Have redirect or something maybe later
        response.setViewName("herd/addAnimal");
        return response;
    }


}
