package com.nseit.ProjectBlog.repository;

import com.nseit.ProjectBlog.model.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<BlogUser, Integer> {
    BlogUser findByUserName(String username);
}
