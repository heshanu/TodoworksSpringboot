package com.todo.TodoBackend.service;

import com.todo.TodoBackend.controller.Todo;
import com.todo.TodoBackend.repo.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoHardcodedService {

    @Autowired
    private TodoRepo todoRepo;

    private static List<Todo> todos = new ArrayList();
    private static int idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "in23min", "learn to dance1", new Date(), false));
        todos.add(new Todo(++idCounter, "in24min", "learn to dance2", new Date(), true));
        todos.add(new Todo(++idCounter, "in25min", "learn to dance3", new Date(), false));
        todos.add(new Todo(++idCounter, "in26min", "learn to dance4", new Date(), false));
        todos.add(new Todo(++idCounter, "in27min", "learn to dance5", new Date(), true));
        todos.add(new Todo(++idCounter, "in28min", "learn to dance6", new Date(), false));
    }

    public List<Todo> findAll() {
        return todos;
    }

    public Todo deleteById(long id) {
        Todo todo = findById(id);
        if (todo == null) return null;

        if (todos.remove(todo)) {
            return todo;
        }
        return null;
    }

    public Todo findById(long id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    public Todo save(Todo todo) {
        if (todo.getId() == -1) {
            // TODO: 6/25/2022
            todo.setId(++idCounter);
            todos.add(todo);
        } else {
            deleteById(todo.getId());
            // TODO: 6/25/2022
            todos.add(todo);
        }
        return todo;
    }

    public List<Todo> getAll() {
        return todoRepo.findAll();
    }


    public Todo updateTodo(Long id, Todo todoDetails) {
        Todo getSelectedTodo=this.todoRepo.getById(id);

        if(getSelectedTodo==null){
            getSelectedTodo.setId(todoDetails.getId());
            getSelectedTodo.setDescription(todoDetails.getDescription());
            getSelectedTodo.setDone(todoDetails.isDone());
            getSelectedTodo.setTargetDate(todoDetails.getTargetDate());
            getSelectedTodo.setUsername(todoDetails.getUsername());
        }
        /*
           // getSelectedTodo.setId(todoDetails.getId());
            getSelectedTodo.setDescription(todoDetails.getDescription());
            getSelectedTodo.setDone(todoDetails.isDone());
            getSelectedTodo.setTargetDate(todoDetails.getTargetDate());
            getSelectedTodo.setUsername(todoDetails.getUsername());
        }

        return this.todoRepo.save(getSelectedTodo);*/
        return this.todoRepo.save(getSelectedTodo);
    }
}
