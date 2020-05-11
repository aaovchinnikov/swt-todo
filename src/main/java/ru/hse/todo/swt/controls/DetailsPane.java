package ru.hse.todo.swt.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public final class DetailsPane {
	/**
	 * Shell used in controls construction. It is disposed during first
	 * {@link #setParent(Composite)} method call.
	 */
	private final Shell preShell;
	private final Group group;
	private final Text text;
	private final Text text_1;
	private final DateTime dateTime;
	private final DateTime dateTime_1;
	private final Button editButton;
	
	public DetailsPane(Display display) {
		this.preShell = new Shell(display);
		this.group = new Group(this.preShell, SWT.NONE);
		this.group.setText("TODO details");
		this.group.setLayout(new GridLayout(2, false));
		final Label lblName = new Label(this.group, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblName.setText("Name");
		this.text = new Text(this.group, SWT.BORDER);
		this.text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		final Label lblDescription = new Label(this.group, SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		lblDescription.setText("Description");
		this.text_1 = new Text(this.group, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL| SWT.MULTI);
		final GridData gd_text_1 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text_1.heightHint = 73;
		this.text_1.setLayoutData(gd_text_1);
		final Label lblNewLabel = new Label(this.group, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("Due date");
		this.dateTime = new DateTime(this.group, SWT.BORDER | SWT.DROP_DOWN);
		dateTime.setEnabled(false);
		dateTime.setDate(1970, 0, 1);
		dateTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		final Label lblDueTime = new Label(this.group, SWT.NONE);
		lblDueTime.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDueTime.setText("Due time");
		this.dateTime_1 = new DateTime(this.group, SWT.BORDER | SWT.TIME | SWT.LONG);
		dateTime_1.setEnabled(false);
		dateTime_1.setTime(0, 0, 0);
		dateTime_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		this.editButton = new Button(this.group, SWT.NONE);
		this.editButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		this.editButton.setText("Edit");
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
