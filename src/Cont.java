
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
	private CarAddingPanel carAddingPanel;
	private CarSellPanel carSellPanel;
	private CarEditPanel carEditPanel;
	public DataBaseConnection dataBaseConnection;
	private JLabel title;
	public boolean[] isShownControl = {false,false,false,false,false};
	public boolean[] isShownPanel = {false,false, false};

	public Cont(){
		setSize(1080,720);
		setLayout(null);
		addTitle();
		addConnection();
		addControlPanel();
		addCarControl();
		addDeliveryControl();
		addClientControl();
		addEmployeeControl();
		addVehicleControl();
		addCarAddingPanel();
		addCarSellPanel();
		addCarEditPanel();
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
		carControl = new CarControl(this);
		carControl.setBounds(310, 90, 150, 200);
		add(carControl);
	}
	
	public void showCarControl(){
		hideAll();
		carControl.setVisible(true);
		isShownControl[0] = true;
	}
	
	public void hideCarControl(){
		carControl.resetButtons();
		carControl.setVisible(false);
		isShownControl[0] = false;
	}
	
	public void addDeliveryControl(){
		deliveryControl = new DeliveryControl();
		deliveryControl.setBounds(310, 145, 150, 200);
		add(deliveryControl);
	}
	
	public void showDeliveryControl(){
		hideAll();
		deliveryControl.setVisible(true);
		isShownControl[1] = true;
	}
	
	public void hideDeliveryControl(){
		deliveryControl.setVisible(false);
		isShownControl[1] = false;
	}
	
	public void addClientControl(){
		clientControl = new ClientControl();
		clientControl.setBounds(310, 245, 150, 200);
		add(clientControl);
	}
	
	public void showClientControl(){
		hideAll();
		clientControl.setVisible(true);
		isShownControl[2] = true;
	}
	
	public void hideClientControl(){
		clientControl.setVisible(false);
		isShownControl[2] = false;
	}
	
	public void addEmployeeControl(){
		employeeControl = new EmployeeControl();
		employeeControl.setBounds(310, 345, 150, 200);
		add(employeeControl);
	}
	
	public void showEmployeeControl(){
		hideAll();
		employeeControl.setVisible(true);
		isShownControl[3] = true;
	}
	
	public void hideEmployeeControl(){
		employeeControl.setVisible(false);
		isShownControl[3] = false;
	}
	
	public void addVehicleControl(){
		vehicleControl = new VehicleControl();
		vehicleControl.setBounds(310, 490, 150, 200);
		add(vehicleControl);
	}
	
	public void showVehicleControl(){
		hideAll();
		vehicleControl.setVisible(true);
		isShownControl[4] = true;
	}
	
	public void hideVehicleControl(){
		vehicleControl.setVisible(false);
		isShownControl[4] = false;
	}
	
	public void addCarAddingPanel(){
		carAddingPanel = new CarAddingPanel(this);
		carAddingPanel.setBounds(580, 150, 350, 450);
		add(carAddingPanel);
	}
	
	public void showCarAddingPanel(){
		hidePanels();
		carAddingPanel.setVisible(true);
		isShownPanel[1] = true;
	}
	
	public void hideCarAddingPanel(){
		carAddingPanel.setVisible(false);
		isShownPanel[1] = false;
	}
	
	public void addCarSellPanel(){
		carSellPanel = new CarSellPanel(this);
		carSellPanel.setBounds(580, 150, 350, 350);
		add(carSellPanel);
	}
	
	public void showCarSellPanel(){
		hidePanels();
		carSellPanel.setVisible(true);
		isShownPanel[0] = true;
	}
	
	public void hideCarSellPanel(){
		carSellPanel.setVisible(false);
		isShownPanel[0] = false;
	}
	
	public void addCarEditPanel(){
		carEditPanel = new CarEditPanel();
		carEditPanel.setBounds(550, 120, 450, 500);
		add(carEditPanel);
	}
	
	public void showCarEditPanel(){
		hidePanels();
		carEditPanel.setVisible(true);
		isShownPanel[2] = true;
	}
	
	public void hideCarEditPanel(){
		carEditPanel.setVisible(false);
		isShownPanel[2] = false;
	}
	
	
	//TODO all this shit up make it private
	public void updateEditTable(){
		carEditPanel.updateTable();
		carEditPanel.setVisible(false);
	}
		
	
	private void hideAll(){
		hideCarControl();
		hideDeliveryControl();
		hideClientControl();
		hideEmployeeControl();
		hideVehicleControl();
		hidePanels();
		for(int i = 0; i < isShownControl.length; i++){
			isShownControl[i] = false;
		}

	}
	
	public void hidePanels(){
		hideCarAddingPanel();
		hideCarSellPanel();
		hideCarEditPanel();
		for(int i = 0; i < isShownPanel.length; i++){
			isShownPanel[i] = false;
		}
	}
	
	private void addConnection()
	{
		dataBaseConnection = new DataBaseConnection();
	}
}
