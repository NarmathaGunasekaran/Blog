package com.nseit.springBootTodoJPA.respository;

import com.nseit.springBootTodoJPA.model.Todo;
import com.nseit.springBootTodoJPA.service.TodoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRespository extends JpaRepository<Todo, Integer> {
}
