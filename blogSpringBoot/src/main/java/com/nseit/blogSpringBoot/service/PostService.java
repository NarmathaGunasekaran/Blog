package com.nseit.blogSpringBoot.service;


import com.nseit.blogSpringBoot.exception.ResourceNotFoundException;
import com.nseit.blogSpringBoot.model.Post;
import com.nseit.blogSpringBoot.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Post post) {
        if (post.getId() == null)
            throw new ResourceNotFoundException("Id must not be null");

        boolean isExist = postRepository.findById(post.getId()).isPresent();
        if (!isExist)
            throw new ResourceNotFoundException("Invalid Post");
        return postRepository.save(post);
    }

    public void deletePost(Integer postId) {
        postRepository.deleteById(postId);
    }
}
