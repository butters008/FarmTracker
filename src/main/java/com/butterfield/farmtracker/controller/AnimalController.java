package com.butterfield.farmtracker.controller;

import com.butterfield.farmtracker.database.dao.Farm_AnimalDAO;
import com.butterfield.farmtracker.database.dao.TypeDAO;
import com.butterfield.farmtracker.database.dao.UserDAO;
import com.butterfield.farmtracker.database.dao.User_Farm_AnimalDAO;
import com.butterfield.farmtracker.database.entity.Farm_Animal;
import com.butterfield.farmtracker.database.entity.Type;
import com.butterfield.farmtracker.database.entity.User;
import com.butterfield.farmtracker.database.entity.User_Farm_Animals;
import com.butterfield.farmtracker.formBean.Farm_Animal_FormBean;
import com.butterfield.farmtracker.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
public class AnimalController {
    @Autowired
    TypeDAO typeDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    Farm_AnimalDAO  farm_animalDAO;

    @Autowired
    User_Farm_AnimalDAO user_farm_animalDAO;

    @Autowired
    private SecurityService securityService = new SecurityService();

    @RequestMapping(value = "/animal/animal-dashboard", method = RequestMethod.GET)
    public ModelAndView animal_dashboard_view() throws Exception {
        ModelAndView response = new ModelAndView();

        List<Type> typeList = typeDAO.findAll();
        response.addObject("typeList", typeList);

        for(int i = 0; i < typeList.size(); i++){
            System.out.println(typeList.get(i));
        }

        response.setViewName("animal/animal-dashboard");

        return response;
    }

    @RequestMapping(value = "/animal/animal-save", method = RequestMethod.GET)
    public ModelAndView animal_save_in_DB(@Valid Farm_Animal_FormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();
        User userLoggedIn = securityService.getLoggedInUser();
        Farm_Animal farm_animal;
        User_Farm_Animals user_farm_animals = null;
        boolean new_animal = false;

        if (bindingResult.hasErrors()) {
            if(farm_animalDAO.findById(Long.valueOf(form.getId())) == null){
                farm_animal = new Farm_Animal();
                new_animal = true;
            }
            else{
                farm_animal = farm_animalDAO.getById(Long.valueOf(form.getId()));
            }

            farm_animal.setName(form.getName());
            farm_animal.setAlt_name(form.getAlt_name());
            farm_animal.setType(form.getType());
            farm_animal.setSex(form.getSex());
            farm_animal.setDead(form.getDead());
            farm_animal.setSold(form.getSold());
            farm_animal.setNote(form.getNote());

            farm_animalDAO.save(farm_animal);

            if (new_animal) {
                user_farm_animals = new User_Farm_Animals();
                user_farm_animals.setFarm_animal_id(farm_animal);
                user_farm_animals.setUser_id(userLoggedIn);
                user_farm_animalDAO.save(user_farm_animals);
            }
        }
        
        response.setViewName("animal/animal-dashboard");

        return response;
    }

}
