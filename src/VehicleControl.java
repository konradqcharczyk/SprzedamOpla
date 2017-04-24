import java.awt.GridLayout;

import javax.swing.JPanel;

public class VehicleControl extends JPanel{
	private static final long serialVersionUID = 3789521311806678358L;
	private MyButton addButton, editButton;
	public VehicleControl(){
		setVisible(false);
		setLayout(new GridLayout(3, 1, 20, 10));
		addAddButton();
		addEditButton();
	}
	public void addAddButton(){
		addButton = new MyButton("Add");
		add(addButton);
	}
	public void addEditButton(){
		editButton = new MyButton("Edit");
		add(editButton);
	}


}
