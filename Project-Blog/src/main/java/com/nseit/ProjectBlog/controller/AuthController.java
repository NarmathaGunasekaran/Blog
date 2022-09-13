package com.nseit.ProjectBlog.controller;

import com.nseit.ProjectBlog.exception.ResourceNotFoundException;
import com.nseit.ProjectBlog.model.BlogUser;
import com.nseit.ProjectBlog.response.APIResponse;
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
    public ResponseEntity<APIResponse> register(@RequestBody BlogUser blogUser) {
        BlogUser registeredUser = userService.registerAsCustomer(blogUser);
        if (registeredUser == null) {
            throw new ResourceNotFoundException("Unable to register User");
        }
        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(registeredUser);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse> login(@RequestBody BlogUser blogUser) {
        APIResponse apiResponse = new APIResponse();
        BlogUser loggedInUser = userService.loginAsCustomer(blogUser);
        if (loggedInUser == null) {
            throw new ResourceNotFoundException("User Not found");
        }
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(loggedInUser);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
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