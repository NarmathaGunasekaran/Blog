package com.nseit.blogSpringBoot.repository;

import com.nseit.blogSpringBoot.model.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<BlogUser,Integer> {
    BlogUser findByUserName(String userName);
}
