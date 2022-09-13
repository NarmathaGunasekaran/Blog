package com.nseit.ProjectBlog.controller;

import com.nseit.ProjectBlog.model.Post;
import com.nseit.ProjectBlog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private PostService postService;

    @PostMapping("/post")
    public ResponseEntity<Post> add(@RequestBody Post post){
        Post post1 = postService.add(post);
        if (post1 == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }


}