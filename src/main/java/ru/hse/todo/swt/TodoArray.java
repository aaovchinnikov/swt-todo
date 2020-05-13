package ru.hse.todo.swt;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import ru.hse.todo.Todo;
import ru.hse.todo.TodoStorage;
import ru.hse.todo.outputs.BriefTodoOutput;

/**
 * Decorator around {@link TodoStorage} to represent its content as array of
 * {@link String}s. Use {@link #items()} method to get mentioned array.
 * 
 * @author Alexander Ovchinnikov
 *
 */
public class TodoArray {
	private final TodoStorage storage;
	private final BriefTodoOutput output;

	/**
	 * @param storage
	 */
	public TodoArray(TodoStorage storage) {
		this.storage = storage;
		this.output = new BriefTodoOutput();
	}

	public String[] items() throws IOException {
		final List<Todo> todos = storage.todos();
		final List<String> items = new LinkedList<>();
		for (Todo todo : todos) {
			todo.print(this.output);
			items.add(this.output.brief());
		}
		return items.toArray(new String[0]);
	}
}
