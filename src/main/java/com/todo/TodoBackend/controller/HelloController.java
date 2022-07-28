package com.todo.TodoBackend.controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path ="/helloworld")
public class HelloController {

    @GetMapping
    public String hello(){
        return "hello-world";
    }

    @GetMapping(path = "/hello-world-beam")
    public HelloWorlBean helloWorldBean(){
        return new HelloWorlBean("Hello World Heshan123456789");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorlBean helloWorldPathVaraiable(@PathVariable String name){
        return new HelloWorlBean(String.format("hello world ,%s",name));
    }

}
