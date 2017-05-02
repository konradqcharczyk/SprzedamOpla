import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class CarControl extends JPanel{
	private static final long serialVersionUID = 3555811020143124023L;
	private Cont contener;
	private MyButton sellButton, addButton, editButton;
	
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
		sellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!contener.isShownPanel[0]){
					resetButtons();
					sellButton.setBackground(Color.BLACK);
					contener.showCarSellPanel();
				}				
				else{
					sellButton.setBackground(Color.DARK_GRAY);
					contener.hideCarSellPanel();
				}
					
			}
		});
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
		editButton = new MyButton("Edit");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!contener.isShownPanel[2]){
					resetButtons();
					editButton.setBackground(Color.BLACK);
					contener.showCarEditPanel();
				}				
				else{
					editButton.setBackground(Color.DARK_GRAY);
					contener.hideCarEditPanel();
				}
					
			}
		});
		add(editButton);
	}
	
	public void resetButtons(){
		addButton.setBackground(Color.DARK_GRAY);
		editButton.setBackground(Color.DARK_GRAY);
		sellButton.setBackground(Color.DARK_GRAY);
	}

}
