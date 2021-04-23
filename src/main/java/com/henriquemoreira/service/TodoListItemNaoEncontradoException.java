package com.henriquemoreira.service;

public class TodoListItemNaoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    TodoListItemNaoEncontradoException(Integer id) {
        super("Não encontrei a lista " + id);
      }
}
