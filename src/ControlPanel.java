import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ControlPanel extends JPanel{

	private static final long serialVersionUID = -6969280129122570471L;
	private Cont contener;

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
		addvehicleButton();
	}
	
	
	private void addCarButton(){
		MyButton carButton = new MyButton("Car");

		carButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!contener.isShown[0]){
					contener.showCarControl();
				}
				else{
					contener.hideCarControl();
				}
			}
		});
		add(carButton);
	}
	
	private void addDeliveryButton(){
		MyButton deliveryButton = new MyButton("Delivery");
		deliveryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!contener.isShown[1]){
					contener.showDeliveryControl();
				}
				else{
					contener.hideDeliveryControl();
				}
			}
		});
		add(deliveryButton);
	}
	
	private void addClientButton(){
		MyButton clientButton = new MyButton("Client");
		add(clientButton);
	}
	
	private void addEmplyeeButton(){
		MyButton emplyeeButton = new MyButton("Emplyee");
		add(emplyeeButton);
	}
	
	private void addvehicleButton(){
		MyButton vehicleButton = new MyButton("Vehicle");
		add(vehicleButton);
	}

}
