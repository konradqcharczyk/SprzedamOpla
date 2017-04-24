
import javax.swing.JPanel;


public class Cont extends JPanel{

	private static final long serialVersionUID = 659462587890110700L;
	private ControlPanel controlPanel;
	private CarControl carControl;
	public boolean isCarControl = false;
	public Cont(){
		setSize(1080,720);
		controlPanel = new ControlPanel(this);
		carControl = new CarControl();
		setLayout(null);
		controlPanel.setBounds(100, 110, 200, 500);
		add(controlPanel);
		carControl.setBounds(320, 90, 200, 250);
		add(carControl);
	}
	
	public void addCarControl(){
		carControl.setVisible(true);
	}
	public void removeCarControl(){
		carControl.setVisible(false);
	}
}
