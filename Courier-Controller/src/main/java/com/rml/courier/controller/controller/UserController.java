package com.rml.courier.controller.controller;

import com.rml.courier.service.UserService;
import com.rml.courier.repository.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/user/getExistEmail/{email}")
    public ResponseEntity<Map<String,Object>> findExistEmail(@PathVariable("email") String email) {
        log.info("[User Controller] ==> Validating user email [{}]", email);
        boolean status = userService.checkUserByEmail(email);

        Map<String, Object> validatedResponse = new HashMap<>();
        validatedResponse.put("response", status);
        String message = "Email does not exists";
        if (status) {
            message = "email exists";
        }
        validatedResponse.put("message", message);
        log.info("[User Controller] ==> Returning user email validation response [{}]", validatedResponse.toString());
        return ResponseEntity.ok(validatedResponse);
    }

    @GetMapping("/unique/{userName}")
    public ResponseEntity<Map<String, Object>> validateUnioqueUser(@PathVariable("userName") String userName) {
        log.info("[User Controller] ==> Requesting username validation for username [{}]", userName);
        boolean status = userService.validateUniqueUser(userName);
        Map<String, Object> validatedResponse = new HashMap<>();
        validatedResponse.put("status", status);
        String messege = "Username does not exist";
        if (status) {
            messege = "Username already exist";
        }
        validatedResponse.put("messege", messege);
//        log.info("[User Controller] ==> Returning age group code validation status code [{}]", status);
        return ResponseEntity.ok(validatedResponse);
    }

}
