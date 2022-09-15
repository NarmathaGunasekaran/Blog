package com.nseit.blogSpringBoot.repository;

import com.nseit.blogSpringBoot.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Integer> {

}
