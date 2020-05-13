package ru.hse.todo.outputs;

import ru.hse.todo.Output;

/**
 * Reuable output. Use {@link #brief()} method to get brief representation of Todo.
 * @author Alexander Ovchinnikov
 *
 */
public final class BriefTodoOutput implements Output {
	private String brief;
	
	@Override
	public Output writeHeader(String header) {
		// do nothing
		return this;
	}

	@Override
	public Output writePart(String name, String value) {
		if (name.equals("name")) {
			this.brief = value;
		}
		return this;
	}

	@Override
	public void writeTrailer(String trailer) {
		// do nothing
	}
	
	public String brief() {
		return this.brief;
	}
}
