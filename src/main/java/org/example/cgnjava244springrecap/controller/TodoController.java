package org.example.cgnjava244springrecap.controller;

import lombok.RequiredArgsConstructor;
import org.example.cgnjava244springrecap.model.Todo;
import org.example.cgnjava244springrecap.model.TodoDTO;
import org.example.cgnjava244springrecap.repository.TodoRepository;
import org.example.cgnjava244springrecap.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;


    @GetMapping
    public List<Todo> findAll() {
        return todoService.findAll();
    }

    @PostMapping
    public Todo addTodo(@RequestBody TodoDTO todoDTO){
        return todoService.addTodo(todoDTO);
    }

    @GetMapping("/{id}")
    public Todo findById(@PathVariable String id){
        return todoService.findById(id);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable String id, @RequestBody Todo updateTodo){
        return todoService.updateTodo(updateTodo);
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable String id){
        return todoService.deleteTodo(id);
    }


}
