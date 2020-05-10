package ru.hse.todo.swt.controls;

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;

public final class MainWindow {
	private final Shell shell;
	private final Display display;

	public MainWindow(Display display) {
		this(display, 640, 480);
	}

	public MainWindow(Display display, int width, int height) {
		this.display = display;
		this.shell = new Shell(display);
		this.shell.setSize(width, height);
		this.shell.setText("TODO list");
	}

	/**
	 * Sets window position to center of encapsulated at constructor {@link Display}
	 * and shows it.
	 */
	public void open() {
		Monitor primary = this.display.getPrimaryMonitor();
		Rectangle bounds = primary.getBounds();
		Rectangle rect = shell.getBounds();
		final int x = bounds.x + (bounds.width - rect.width) / 2;
		final int y = bounds.y + (bounds.height - rect.height) / 2;
		this.shell.setLocation(x, y);
		this.shell.open();
	}

	/**
	 * Runs event processing and dispatching mechanism. This call blocks until main
	 * window is closed, so it should be called at the end of caller code.
	 */
	public void runEventDispatching() {
		while (!this.shell.isDisposed()) {
			if (!this.display.readAndDispatch()) {
				this.display.sleep();
			}
		}
		this.display.dispose();
	}
}
