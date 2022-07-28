package com.todo.TodoBackend.controller;


import com.todo.TodoBackend.repo.TodoRepo;
import com.todo.TodoBackend.service.TodoHardcodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//this is based on in 28 min 
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoController {
    @Autowired
    private TodoHardcodedService todoHardcodedService;

    @Autowired
    private TodoRepo todoRepo;
/*
    @GetMapping(path = "/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoHardcodedService.findAll();
    }
*/
    @GetMapping(path = "/users/todos")
    public List<Todo> getAllTodo() {
        return todoRepo.findAll();
    }

/*
    @GetMapping(path = "/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username,@PathVariable long id) {
        return todoHardcodedService.findById(id);
    }
*/
    /*
    @PutMapping(path = "/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username,@PathVariable long id,@RequestBody Todo todo) {
        Todo todoUpdated=todoHardcodedService.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }*/

    @PutMapping(path = "/users/{username}/todos/{id}")
    public Todo updateTodoById(@PathVariable Long id, @RequestBody Todo todoDetails) {
        return this.todoHardcodedService.updateTodo(id, todoDetails);
    }

/*
    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username,@PathVariable long id){
        Todo todo= todoHardcodedService.deleteById(id);
        if(todo!=null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
        //return todoRepo.deleteById(id);
    }
*/

    @DeleteMapping("/users/{username}/todos/{id}")
    public void deleteTodos(@PathVariable String username,@PathVariable long id){
        //return ResponseEntity.notFound().build();
        todoRepo.deleteById(id);
    }


}
