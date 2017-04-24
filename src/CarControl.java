import java.awt.GridLayout;

import javax.swing.JPanel;

public class CarControl extends JPanel{
	private static final long serialVersionUID = 3555811020143124023L;
	
	public CarControl(){
		setVisible(false);
		setLayout(new GridLayout(3, 1, 20, 10));
		addSellButton();
		addAddButton();
		addFindButton();
	}
	
	public void addSellButton(){
		MyButton sellButton = new MyButton("Sell");
		add(sellButton);
	}
	public void addAddButton(){
		MyButton addButton = new MyButton("Add");
		add(addButton);
	}
	public void addFindButton(){
		MyButton findButton = new MyButton("Find");
		add(findButton);
	}

}
