package com.nseit.ProjectBlog.service;

import com.nseit.ProjectBlog.model.PostModel;
import com.nseit.ProjectBlog.model.UserModel;
import com.nseit.ProjectBlog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserModel> view() {
        return userRepository.findAll();
    }
}
