package com.henriquemoreira.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ItemNaoEncontradoAdvice {
        @ResponseBody
        @ExceptionHandler(TodoListNaoEncontradoException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String todoListNotFoundHandler(TodoListNaoEncontradoException ex) {
       	System.out.println("===>>>>>>>>>>>" + ex);
                return ex.getMessage();
        }
}