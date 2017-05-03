import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class EmployeeControl extends JPanel{
	private static final long serialVersionUID = 3789521311806678358L;
	private MyButton hireButton, fireButton, moreButton;
	private Cont contener;
	public EmployeeControl(Cont contener){
		this.contener = contener;
		setVisible(false);
		setLayout(new GridLayout(3, 1, 20, 10));
		addHireButton();
		addFireButton();
		addMoreButton();
	}
	public void addHireButton(){
		hireButton = new MyButton("Hire");
		add(hireButton);
	}
	public void addFireButton(){
		fireButton = new MyButton("Fire");
		add(fireButton);
	}
	public void addMoreButton(){
		moreButton = new MyButton("More");
		moreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!contener.isShownPanel[3]){
					resetButtons();
					moreButton.setBackground(Color.BLACK);
					contener.showEmployeeMorePanel();
				}				
				else{
					moreButton.setBackground(Color.DARK_GRAY);
					contener.hideEmployeeMorePanel();
				}
					
			}
		});
		add(moreButton);
	}

	public void resetButtons(){
		hireButton.setBackground(Color.DARK_GRAY);
		moreButton.setBackground(Color.DARK_GRAY);
		fireButton.setBackground(Color.DARK_GRAY);
	}
}
