package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.Arrays;

@Controller
public class AdminController {

    private final UserService userservice;

    @Autowired
    public AdminController(UserService userservice) {
        this.userservice = userservice;
    }

    @GetMapping("/admin/{id}")
    public String getUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userservice.getUser(id));
        return "user";
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
