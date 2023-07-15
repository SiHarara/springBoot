package com.me.controller;


import com.me.model.User;
import com.me.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/users")
    public String showUsers(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("listUser", users);
        return "users";
    }

    @GetMapping(value = "/users/new")
    public String addUser(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Add New User");
        return "user_form";
    }

    @PostMapping(value = "/users/save")
    public String save(User user, RedirectAttributes re){
        userService.save(user);
        re.addFlashAttribute("message", "The user has been added successfully !!");
        return "redirect:/users";
    }

    @GetMapping(value = "/users/edit/{id}")
    public String updateUser(@PathVariable(value = "id") int id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("pageTitle", String.format("Edit User -> %s", id));
        return "user_form";
    }

    @GetMapping(value = "/users/delete/{id}")
    public String deleteUser(@PathVariable(value = "id") int id){
        userService.deleteById(id);
        return "redirect:/users";
    }
}
