package br.com.mateus.study.endpoint.controller;

import br.com.mateus.study.endpoint.model.User;
import br.com.mateus.study.endpoint.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable String id){
        return userService.findById(id);
    }

    @PostMapping
    public User save(@RequestBody User user){
        return userService.save(user);
    }
}
