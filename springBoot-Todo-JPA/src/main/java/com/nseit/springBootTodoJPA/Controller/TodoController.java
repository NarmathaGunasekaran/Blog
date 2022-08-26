package com.nseit.springBootTodoJPA.Controller;

import com.nseit.springBootTodoJPA.model.Todo;
import com.nseit.springBootTodoJPA.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/todo")
@RestController
public class TodoController {
    @Autowired
    TodoService todoService;

    @PostMapping
    public void add(Todo todo) {
        todoService.add(todo);
    }

    @GetMapping
    public void view() {
        todoService.view();

    }

    @PutMapping
    public void update(Todo todo) {
        todoService.update(todo);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        todoService.delete(id);


    }
}
