package ru.hse.todo.swt.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public final class MyDetailsPane extends Composite {
	private Text text;
	private Text text_1;

	public MyDetailsPane(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Group grpTodoDetails = new Group(this, SWT.NONE);
		grpTodoDetails.setText("TODO details");
		grpTodoDetails.setLayout(new GridLayout(2, false));
		
		Label lblName = new Label(grpTodoDetails, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblName.setText("Name");
		
		text = new Text(grpTodoDetails, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDescription = new Label(grpTodoDetails, SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		lblDescription.setText("Description");
		
		text_1 = new Text(grpTodoDetails, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL| SWT.MULTI);
		GridData gd_text_1 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text_1.heightHint = 73;
		text_1.setLayoutData(gd_text_1);
		
		Label lblNewLabel = new Label(grpTodoDetails, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("Due date");
		
		DateTime dateTime = new DateTime(grpTodoDetails, SWT.BORDER | SWT.DROP_DOWN);
		dateTime.setEnabled(false);
		dateTime.setDate(1970, 0, 1);
		dateTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label lblDueTime = new Label(grpTodoDetails, SWT.NONE);
		lblDueTime.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDueTime.setText("Due time");
		
		DateTime dateTime_1 = new DateTime(grpTodoDetails, SWT.BORDER | SWT.TIME | SWT.LONG);
		dateTime_1.setEnabled(false);
		dateTime_1.setTime(0, 0, 0);
		dateTime_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Button btnEdit = new Button(grpTodoDetails, SWT.NONE);
		btnEdit.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnEdit.setText("Edit");
		new Label(grpTodoDetails, SWT.NONE);
	}

}
