package com.nseit.ProjectBlog.controller;

import com.nseit.ProjectBlog.model.Post;
import com.nseit.ProjectBlog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/post")
@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public void add(@RequestBody Post postModel) {
        postService.add(postModel);
    }

    @GetMapping
    List<Post> getStudents() {
        return postService.findAll();
    }

    @PutMapping
    void update(@RequestBody Post post) {
         postService.update(post);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        postService.delete(id);
    }
}
