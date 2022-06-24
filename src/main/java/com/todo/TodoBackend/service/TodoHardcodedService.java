package com.todo.TodoBackend.service;

import com.todo.TodoBackend.controller.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedService {
    private static List<Todo> todos = new ArrayList();
    private static int idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "in23min", "learn to dance1", new Date(), false));
        todos.add(new Todo(++idCounter, "in24min", "learn to dance2", new Date(), true));
        todos.add(new Todo(++idCounter, "in25min", "learn to dance3", new Date(), false));
    }

    public List<Todo> findAll(){
        return todos;
    }
}
