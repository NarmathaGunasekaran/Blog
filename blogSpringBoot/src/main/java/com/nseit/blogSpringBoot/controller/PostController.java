package com.nseit.blogSpringBoot.controller;

import com.nseit.blogSpringBoot.model.Post;
import com.nseit.blogSpringBoot.response.APIResponse;
import com.nseit.blogSpringBoot.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = {"http://localhost:3000"})
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private PostService postService;

//    @Secured({Role.ROLE_ADMIN, Role.ROLE_USER})

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllPost() {

        List<Post> posts = postService.getAllPost();

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(posts);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getUserPost(@PathVariable Integer id) {
        Post post = postService.getUserPost(id);
        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(post);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }


    //    @Secured({Role.ROLE_ADMIN})
    @PostMapping
    public ResponseEntity<APIResponse> add(@RequestBody Post post) {

        Post createdPost = postService.add(post);

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(createdPost);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    //    @Secured({Role.ROLE_ADMIN})
    @PutMapping
    public ResponseEntity<APIResponse> updatePost(@RequestBody Post post) {

        Post updatedPost = postService.updatePost(post);

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(updatedPost);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    //    @Secured({Role.ROLE_ADMIN})
    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteUserPost(@PathVariable Integer id) {

        postService.deletePost(id);

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(postService.getAllPost());
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }


}
