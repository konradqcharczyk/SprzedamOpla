

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CarAddingPanel extends JPanel{

	private static final long serialVersionUID = 656477859888030029L;
	
	private Cont contener;
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
	private JLabel branchLabel;
	private JComboBox<String> branchComboBox;
	private MyButton addButton;
	private JLabel resaultLabel;
	
	
	public CarAddingPanel(Cont contener){
		this.contener = contener;
		setLayout(new GridLayout(8, 2, 0, 30));
		setVisible(false);
		addLicenceNumberTextField();
		addProducerTextField();
		addModelTextField();
		addPriceTextField();
		addFromTextField();
		addYearTextField();
		addBranchComboBox();
		addAddButton();
		addResaultLabel();
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
		addButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					addCar();
					contener.updateEditTable();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(addButton);
	}
	private void addBranchComboBox()
	{ 
		Vector<String> branches = new Vector<String>();
		Statement stmt = null;	
	    String query = "select city as res from BRANCH";
	    try{
	        stmt = DataBaseConnection.connection.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
	            branches.add(rs.getString("res"));
	        }
	        } catch (SQLException e ) {
	            System.out.println(e);
	        } 
	    
		branchLabel = new JLabel("Branch");
		branchComboBox = new JComboBox<String>(branches);
		add(branchLabel);
		add(branchComboBox);
	}
	
	private void addResaultLabel(){
		resaultLabel = new JLabel("Succes!", SwingConstants.CENTER);
		resaultLabel.setForeground(Color.GREEN);
		resaultLabel.setVisible(false);
		add(resaultLabel);
	}
	
	
	private void addCar() throws SQLException{
	    Statement stmt = null;
	    String lic_num = licenceNumberTextField.getText();
	    String producer = producerTextField.getText();
	    String model = modelTextField.getText();
	    String price = priceTextField.getText();
	    String from = fromTextField.getText();
	    String year = yearTextField.getText();
	    String branch = (String) branchComboBox.getSelectedItem();
	    String query = "INSERT INTO CAR VALUES('" + lic_num + "','" + producer  + "','" + model 
	    		+ "'," + price + ",'" + from + "'," + year +", " + findBranchID(branch) + ")";

	    try{
	        stmt = DataBaseConnection.connection.createStatement();
	        stmt.executeQuery(query);
        	resaultLabel.setForeground(Color.GREEN);
        	resaultLabel.setText("Succes!");
        	resaultLabel.setVisible(true);
	        } catch (SQLException e ) {
	        	resaultLabel.setForeground(Color.RED);
	        	resaultLabel.setText("Failed");
	        	resaultLabel.setVisible(true);
	        	JOptionPane.showMessageDialog(null, e, "Error",
                        JOptionPane.ERROR_MESSAGE);
	        } finally {
	            if (stmt != null) { stmt.close(); }
	        }  
	}
	
	private int findBranchID(String branch){
		Statement stmt = null;	
	    String query = "select ID from BRANCH where city = '"+branch+"'";
	    try{
	        stmt = DataBaseConnection.connection.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
	            return rs.getInt("id");
	        }
	        } catch (SQLException e ) {
	            System.out.println(e);
	            return 0;
	        }
		return 1; 
	}
}
