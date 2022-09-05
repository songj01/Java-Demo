package com.sjiang2020.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sjiang2020.model.Todo;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();

	private static int todoCount = 4;
	static {
		todos.add(new Todo(1, "Jack", "Learn Spring MVC", new Date(), false));
		todos.add(new Todo(2, "Jack", "Learn Spring Boot", new Date(), false));
		todos.add(new Todo(3, "Jill", "Learn MVC", new Date(), false));
		todos.add(new Todo(4, "Jill", "Learn Spring", new Date(), false));

	}

	public Todo addTodo(String name, boolean done, String desc, Date targetDate) {
		Todo todo = new Todo(++todoCount, name, desc, targetDate, done);
		todos.add(todo);
		return todo;
	}

	public Todo deleteById(int id) {
		Todo todo = retrieveTodoById(id);
		if (todo == null) {
			throw new RuntimeException("Todo not found");
		}

		if (todos.remove(todo)) {
			return todo;
		}
		throw new RuntimeException("Delete Unsucessfully");
	}

	public List<Todo> retrieveTodoByName(String name) {
		List<Todo> filterTodos = new ArrayList<>();
		for (Todo todo : todos) {
			if (todo.getUser().equals(name)) {
				filterTodos.add(todo);
			}
		}
		return filterTodos;
	}

	public Todo retrieveTodoById(int id) {

		for (Todo todo : todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}

		return null;
	}

	public Todo updateTodo(Todo todo) {
		Todo todoOld = retrieveTodoById(todo.getId());

		if (todoOld == null) {
			throw new RuntimeException("Todo not found");
		}
		int index = todos.indexOf(todoOld);
		todos.set(index, todo);
		return todo;

	}

}
