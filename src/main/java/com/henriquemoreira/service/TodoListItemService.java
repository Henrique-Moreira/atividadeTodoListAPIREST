package com.henriquemoreira.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.henriquemoreira.domain.TodoList;
import com.henriquemoreira.domain.TodoListItem;
import com.henriquemoreira.repository.TodoListItemRepository;

@Service
public class TodoListItemService {

        @Autowired
        TodoListItemRepository itemRepository;
        
    	@Autowired
    	TodoListService todoListService;

        public List<TodoListItem> todosItens() {
                return itemRepository.findAll();
        }

        public TodoListItem novoItem(TodoListItem item, Integer idList) {
        	TodoList list = todoListService.todoList(idList);
        	item.setList(list);
            return itemRepository.save(item);
        }

        public TodoListItem todoListItem(Integer id) {
                return itemRepository.findById(id).orElseThrow(() -> new TodoListItemNaoEncontradoException(id));
        }

        public TodoListItem atualizaItem(TodoListItem item, Integer id) {
        		item.setId(id);
                return itemRepository.save(item);
        }

        public void deleteItem(@PathVariable Integer id) {
        	itemRepository.deleteById(id);
        }

}
