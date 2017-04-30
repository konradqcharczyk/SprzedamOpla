import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ControlPanel extends JPanel{

	private static final long serialVersionUID = -6969280129122570471L;
	private Cont contener;
	private MyButton carButton, deliveryButton, clientButton, employeeButton, vehicleButton;

	public ControlPanel(Cont contener){
		this.contener = contener;
		setPreferredSize(new Dimension(300, 500));
		setMaximumSize(new Dimension(300, 600));
		setMinimumSize(new Dimension(300, 600));
		setLayout(new GridLayout(5, 1, 20, 10));
		addCarButton();
		addDeliveryButton();
		addClientButton();
		addEmplyeeButton();
		addVehicleButton();
	}
	
	
	private void addCarButton(){
		carButton = new MyButton("Car");

		carButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!contener.isShownControl[0]){
					resetButtons();
					carButton.setBackground(Color.BLACK);
					contener.showCarControl();
				}
				else{
					carButton.setBackground(Color.DARK_GRAY);
					contener.hidePanels();
					contener.hideCarControl();
				}
				
			}
		});
		add(carButton);
	}
	
	private void addDeliveryButton(){
		deliveryButton = new MyButton("Delivery");
		deliveryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!contener.isShownControl[1]){
					resetButtons();
					deliveryButton.setBackground(Color.BLACK);
					contener.showDeliveryControl();
				}				
				else{
					deliveryButton.setBackground(Color.DARK_GRAY);
					contener.hidePanels();
					contener.hideDeliveryControl();
				}
					
			}
		});
		add(deliveryButton);
	}
	
	private void addClientButton(){
		clientButton = new MyButton("Client");
		clientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!contener.isShownControl[2]){
					resetButtons();
					clientButton.setBackground(Color.BLACK);
					contener.showClientControl();
				}				
				else{
					clientButton.setBackground(Color.DARK_GRAY);
					contener.hidePanels();
					contener.hideClientControl();
				}
					
			}
		});
		add(clientButton);
	}
	
	private void addEmplyeeButton(){
		employeeButton = new MyButton("Emplyee");
		employeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!contener.isShownControl[3]){
					resetButtons();
					employeeButton.setBackground(Color.BLACK);
					contener.showEmployeeControl();
				}				
				else{
					employeeButton.setBackground(Color.DARK_GRAY);
					contener.hidePanels();
					contener.hideEmployeeControl();
				}
					
			}
		});
		add(employeeButton);
	}
	
	private void addVehicleButton(){
		vehicleButton = new MyButton("Vehicle");
		vehicleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!contener.isShownControl[4]){
					resetButtons();
					vehicleButton.setBackground(Color.BLACK);
					contener.showVehicleControl();
				}				
				else{
					vehicleButton.setBackground(Color.DARK_GRAY);
					contener.hidePanels();
					contener.hideVehicleControl();
				}
					
			}
		});
		add(vehicleButton);
	}
	private void resetButtons(){
		carButton.setBackground(Color.DARK_GRAY);
		clientButton.setBackground(Color.DARK_GRAY);
		deliveryButton.setBackground(Color.DARK_GRAY);
		employeeButton.setBackground(Color.DARK_GRAY);
		vehicleButton.setBackground(Color.DARK_GRAY);
	}
}
