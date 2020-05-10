package ru.hse.todo;

import java.io.IOException;
import java.util.List;

/**
 * Defines storage for {@link Todo} objects, that allows relying on order and
 * indexes in {@link List} returned by {@link #todos()} method.
 * 
 * @author Alexander Ovchinnikov
 * @implSpec Any uniqness logic of stored objects should be declared explicitly
 *           in implementing code.
 */
public interface TodoOrderedStorage {
	/**
	 * Adds new {@link Todo} to storage.
	 * 
	 * @param todo - {@link Todo} to be added/saved in the storage.
	 * @return Storage-specific implementation of provided {@link Todo}.
	 * @throws IOException in case of any troubles with underneath storage.
	 * @implSpec Any modifications to original {@link Todo} are not propagated to
	 *           stored data. Use returned {@link Todo} object for further work
	 *           instead.
	 */
	Todo add(Todo todo) throws IOException;

	/**
	 * Removes {@link Todo} at provided <b>index</b> from storage if it's serialized
	 * form is equal to provided {@link Todo}.
	 * 
	 * @param index - index of {@link Todo} in {@link List} returned by
	 *              {@link #todos()} method.
	 * @param todo  - {@link Todo} to be removed from the storage.
	 * @throws IOException               in case of any troubles with underneath
	 *                                   storage.
	 * @throws IndexOutOfBoundsException in case of provided index is out of the
	 *                                   storage bounds.
	 * @apiNote Use both <b>todo</b> and <b>index</b> to protect against blind
	 *          unintended removal from storage.
	 * @implSpec Removal should rely on internal/serialized form of objects in the
	 *           storage - let the storage to do its business.
	 */
	void remove(int index, Todo todo) throws IOException;

	/**
	 * Returns all stored {@link Todo}s.
	 * 
	 * @return all stored {@link Todo}s as {@link List}.
	 * @throws IOException in case of any troubles with underneath storage.
	 * @implSpec Returned List is unmodifiable and read-only snapshot view of
	 *           storage at the moment of invocation. Use {@link #add(Todo)} and
	 *           {@link #remove(int, Todo)} to modify stored data.
	 */
	List<Todo> todos() throws IOException;
}
