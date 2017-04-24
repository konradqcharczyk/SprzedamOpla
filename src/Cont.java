
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Cont extends JPanel{

	private static final long serialVersionUID = 659462587890110700L;
	private ControlPanel controlPanel;
	private CarControl carControl;
	private DeliveryControl deliveryControl;
	private JLabel title;
	public boolean[] isShown = {false,false,false,false,false};

	public Cont(){
		setSize(1080,720);
		setLayout(null);
		addTitle();
		addControlPanel();
		addCarControl();
		addDeliveryControl();
	}
	private void addTitle(){
		title = new JLabel("Sprzedam Opla", SwingConstants.CENTER);
		title.setOpaque(true);
		title.setBackground(Color.BLACK);
		title.setForeground(Color.GRAY);
		title.setBounds(170,30, 700, 50);
		title.setFont(new Font("Helvetica",1,40));
		add(title);
	}
	
	private void addControlPanel(){
		controlPanel = new ControlPanel(this);
		controlPanel.setBounds(50, 100, 250, 500);
		add(controlPanel);
	}
	
	public void addCarControl(){
		carControl = new CarControl();
		carControl.setBounds(310, 90, 200, 250);
		add(carControl);
	}
	public void showCarControl(){
		hideAll();
		carControl.setVisible(true);
		isShown[0] = true;
	}
	public void hideCarControl(){
		carControl.setVisible(false);
		isShown[0] = false;
	}
	
	public void addDeliveryControl(){
		deliveryControl = new DeliveryControl();
		deliveryControl.setBounds(310, 120, 200, 250);
		add(deliveryControl);
	}
	public void showDeliveryControl(){
		hideAll();
		deliveryControl.setVisible(true);
		isShown[1] = true;
	}
	public void hideDeliveryControl(){
		deliveryControl.setVisible(false);
		isShown[1] = false;
	}
	
	private void hideAll(){
		hideCarControl();
		hideDeliveryControl();
		for(int i = 0; i < isShown.length; i++){
			isShown[i] = false;
		}
	}
}
