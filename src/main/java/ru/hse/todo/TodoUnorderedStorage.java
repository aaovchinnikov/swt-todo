package ru.hse.todo;

import java.io.IOException;
import java.util.Collection;

/**
 * Defines storage for {@link Todo} objects, that doesn't allow to rely on order
 * and indexes of stored objects.
 * 
 * @author Alexander Ovchinnikov
 * @implSpec Any uniqness logic of stored objects should be declared explicitly
 *           in implementing code.
 */

public interface TodoUnorderedStorage {
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
	 * Removes the first occurrence of provided {@link Todo} from storage.
	 * 
	 * @param todo - {@link Todo} to be removed from the storage.
	 * @throws IOException in case of any troubles with underneath storage.
	 * @implSpec Removal should rely on internal/serialized form of objects in the
	 *           storage - let the storage to do its business.
	 */
	void remove(Todo todo) throws IOException;

	/**
	 * Returns all stored {@link Todo}s.
	 * 
	 * @return all stored {@link Todo}s as {@link Collection}.
	 * @throws IOException in case of any troubles with underneath storage.
	 * @implSpec Returned Collection is unmodifiable and read-only snapshot view of
	 *           storage at the moment of invocation. Use {@link #add(Todo)} and
	 *           {@link #remove(Todo)} to modify stored data.
	 */
	Collection<Todo> todos() throws IOException;
}
