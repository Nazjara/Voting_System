package com.nazjara.web;

import com.nazjara.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    public String getAllRestaurantsWithMeals(Model model)
    {
        model.addAttribute("restaurants",restaurantService.getAll());
        return "restaurants";
    }

    @RequestMapping(value = "/results", method = RequestMethod.POST)
    public String getVoteResults(HttpServletRequest request, Model model)
    {
        int restaurantId = Integer.parseInt(request.getParameter("answer"));
        restaurantService.addVote(restaurantId);
        model.addAttribute("restaurant",restaurantService.get(restaurantId));
        return "results";
    }
}
