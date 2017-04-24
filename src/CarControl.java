import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class CarControl extends JPanel{
	private static final long serialVersionUID = 3555811020143124023L;
	
	public CarControl(){
		
		setOpaque(true);
		//setBackground(Color.GRAY);
		setPreferredSize(new Dimension(300, 300));
		setMaximumSize(new Dimension(300, 300));
		setMinimumSize(new Dimension(300, 300));
		setLayout(new GridLayout(3, 1, 20, 10));
		
		setVisible(false);
		
		MyButton carButton = new MyButton("Sell");
		add(carButton);
		
		MyButton deliveryButton = new MyButton("Add");
		add(deliveryButton);
		
		MyButton clientButton = new MyButton("Find");
		add(clientButton);

	}

}
