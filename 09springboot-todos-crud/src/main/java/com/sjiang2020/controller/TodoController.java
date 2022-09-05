package com.sjiang2020.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.sjiang2020.model.Todo;
import com.sjiang2020.service.TodoService;

@RestController
public class TodoController {

	@Autowired
	TodoService todoService;

	@PostMapping("/users/{name}/todos")
	public ResponseEntity<?> addTodo(@PathVariable String name, @RequestBody Todo todo) {
		Todo addTodo = todoService.addTodo(name, todo.isDone(), todo.getDesc(), todo.getTargetDate());

		if (addTodo == null) {
			return ResponseEntity.noContent().build();
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addTodo.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@GetMapping("users/{name}/todos")
	public List<Todo> retrieveTodoByName(@PathVariable String name) {
		return todoService.retrieveTodoByName(name);

	}

	@GetMapping("/users/todos/{id}")
	public Todo retrieveTodoById(@PathVariable int id) {

		return todoService.retrieveTodoById(id);
	}

	@DeleteMapping("users/{name}/todos/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable String name, @PathVariable int id) {

		Todo todo = todoService.deleteById(id);

		if (todo != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("users/{name}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String name, @PathVariable int id, @RequestBody Todo todo) {

		return ResponseEntity.ok(null);
	}

}
