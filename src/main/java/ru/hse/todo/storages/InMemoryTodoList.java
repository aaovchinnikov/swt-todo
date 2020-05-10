package ru.hse.todo.storages;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import ru.hse.todo.Todo;
import ru.hse.todo.TodoOrderedStorage;
import ru.hse.todo.outputs.SimpleTodoFactoryOutput;
import ru.hse.todo.todos.SimpleTodo;

public final class InMemoryTodoList implements TodoOrderedStorage {
	private final List<Todo> todos;
	private final DateTimeFormatter formatter;
	
	/**
	 * @param todos
	 */
	public InMemoryTodoList(DateTimeFormatter formatter) {
		this.todos = new LinkedList<Todo>();
		this.formatter = formatter;
	}

	@Override
	synchronized public Todo add(Todo todo) throws IOException {
		if (todo instanceof SimpleTodo) {
			this.todos.add(todo);
			return todo;
		} else {
			SimpleTodoFactoryOutput output = new SimpleTodoFactoryOutput(this.formatter);
			todo.print(output);
			Todo added = output.build();
			this.todos.add(added);
			return added;
		}
	}

	@Override
	synchronized public void remove(int index, Todo todo) throws IOException {
		Todo compared = this.todos.get(index); 
		if (compared.equals(todo)) {
			this.todos.remove(index);
		}
	}

	@Override
	synchronized public List<Todo> todos() throws IOException {
		return Collections.unmodifiableList(this.todos);
	}

}
