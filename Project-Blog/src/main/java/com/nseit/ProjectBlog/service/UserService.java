package com.nseit.ProjectBlog.service;

import com.nseit.ProjectBlog.model.Users;
import com.nseit.ProjectBlog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Users> findAll() {
        return userRepository.findAll();
    }
}
