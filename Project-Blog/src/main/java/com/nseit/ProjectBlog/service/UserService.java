package com.nseit.ProjectBlog.service;

import com.nseit.ProjectBlog.exception.UserExistException;
import com.nseit.ProjectBlog.model.BlogUser;
import com.nseit.ProjectBlog.model.Role;
import com.nseit.ProjectBlog.repository.RoleRepository;
import com.nseit.ProjectBlog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public BlogUser registerAsCustomer(BlogUser blogUser) {
        BlogUser user = userRepository.findByUserName(blogUser.getUserName());
        if (user != null) {
            throw new UserExistException("User Already Exception");
        }
        Role role = roleRepository.findByName(Role.ROLE_USER);
        blogUser.setRoles(Set.of(role));
        blogUser.setPassword(bCryptPasswordEncoder.encode(blogUser.getPassword()));
        return userRepository.save(blogUser);
    }

    public List<BlogUser> getAllUsers() {
        return userRepository.findAll();
    }

    public BlogUser loginAsCustomer(BlogUser blogUser) {
        BlogUser user = userRepository.findByUserName(blogUser.getUserName());
        if (user != null && bCryptPasswordEncoder.matches(blogUser.getPassword(), user.getPassword())) {
            return user;
        }
        return null;
    }
}