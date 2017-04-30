import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class CarControl extends JPanel{
	private static final long serialVersionUID = 3555811020143124023L;
	private Cont contener;
	private MyButton sellButton, addButton, findButton;
	
	public CarControl(Cont contener){
		this.contener = contener;
		setVisible(false);
		setLayout(new GridLayout(3, 1, 20, 10));
		addSellButton();
		addAddButton();
		addFindButton();
	}
	
	public void addSellButton(){
		sellButton = new MyButton("Sell");
		add(sellButton);
	}
	
	public void addAddButton(){
		addButton = new MyButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!contener.isShownPanel[1]){
					resetButtons();
					addButton.setBackground(Color.BLACK);
					contener.showCarAddingPanel();
				}				
				else{
					addButton.setBackground(Color.DARK_GRAY);
					contener.hideCarAddingPanel();
				}
					
			}
		});
		add(addButton);
	}
	
	public void addFindButton(){
		findButton = new MyButton("Find");
		add(findButton);
	}
	
	public void resetButtons(){
		addButton.setBackground(Color.DARK_GRAY);
		findButton.setBackground(Color.DARK_GRAY);
		sellButton.setBackground(Color.DARK_GRAY);
	}

}
