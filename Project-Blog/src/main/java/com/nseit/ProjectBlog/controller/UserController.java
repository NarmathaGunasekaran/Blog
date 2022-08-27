package com.nseit.ProjectBlog.controller;

import com.nseit.ProjectBlog.model.PostModel;
import com.nseit.ProjectBlog.model.UserModel;
import com.nseit.ProjectBlog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import java.util.List;

@RequestMapping
@RestController("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public  void view(){
        userService.view();
    }
}
