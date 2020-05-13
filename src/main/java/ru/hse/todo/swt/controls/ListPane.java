package ru.hse.todo.swt.controls;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

import ru.hse.todo.TodoStorage;
import ru.hse.todo.swt.TodoArray;

public final class ListPane {
	/**
	 * Shell used in controls construction. It is disposed during first
	 * {@link #setParent(Composite)} method call.
	 */
	private final Shell preShell;
	private final Group group;
	private final List list;
	private final TodoArray array;

	/**
	 * @param display
	 */
	public ListPane(Display display, TodoArray array) {
		this.array = array;
		this.preShell = new Shell(display);
		this.group = new Group(this.preShell, SWT.NONE);
		this.group.setText("TODOs");
		this.group.setLayout(new GridLayout(1, false));
		this.list = new List(group, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		this.list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		try {
			this.list.setItems(this.array.items());
		} catch (IOException e) {
			e.printStackTrace();
		}
		final Composite composite = new Composite(this.group, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		final Button addButton = new Button(composite, SWT.NONE);
		addButton.setText("Add");
		final Button removeButton = new Button(composite, SWT.NONE);
		removeButton.setText("Remove");
	}

	public void setParent(Composite parent) {
		this.group.setParent(parent);
		if (! this.preShell.isDisposed()) {
			this.preShell.dispose();
		}
	}

	public void setLayoutData(Object layoutData) {
		this.group.setLayoutData(layoutData);
	}
}
