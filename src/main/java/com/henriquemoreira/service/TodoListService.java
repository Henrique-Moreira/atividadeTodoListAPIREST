package com.henriquemoreira.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import com.henriquemoreira.domain.TodoList;
import com.henriquemoreira.repository.TodoListRepository;

@Service
public class TodoListService {

        @Autowired
        TodoListRepository todoListRepository;

        public List<TodoList> todasListas() {
                return todoListRepository.findAll();
        }

        public TodoList novoTodoList(TodoList todoList) {
                return todoListRepository.save(todoList);
        }

        public TodoList todoList(Integer id) {
                return todoListRepository.findById(id).orElseThrow(() -> new TodoListNaoEncontradoException(id));
        }

        public TodoList atualizaTodoList(TodoList todoList, Integer id) {
        		todoList.setId(id);
                return todoListRepository.save(todoList);
        }

        public void deleteTodoList(@PathVariable Integer id) {
        		todoListRepository.deleteById(id);
        }

}
