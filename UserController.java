package ru.noorsoft.javaeducation.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import ru.noorsoft.javaeducation.model.User;
import ru.noorsoft.javaeducation.repository.UserRepository;
import ru.noorsoft.javaeducation.service.UserValidator;


@Controller
public class UserController {

    private final UserRepository userRepository;
    private final UserValidator userValidator;

    public UserController(UserRepository userRepository, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }


    @RequestMapping("/")
    public String findAll(@ModelAttribute("addUser") User user, Model model, BindingResult bindingResult) {
        model.addAttribute("user", userRepository.findAll());
        model.addAttribute("addUser", user);
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String phoneNumber = user.getPhoneNumber();
        String email = user.getEmail();
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()){
            return "users";
        }
        user = new User(firstName.substring(0,1).toUpperCase()+firstName.substring(1),
                lastName.substring(0,1).toUpperCase()+lastName.substring(1), phoneNumber, email);
        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
        return "redirect:/";
    }


}
