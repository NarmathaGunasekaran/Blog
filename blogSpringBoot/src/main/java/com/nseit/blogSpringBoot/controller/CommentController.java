package com.nseit.blogSpringBoot.controller;

import com.nseit.blogSpringBoot.model.Post;
import com.nseit.blogSpringBoot.model.Role;
import com.nseit.blogSpringBoot.response.APIResponse;
import com.nseit.blogSpringBoot.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/comment")
public class CommentController {


        @Autowired
        private APIResponse apiResponse;

        @Autowired
        private PostService postService;

        @Secured({Role.ROLE_ADMIN, Role.ROLE_USER})

        @GetMapping("/all")
        public ResponseEntity<APIResponse> getAllPost() {

            List<Post> posts = postService.getAllPosts();

            apiResponse.setStatus(HttpStatus.CREATED.value());
            apiResponse.setData(posts);
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        }

        @GetMapping("/{id}")
        public ResponseEntity<APIResponse> getUserPost(@PathVariable Integer id) {
            List<Post> posts = postService.getAllPosts();
            apiResponse.setStatus(HttpStatus.CREATED.value());
            apiResponse.setData(posts);
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        }
//    @Secured({Role.ROLE_ADMIN})
    @PostMapping
    public ResponseEntity<APIResponse> createComments(@RequestBody Post post) {

        Post createdPost = postService.createPost(post);

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(createdPost);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
}
