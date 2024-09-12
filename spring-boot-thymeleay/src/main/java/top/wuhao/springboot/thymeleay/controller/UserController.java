package top.wuhao.springboot.thymeleay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.wuhao.springboot.thymeleay.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {


    private List<User> users = new ArrayList<>();


    public UserController() {
        users.add(new User(1L, "Alice", "alice@example.com"));
        users.add(new User(2L, "Bob", "bob@example.com"));
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping("/addusers")
    public String addUser(@RequestParam String name, @RequestParam String email, Model model) {
        users.add(new User(users.size() + 1L, name, email));
        return "redirect:/users";
    }
}