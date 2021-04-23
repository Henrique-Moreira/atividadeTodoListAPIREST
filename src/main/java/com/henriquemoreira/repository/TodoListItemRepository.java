package com.henriquemoreira.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.henriquemoreira.domain.TodoListItem;

@Repository
public interface TodoListItemRepository extends JpaRepository<TodoListItem, Integer> {

}
