import java.awt.GridLayout;

import javax.swing.JPanel;

public class EmployeeControl extends JPanel{
	private static final long serialVersionUID = 3789521311806678358L;
	private MyButton hireButton, fireButton, editButton;
	public EmployeeControl(){
		setVisible(false);
		setLayout(new GridLayout(3, 1, 20, 10));
		addHireButton();
		addFireButton();
		addEditButton();
	}
	public void addHireButton(){
		hireButton = new MyButton("Hire");
		add(hireButton);
	}
	public void addFireButton(){
		fireButton = new MyButton("Fire");
		add(fireButton);
	}
	public void addEditButton(){
		editButton = new MyButton("Edit");
		add(editButton);
	}


}
