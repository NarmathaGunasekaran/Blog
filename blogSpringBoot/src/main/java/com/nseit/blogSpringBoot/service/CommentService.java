//package com.nseit.blogSpringBoot.service;
//
//import com.nseit.blogSpringBoot.model.Comment;
//import com.nseit.blogSpringBoot.model.Post;
//import com.nseit.blogSpringBoot.repository.CommentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CommentService {
//
//    @Autowired
//    private CommentRepository commentRepository;
//
//    public List<Comment> getAllComments() {
//        return commentRepository.findAll();
//    }
//
//    public Comment createComment(Comment comments) {
//        return commentRepository.save(comments);
//    }
//
//}
