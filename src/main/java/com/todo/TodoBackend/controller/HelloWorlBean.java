package com.todo.TodoBackend.controller;

public class HelloWorlBean {

    public HelloWorlBean(String message){
        this.message=message;
    }


    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "HelloWorlBean{" +
                "message='" + message + '\'' +
                '}';
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;



}
