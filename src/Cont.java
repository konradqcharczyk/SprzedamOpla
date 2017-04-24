
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
	private ClientControl clientControl;
	private EmployeeControl employeeControl;
	private VehicleControl vehicleControl;
	private JLabel title;
	public boolean[] isShown = {false,false,false,false,false};

	public Cont(){
		setSize(1080,720);
		setLayout(null);
		addTitle();
		addControlPanel();
		addCarControl();
		addDeliveryControl();
		addClientControl();
		addEmployeeControl();
		addVehicleControl();
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
		carControl.setBounds(310, 90, 150, 200);
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
		deliveryControl.setBounds(310, 145, 150, 200);
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
	
	public void addClientControl(){
		clientControl = new ClientControl();
		clientControl.setBounds(310, 245, 150, 200);
		add(clientControl);
	}
	public void showClientControl(){
		hideAll();
		clientControl.setVisible(true);
		isShown[2] = true;
	}
	public void hideClientControl(){
		clientControl.setVisible(false);
		isShown[2] = false;
	}
	
	public void addEmployeeControl(){
		employeeControl = new EmployeeControl();
		employeeControl.setBounds(310, 345, 150, 200);
		add(employeeControl);
	}
	public void showEmployeeControl(){
		hideAll();
		employeeControl.setVisible(true);
		isShown[3] = true;
	}
	public void hideEmployeeControl(){
		employeeControl.setVisible(false);
		isShown[3] = false;
	}
	
	public void addVehicleControl(){
		vehicleControl = new VehicleControl();
		vehicleControl.setBounds(310, 490, 150, 200);
		add(vehicleControl);
	}
	public void showVehicleControl(){
		hideAll();
		vehicleControl.setVisible(true);
		isShown[4] = true;
	}
	public void hideVehicleControl(){
		vehicleControl.setVisible(false);
		isShown[4] = false;
	}
	
	private void hideAll(){
		hideCarControl();
		hideDeliveryControl();
		hideClientControl();
		hideEmployeeControl();
		hideVehicleControl();
		for(int i = 0; i < isShown.length; i++){
			isShown[i] = false;
		}
	}
}
