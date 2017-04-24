import java.awt.Color;
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
		setOpaque(true);
		//setBackground(Color.GRAY);
		setPreferredSize(new Dimension(300, 500));
		setMaximumSize(new Dimension(300, 600));
		setMinimumSize(new Dimension(300, 600));
		setLayout(new GridLayout(5, 1, 20, 10));
		
		MyButton carButton = new MyButton("Car");
		carButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!contener.isCarControl){
					contener.isCarControl = true;
					contener.addCarControl();
				}
				else{
					contener.isCarControl = false;
					contener.removeCarControl();
				}
			}
		});
		add(carButton);
		
		MyButton deliveryButton = new MyButton("Delivery");
		add(deliveryButton);
		
		MyButton clientButton = new MyButton("Client");
		add(clientButton);
		
		MyButton emplyeeButton = new MyButton("Emplyee");
		add(emplyeeButton);
		
		MyButton vehicleButton = new MyButton("Vehicle");
		add(vehicleButton);
	}
	

}
