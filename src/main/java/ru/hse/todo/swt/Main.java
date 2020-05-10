package ru.hse.todo.swt;

import org.eclipse.swt.widgets.Display;

import ru.hse.todo.swt.controls.MainWindow;

public class Main {
	public static void main(String[] args) {
		Display display = new Display();
		MainWindow window = new MainWindow(display);
		window.open();
		window.runEventDispatching();
	}
}
