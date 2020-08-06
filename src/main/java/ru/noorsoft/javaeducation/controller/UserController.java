package ru.noorsoft.javaeducation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import ru.noorsoft.javaeducation.model.User;
import ru.noorsoft.javaeducation.service.UserService;
import ru.noorsoft.javaeducation.service.UserValidator;

import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;
    private final UserValidator userValidator;

    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    // тут вызывается пока еще пустая таблица
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUser(Model model) {
        model.addAttribute("addUser", new User());
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    // тут вставляются свои данные в инпуты с учетом валидации
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String getUser( @ModelAttribute("user") User user, BindingResult bindingResult,
                           Model model) {
        model.addAttribute("addUser", new User());
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String phoneNumber = user.getPhoneNumber();
        String email = user.getEmail();
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "users";
        }
        user = new User(firstName.substring(0, 1).toUpperCase() + firstName.substring(1),
                lastName.substring(0, 1).toUpperCase() + lastName.substring(1),
                phoneNumber.substring(0, 1) + " (" + phoneNumber.substring(1, 4) + ") " + phoneNumber.substring(4, 7) + " " + phoneNumber.substring(7, 9) + " " + phoneNumber.substring(9), email);
        userService.save(user);
        return "redirect:/users";
    }

//    // тут инфа из строки таблицы с id вставляется в инпут и редактируется там
//    @RequestMapping(value="/edit", method= RequestMethod.POST)
//    public String updateUser(@RequestParam("id") Long id, @ModelAttribute("user") User user, Model model) {
//        Optional<User> userToUpdate = userService.findById(id);
//        model.addAttribute("addUser", user);
//        user.setFirstName(user.getFirstName() != null ? user.getFirstName() : userToUpdate.get().getFirstName());
//        user.setLastName(user.getLastName() != null ? user.getLastName() : userToUpdate.get().getLastName());
//        user.setPhoneNumber(user.getPhoneNumber() != null ? user.getPhoneNumber() : userToUpdate.get().getPhoneNumber());
//        user.setEmail(user.getEmail() != null ? user.getEmail() : userToUpdate.get().getEmail());
//        userService.save(user);
//        model.addAttribute("user", userService.findById(user.getId()));
//        return "redirect:/users";
//    }
    // а тут по id удаляется user
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteUser(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}



