package com.nseit.blogSpringBoot.controller;

import com.nseit.blogSpringBoot.model.BlogUser;
import com.nseit.blogSpringBoot.response.APIResponse;
import com.nseit.blogSpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = {"http://localhost:3000"})
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private APIResponse apiResponse;


    @PostMapping("/login")
    public ResponseEntity<APIResponse> login(@RequestBody BlogUser blogUser) {

        BlogUser loggedInUser = userService.login(blogUser);

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(loggedInUser);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PostMapping("/register")
    public ResponseEntity<APIResponse> register(@RequestBody BlogUser blogUser) {

        BlogUser registeredUser = userService.register(blogUser);

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(registeredUser);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

}
