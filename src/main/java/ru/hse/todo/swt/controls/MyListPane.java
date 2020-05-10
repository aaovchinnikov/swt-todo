package ru.hse.todo.swt.controls;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;

public class MyListPane extends Group {

	public MyListPane(Composite parent, int style) {
		super(parent, style);
		setLayout(new RowLayout(SWT.VERTICAL));
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		List list = new List(scrolledComposite, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setContent(list);
		scrolledComposite.setMinSize(list.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(new RowLayout(SWT.HORIZONTAL));
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.setText("New Button");
		
		Button btnNewButton_1 = new Button(composite, SWT.NONE);
		btnNewButton_1.setText("New Button");
		// TODO Auto-generated constructor stub
	}

}
