package ru.hse.todo;

/**
 * Serialization contract. Usage of implementing object supposed to be chained, like
 * <pre>{@code
 * output.writeHeader("head")
 * 	.writePart("name1", "value1")
 * 	...
 * 	<more writes omitted>
 * 	...
 * 	.writePart("nameN", "valueN")
 * 	.writeTrailer("trailer");
 * }</pre>
 * Allows fluent invocations and immutable implementations.
 * 
 * @author Alexander Ovchinnikov
 * @apiNote Supposed to be part of Strategy pattern described at
 *          {@linkplain https://refactoring.guru/design-patterns/strategy}
 */
public interface Output {
	/**
	 * Used to specify data for serialized object header. Usually type-tag name
	 * provided here.
	 * 
	 * @param header
	 */
	Output writeHeader(String header);

	/**
	 * Named portion of data to be stored.
	 * 
	 * @param name
	 * @param value
	 */
	Output writePart(String name, String value);

	/**
	 * Used to specify data for serialized object trailer. Usually this info
	 * correlates to header data. Invocation of this method indicates that all data
	 * for serialization has been provided and object may be serialized.
	 * 
	 * @param trailer
	 */
	void writeTrailer(String trailer);
}
