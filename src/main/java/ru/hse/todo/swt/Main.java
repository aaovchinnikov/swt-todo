package ru.hse.todo.swt;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.eclipse.swt.widgets.Display;

import ru.hse.todo.TodoStorage;
import ru.hse.todo.storages.InMemoryTodoList;
import ru.hse.todo.swt.controls.DetailsPane;
import ru.hse.todo.swt.controls.ListPane;
import ru.hse.todo.swt.controls.MainWindow;
import ru.hse.todo.todos.SimpleTodo;

public class Main {
	public static void main(String[] args) throws IOException {
		final String formatString = "yyyy.MM.dd HH:mm";
		final DateTimeFormatter yyyy_MM_dd_HH_mm = DateTimeFormatter.ofPattern(formatString);
		final TodoStorage storage = new InMemoryTodoList(yyyy_MM_dd_HH_mm);
    	storage.add(
        	new SimpleTodo(
           		"Task 1",
               	"Description 1",
               	LocalDateTime.of(2020, 05, 03, 14, 00).atZone(ZoneId.systemDefault()),
               	yyyy_MM_dd_HH_mm
        	)
        );
        storage.add(
           	new SimpleTodo(
           		"Task 2",
           		"Description 2",
           		LocalDateTime.parse(
           			"2020.05.04 15:00",
                   	yyyy_MM_dd_HH_mm
                ).atZone(ZoneId.systemDefault()),
           		yyyy_MM_dd_HH_mm
           	)
        );
        storage.add(
        	new SimpleTodo(
        		"Task 3",
        		"Description 3",
        		LocalDateTime.parse(
        			"2020.05.05 15:00",
        			yyyy_MM_dd_HH_mm
        		).atZone(ZoneId.systemDefault()),
        		yyyy_MM_dd_HH_mm
        	)
        );
		final Display display = new Display();
		final MainWindow window = new MainWindow(
			display,
			new ListPane(display, new TodoArray(storage)),
			new DetailsPane(display)
		);
		window.open();
		window.runEventDispatching();
	}
}
