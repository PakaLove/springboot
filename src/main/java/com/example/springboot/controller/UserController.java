package com.example.springboot.controller;

import com.example.springboot.service.UserService;
import com.example.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userServiceImpl;

    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("users", userServiceImpl.getAll());
        return "allusers";
    }

    @GetMapping("/{id}")
    public String showById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userServiceImpl.getUser(id));
        return "oneuser";
    }


    @GetMapping("/adduser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "adduser";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userServiceImpl.addUser(user);
        return "redirect:/users";

    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userServiceImpl.getUser(id));
        return "updateuser";
    }

    @PostMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user){
        userServiceImpl.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@ModelAttribute("id") Long id){
        userServiceImpl.deleteUser(id);
        return "redirect:/users";
    }

}
