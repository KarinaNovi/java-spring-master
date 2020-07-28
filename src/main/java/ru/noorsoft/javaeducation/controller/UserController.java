package ru.noorsoft.javaeducation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ru.noorsoft.javaeducation.model.User;
import ru.noorsoft.javaeducation.repository.UserRepository;


@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping("/")
    public String addUser(Model model, @ModelAttribute("addUser") User user){
        model.addAttribute("user", userRepository.findAll());
        model.addAttribute("addUser", user);
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String phoneNumber = user.getPhoneNumber();
        String email = user.getEmail();
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
