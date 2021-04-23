package com.henriquemoreira.service;

public class TodoListNaoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    TodoListNaoEncontradoException(Integer id) {
        super("Não encontrei o item " + id);
      }
}
