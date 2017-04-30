import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CarAddingPanel extends JPanel{

	private static final long serialVersionUID = 656477859888030029L;
	private JLabel licenceNumberLabel;
	private JTextField licenceNumberTextField;
	private JLabel modelLabel;
	private JTextField modelTextField;
	private JLabel producerLabel;
	private JTextField producerTextField;
	private JLabel priceLabel;
	private JTextField priceTextField;
	private JLabel fromLabel;
	private JTextField fromTextField;
	private JLabel yearLabel;
	private JTextField yearTextField;
	private MyButton addButton;
	
	public CarAddingPanel(){
		setLayout(new GridLayout(7, 2, 0, 30));
		setVisible(false);
		addLicenceNumberTextField();
		addProducerTextField();
		addModelTextField();
		addPriceTextField();
		addFromTextField();
		addYearTextField();
		addAddButton();
	}
	
	private void addLicenceNumberTextField()
	{
		licenceNumberLabel = new JLabel("Licence number");
		licenceNumberTextField = new JTextField();
		add(licenceNumberLabel);
		add(licenceNumberTextField);
	}
	private void addModelTextField()
	{
		modelLabel = new JLabel("Model");
		modelTextField= new JTextField();
		add(modelLabel);
		add(modelTextField);
	}

	private void addProducerTextField()
	{
		producerLabel = new JLabel("Producer");
		producerTextField= new JTextField();
		add(producerLabel);
		add(producerTextField);
	}
	private void addPriceTextField()
	{
		priceLabel = new JLabel("Price");
		priceTextField= new JTextField();
		add(priceLabel);
		add(priceTextField);
	}
	private void addFromTextField()
	{
		fromLabel = new JLabel("From");
		fromTextField= new JTextField();
		add(fromLabel);
		add(fromTextField);
	}
	private void addYearTextField()
	{
		yearLabel = new JLabel("Year of production");
		yearTextField= new JTextField();
		add(yearLabel);
		add(yearTextField);
	}
	private void addAddButton(){
		addButton = new MyButton("Add");
		add(addButton);
	}
}
