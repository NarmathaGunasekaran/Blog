package com.nseit.blogSpringBoot.service;


import com.nseit.blogSpringBoot.exception.ResourceNotFoundException;
import com.nseit.blogSpringBoot.model.BlogUser;
import com.nseit.blogSpringBoot.model.File;
import com.nseit.blogSpringBoot.model.Post;
import com.nseit.blogSpringBoot.repository.FileRepository;
import com.nseit.blogSpringBoot.repository.PostRepository;
import com.nseit.blogSpringBoot.repository.UserRepository;
import com.nseit.blogSpringBoot.utils.ImageUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileRepository fileRepository;

    public Post add(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Post post) {
//        Post post1 = new Post();
        if (post.getId() == null)
            throw new ResourceNotFoundException("No post with the id " + post.getId());
//        File file = fileRepository.findById(post.getFileId()).orElseThrow(() -> new ResourceNotFoundException("File not found"));
//        post.setFile(file);
        return postRepository.save(post);
    }

    public List<Post> getAllPost() {
        List<Post> posts = postRepository.findAll();
        List<Post> postResponses = new ArrayList<>();
        for (Post post : posts) {
            post.setId(post.getId());
            post.setTitle(post.getTitle());
            post.setDescription(post.getDescription());
//            post.setImage(post.getImage());
//            if (post.getFile() != null && post.getFile().getImage() != null) {
//                post.setImage(ImageUtility.decompressImage(post.getFile().getImage()));
//                System.out.println(post.getFile().getImage());
//            } else
//                System.out.println("abcd");
            postResponses.add(post);
        }
        return postResponses;
    }

    public Post getUserPost(Integer postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Unable to find post with id " + postId));
    }

    public void deletePost(Integer id) {
        postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No posts" + id));
        postRepository.deleteById(id);
    }
}