package com.henriquemoreira.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henriquemoreira.domain.TodoList;
import com.henriquemoreira.service.TodoListService;

@RestController
@RequestMapping("/todoList")
class TodoListController {

        @Autowired
        private TodoListService serviceTodoList;

        @GetMapping
        public List<TodoList> all() {
                return serviceTodoList.todasListas();
        }
        
        @GetMapping("/{id}")
        public TodoList one(@PathVariable Integer id) {
        	return serviceTodoList.todoList(id);
        }
        
        @PostMapping
        public TodoList novoTodoList(@RequestBody TodoList todoList) {
                return serviceTodoList.novoTodoList(todoList);
        }

        @PutMapping("/{id}")
        public TodoList atualizaTodoList(@RequestBody TodoList todoList, @PathVariable Integer id) {
                return serviceTodoList.atualizaTodoList(todoList, id);
        }

        @DeleteMapping("/{id}")
        void deleteTodoList(@PathVariable Integer id) {
        		serviceTodoList.deleteTodoList(id);
        }
}
