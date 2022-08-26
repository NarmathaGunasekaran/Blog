package com.nseit.ProjectBlog.service;

import com.nseit.ProjectBlog.model.PostModel;
import com.nseit.ProjectBlog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public void add(PostModel postModel) {
        postRepository.save(postModel);
    }

    public List<PostModel> view() {
     return postRepository.findAll();

    }

    public void update(PostModel postModel) {
        postRepository.save(postModel);
    }

    public void delete(int id) {
        for (PostModel postModel : postRepository.findAll()) {
            if (id == postModel.getId())
                postRepository.delete(postModel);
        }
    }
}
