package com.henriquemoreira.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class TodoList implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@OneToMany(mappedBy = "list")
	@JsonManagedReference
	private List<TodoListItem> items = new ArrayList<TodoListItem>();

	TodoList() { }
	
    public TodoList(String name) {
        this.nome = name;
}

	public Integer getId() {
		 return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    public String getNome() {
        return this.nome;
	}
	
	public void setNome(String name) {
	        this.nome = name;
	}

	public List<TodoListItem> getItems() {
		return items;
	}

	public void setItems(List<TodoListItem> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TodoList other = (TodoList) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
