package com.nseit.springBootTodoJPA.service;

import com.nseit.springBootTodoJPA.model.Todo;
import com.nseit.springBootTodoJPA.respository.TodoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRespository todoRespository;

    public void add(Todo todo) {
        todoRespository.save(todo);
    }

    public List<Todo> view() {
        return todoRespository.findAll();
    }

    public void update(Todo todo) {
        todoRespository.save(todo);
    }

    public void delete(int id) {
        for (Todo todo : todoRespository.findAll()) {
            if (id == todo.getId())
                todoRespository.delete(todo);
        }

    }
}
