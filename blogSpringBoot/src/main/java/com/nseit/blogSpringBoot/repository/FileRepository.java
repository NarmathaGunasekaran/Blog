package com.codewithashith.BookArtAPI.repository;

import com.codewithashith.BookArtAPI.model.Book;
import com.codewithashith.BookArtAPI.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<File, Integer> {
}
