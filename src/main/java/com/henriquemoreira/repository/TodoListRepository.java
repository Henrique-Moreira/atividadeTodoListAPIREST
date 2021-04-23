package com.henriquemoreira.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.henriquemoreira.domain.TodoList;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Integer> {

}
