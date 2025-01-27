package com.app.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(++todosCount, "Zayn","Learn Guitar", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "Malik","Learn Calisthenics", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "Paul","Learn Football", LocalDate.now().plusYears(1), false));
	}
	
	public List<Todo> findByUsername(String username) {
		return todos;
	}
	
	public void addTodo(String username, String description, LocalDate localDate, boolean isDone) {
		Todo todo = new Todo(++todosCount, username, description, localDate, isDone);
		todos.add(todo);
	}
	
	public void deleteTodoById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteTodoById(todo.getId());
		todos.add(todo);
	}
}
