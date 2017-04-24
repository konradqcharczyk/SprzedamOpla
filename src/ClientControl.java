import java.awt.GridLayout;

import javax.swing.JPanel;

public class ClientControl extends JPanel{
	private static final long serialVersionUID = 3555811020143124023L;
	
	public ClientControl(){
		setVisible(false);
		setLayout(new GridLayout(3, 1, 20, 10));
		addAddButton();
		addRemoveButton();
		addFindButton();
	}
	

	public void addAddButton(){
		MyButton addButton = new MyButton("Add");
		add(addButton);
	}
	public void addRemoveButton(){
		MyButton removeButton = new MyButton("Remove");
		add(removeButton);
	}
	public void addFindButton(){
		MyButton findButton = new MyButton("Find");
		add(findButton);
	}


}
