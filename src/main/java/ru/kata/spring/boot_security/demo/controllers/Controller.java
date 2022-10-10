package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.security.Principal;
import java.util.Arrays;

@org.springframework.stereotype.Controller
public class Controller {

    private final UserService userservice;

    @Autowired
    public Controller(UserService userservice) {
        this.userservice = userservice;
    }

    @GetMapping("/user")
    public String getUser(Model model, Principal principal) {
        model.addAttribute("user",userservice.findByUsername(principal.getName()));
        return "simpleUser";
    }


    @GetMapping("/admin/{id}")
    public String getUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userservice.getUser(id));
        return "user";
    }

    @GetMapping("/")
    public String getWelcomePage() {
        if(userservice.getAllUsers().isEmpty())
            userservice.addUser(new User("admin","admin", Arrays.asList("ROLE_ADMIN")));
        return "welcomePage";
    }

    @GetMapping("/admin")
    public String getAllUsers(Model model) {

        model.addAttribute("users", userservice.getAllUsers());
        return "admin";
    }

    @GetMapping("/admin/new")
    public String getRegistrationForm(Model model) {

        User user = new User();
        model.addAttribute("user", user);
        return "new";
    }

    @PostMapping("/admin/new")
    public String registerNewUser(@ModelAttribute("user") User user) {
        userservice.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/{id}/edit")
    public String getUserEditForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("edit_user", userservice.getUser(id));
        return "edit";
    }

    @PatchMapping("/admin/{id}")
    public String updateUser(@ModelAttribute("edit_user") User user, @PathVariable("id") int id) {

        userservice.updateUser(id, user);
        return "redirect:/admin";
    }

    @DeleteMapping("/admin/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userservice.deleteUser(id);
        return "redirect:/admin";
    }
}
