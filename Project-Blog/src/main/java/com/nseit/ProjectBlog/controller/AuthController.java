package com.nseit.ProjectBlog.controller;

import com.nseit.ProjectBlog.model.BlogUser;
import com.nseit.ProjectBlog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<BlogUser> register(@RequestBody BlogUser blogUser) {
        BlogUser registeredUser = userService.registerAsCustomer(blogUser);
        if (registeredUser == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(registeredUser, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<BlogUser> login(@RequestBody BlogUser blogUser) {
        BlogUser loggedInUser = userService.loginAsCustomer(blogUser);
        if (loggedInUser == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BlogUser>> getAllUsers() {
        List<BlogUser> blogUsers = userService.getAllUsers();
        if (blogUsers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogUsers, HttpStatus.OK);
    }


}