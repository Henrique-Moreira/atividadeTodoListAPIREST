package com.henriquemoreira.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.henriquemoreira.service.TodoListItemNaoEncontradoException;
import com.henriquemoreira.service.TodoListNaoEncontradoException;

@ControllerAdvice
public class TodoListNaoEncontradoAdvice {
        @ResponseBody
        @ExceptionHandler(TodoListNaoEncontradoException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String itemNotFoundHandler(TodoListItemNaoEncontradoException ex) {
           	System.out.println("===>>>>>>>>>>>" + ex);
                return ex.getMessage();
        }
}