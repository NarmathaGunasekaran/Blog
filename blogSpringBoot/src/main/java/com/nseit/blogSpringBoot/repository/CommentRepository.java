package com.nseit.blogSpringBoot.repository;

import com.nseit.blogSpringBoot.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Post, Integer> {
}
