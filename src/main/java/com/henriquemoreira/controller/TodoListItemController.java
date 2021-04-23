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

import com.henriquemoreira.domain.TodoListItem;
import com.henriquemoreira.service.TodoListItemService;

@RestController
@RequestMapping("/item")
class TodoListItemController {

        @Autowired
        private TodoListItemService serviceTodoListItem;

        @GetMapping
        public List<TodoListItem> all() {
                return serviceTodoListItem.todosItens();
        }
        
        @GetMapping("/{id}")
        public TodoListItem one(@PathVariable Integer id) {
        	return serviceTodoListItem.todoListItem(id);
        }
        
        @PostMapping("/{list}")
        
        public TodoListItem novoTodoListItem(@RequestBody TodoListItem item, @PathVariable Integer list) {
        	TodoListItem item1 = serviceTodoListItem.novoItem(item, list);
        	System.out.println(item1.getList().getId());
        	return item1;
        }

        @PutMapping("/{id}")
        public TodoListItem atualizaTodoList(@RequestBody TodoListItem item, @PathVariable Integer id) {
                return serviceTodoListItem.atualizaItem(item, id);
        }

        @DeleteMapping("/{id}")
        void deleteTodoList(@PathVariable Integer id) {
        		serviceTodoListItem.deleteItem(id);
        }
}
