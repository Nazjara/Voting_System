package com.nazjara.web;

import com.nazjara.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllRestaurantsWithMeals(Model model)
    {
        model.addAttribute("restaurants",restaurantService.getAllWithMenu());
        return "restaurants";
    }
}
