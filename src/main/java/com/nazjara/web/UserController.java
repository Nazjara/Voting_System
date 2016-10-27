package com.nazjara.web;

import com.nazjara.AuthorizedUser;
import com.nazjara.model.Restaurant;
import com.nazjara.model.Role;
import com.nazjara.model.User;
import com.nazjara.service.RestaurantService;
import com.nazjara.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/users")
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService service;

    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllUsers(Model model)
    {
        model.addAttribute("users",service.getAll());
        return "users";
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String updateUser(HttpServletRequest request, Model model)
    {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = service.get(userId);
        model.addAttribute("user",user);
        model.addAttribute("action","update");
        return "user";
    }

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String createUser(Model model)
    {
        User user = new User();
        model.addAttribute("user",user);
        model.addAttribute("action","create");
        return "user";
    }

    @RequestMapping(value = "/createOrUpdate",method = RequestMethod.POST)
    public String createOrUpdateUser(HttpServletRequest request ,Model model)
    {
        if(request.getParameter("id").isEmpty()){
            User user = new User();
            user.setName(request.getParameter("name"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            user.setRoles(Collections.singleton(Role.ROLE_USER));
            LOG.info("Create {}", user);
            service.save(user);
        }
        else{
            int userId = Integer.parseInt(request.getParameter("id"));
            User user = service.get(userId);
            user.setName(request.getParameter("name"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            LOG.info("Update {}", user);
            service.update(user,userId);
        }
        model.addAttribute("users",service.getAll());
        return "users";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String deleteUser(HttpServletRequest request, Model model)
    {
        int userId = Integer.parseInt(request.getParameter("id"));
        LOG.info("Delete user with id {}", userId);
        service.delete(userId);
        model.addAttribute("users",service.getAll());
        return "users";
    }

    @RequestMapping(value = "/results", method = RequestMethod.POST)
    public String getVoteResults(HttpServletRequest request, Model model)
    {
        int restaurantId = Integer.parseInt(request.getParameter("answer"));
        User user = service.get(AuthorizedUser.id());
        Restaurant restaurant = restaurantService.get(restaurantId);
        List<User> listWithUsers = restaurant.getUsers();
        listWithUsers.add(user);
        restaurant.setUsers(listWithUsers);
        user.setRestaurant(restaurant);
        service.update(user,AuthorizedUser.id());
        restaurantService.update(restaurant);
        model.addAttribute("restaurant",restaurant);
        return "results";
    }

}
