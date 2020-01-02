package com.rml.courier.controller.controller;

import com.rml.courier.service.UserService;
import com.rml.courier.repository.Model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/api")
@RestController
@CrossOrigin("*")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        log.info("[User Controller] ==> Calling service to save user");
        User savedUser = userService.saveRegistration(user);
        log.info("[User Controller] ==> Returning saved user with id [{}]", user.getId());
        return ResponseEntity.ok(savedUser);
    }

}
