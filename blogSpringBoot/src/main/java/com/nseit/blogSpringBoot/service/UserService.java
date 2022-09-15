package com.nseit.blogSpringBoot.service;

import com.nseit.blogSpringBoot.exception.ResourceAlreadyExistException;
import com.nseit.blogSpringBoot.exception.ResourceNotFoundException;
import com.nseit.blogSpringBoot.model.BlogUser;
import com.nseit.blogSpringBoot.model.Role;
import com.nseit.blogSpringBoot.repository.RoleRepository;
import com.nseit.blogSpringBoot.repository.UserRepository;
import com.nseit.blogSpringBoot.response.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public BlogUser register(BlogUser blogUser) {
        blogUser.setPassword(bCryptPasswordEncoder.encode(blogUser.getPassword()));

        BlogUser userAlreadyExists = userRepository.findByUserName(blogUser.getUserName());
        if (userAlreadyExists != null) {
            throw new ResourceAlreadyExistException("User Already Exists");
        }

        return userRepository.save(blogUser);

    }

    public AuthResponse login(BlogUser blogUser) {
        BlogUser userAlreadyExists = userRepository.findByUserName(blogUser.getUserName());

        AuthResponse authResponse = new AuthResponse();

        if (userAlreadyExists != null) {
            if (!bCryptPasswordEncoder.matches(blogUser.getPassword(), userAlreadyExists.getPassword())) {
                throw new ResourceNotFoundException("Invalid Password!");
            } else {
                authResponse.setId(userAlreadyExists.getId());
                authResponse.setUserName(userAlreadyExists.getUserName());
                System.out.println("-----------------");
                System.out.println(userAlreadyExists.getPosts().size());
                System.out.println("-----------------");
                authResponse.setRole(userAlreadyExists.getRoles().iterator().next().getName());
            }
        } else {
            throw new ResourceNotFoundException("Invalid Username");
        }
        System.out.println(authResponse.getRole());
        return authResponse;
    }
}
