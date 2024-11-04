package wuhao.springboot.middle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wuhao.springboot.middle.entity.User;
import wuhao.springboot.middle.mapper.UserMapper;

/**
 * @author PC
 */
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/register")
    public void register(@RequestBody User user) {
        userMapper.insertUser(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userMapper.findByUsername(user.getUsername());
    }
}