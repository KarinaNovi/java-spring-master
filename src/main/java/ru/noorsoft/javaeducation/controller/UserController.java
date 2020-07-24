package ru.noorsoft.javaeducation.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import ru.noorsoft.javaeducation.model.User;

import ru.noorsoft.javaeducation.service.UserService;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showForm (User user)
    {
        return "users";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String addUser(Model model, User user) {
            userService.addUser(user);
            model.addAttribute("users", userService.findAll());
            return "users";
    }

    @RequestMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model) {
        userService.deleteUser(id);
        model.addAttribute("users", userService.findAll());
        return "users";
    }
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    public String updateUser(@PathVariable("id") Long id, User user, Model model){
        userService.updateUser(user);
        model.addAttribute("users", userService.findAll());
        return "users";
    }

}
