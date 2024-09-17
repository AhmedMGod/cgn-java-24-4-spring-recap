package org.example.cgnjava244springrecap.service;

import lombok.RequiredArgsConstructor;
import org.example.cgnjava244springrecap.model.Todo;
import org.example.cgnjava244springrecap.model.TodoDTO;
import org.example.cgnjava244springrecap.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    private final IdService idService;

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Todo addTodo (TodoDTO todoDTO){
        return todoRepository.save(new Todo(idService.generateId(), todoDTO.description(), todoDTO.status()));
    }


    public Todo findById(String id){
        return todoRepository.findById(id).orElseThrow();
    }

    public Todo updateTodo(Todo updateTodo){
        return todoRepository.save(updateTodo);
    }

    public String deleteTodo(String id){
        todoRepository.deleteById(id);
        return "Todo deleted!";
    }

}
