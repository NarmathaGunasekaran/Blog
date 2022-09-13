package com.codewithashith.Delete_blog.controller;

import com.codewithashith.Delete_blog.model.Post;
import com.codewithashith.Delete_blog.model.Role;
import com.codewithashith.Delete_blog.response.APIResponse;
import com.codewithashith.Delete_blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

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

    @GetMapping("/{userId}")
    public ResponseEntity<APIResponse> getUserPost(@PathVariable Integer userId) {

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(null);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }


    @Secured({Role.ROLE_ADMIN})
    @PostMapping
    public ResponseEntity<APIResponse> createPost(@RequestBody Post post) {

        Post createdPost = postService.createPost(post);

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(createdPost);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @Secured({Role.ROLE_ADMIN})
    @PutMapping
    public ResponseEntity<APIResponse> updatePost(@RequestBody Post post) {

        Post updatedPost = postService.updatePost(post);

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(updatedPost);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @Secured({Role.ROLE_ADMIN})
    @DeleteMapping("/{postId}")
    public ResponseEntity<APIResponse> deleteUserPost(@PathVariable Integer postId) {

        postService.deletePost(postId);

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(postService.getAllPosts());
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }


}
