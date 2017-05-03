

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class CarSellPanel extends JPanel{

	private static final long serialVersionUID = 656477859888030029L;
	private Cont contener;
	private JPanel sellPanel;
	private JLabel sellLabel;
	private JLabel licenceNumberLabel;
	private JTextField licenceNumberTextField;
	private JLabel clientIDLabel;
	private JTextField clientIDTextField;
	private MyButton sellButton;
	
	private JPanel deletePanel;
	private JLabel deleteLabel;
	private JLabel licNumDeleteLabel;
	private JTextField licNumDeleteTextField;
	private JLabel modelLabel;
	private JLabel carModelLabel;
	private JLabel producerLabel;
	private JLabel carProducerLabel;
	private MyButton deleteButton, infoButton;
	private JLabel resaultLabel;


	public CarSellPanel(Cont contener){
		this.contener = contener;
		setLayout(new GridLayout(2,1, 0, 10));
		setVisible(false);
		addSellPanel();
		addDeletePanel();
	}
	
	private void addSellPanel(){
		sellPanel = new JPanel(new GridLayout(5,2,0,10));
		addSellLabel();
		addEmptySellLabel();
		addLicenceNumberTextField();
		addClientTextField();
		addSellButton();
		add(sellPanel);
	}
	private void addSellLabel(){
		sellLabel = new JLabel("Sell", SwingConstants.CENTER);
		sellLabel.setFont(new Font("Helvetica",1,20));
		sellPanel.add(sellLabel);
	}
	
	private void addLicenceNumberTextField()
	{
		licenceNumberLabel = new JLabel("Licence number");
		licenceNumberTextField = new JTextField();
		sellPanel.add(licenceNumberLabel);
		sellPanel.add(licenceNumberTextField);
	}
	
	private void addClientTextField()
	{
		clientIDLabel = new JLabel("Client ID");
		clientIDTextField= new JTextField();
		sellPanel.add(clientIDLabel);
		sellPanel.add(clientIDTextField);
	}
	
	private void addSellButton(){
		sellButton = new MyButton("Sell");
		sellPanel.add(sellButton);
	}
	
	
	private void addDeletePanel(){
		deletePanel = new JPanel(new GridLayout(6, 2, 0, 10));
		addDeleteLabel();
		addEmptyDeleteLabel();
		addLicNumDeleteTextField();
		addEmptyDeleteLabel();
		addInfoButton();
		addModelLabel();
		addDeleteButton();
		addResaultLabel();
		add(deletePanel);
	}
	private void addDeleteLabel(){
		deleteLabel = new JLabel("Delete", SwingConstants.CENTER);
		deleteLabel.setFont(new Font("Helvetica",1,20));
		deletePanel.add(deleteLabel);
	}
	
	private void addLicNumDeleteTextField(){
		licNumDeleteTextField = new JTextField();
		licNumDeleteLabel = new JLabel("Licence number", SwingConstants.CENTER);
		deletePanel.add(licNumDeleteLabel);
		deletePanel.add(licNumDeleteTextField);
	}
	
	private void addDeleteButton(){
		deleteButton = new MyButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			try {
				deleteCar();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	});
		
		deletePanel.add(deleteButton);
	}
	
	private void addInfoButton(){
		infoButton = new MyButton("Info");
		infoButton.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			try {
				updateLabels(licNumDeleteTextField.getText());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	});
		
		deletePanel.add(infoButton);
	}
	
	private void addModelLabel(){
		modelLabel = new JLabel("Car model: ", SwingConstants.CENTER);
		carModelLabel = new JLabel("", SwingConstants.CENTER);
		producerLabel = new JLabel("Car producer: ", SwingConstants.CENTER);
		carProducerLabel = new JLabel("", SwingConstants.CENTER);
		deletePanel.add(producerLabel);
		deletePanel.add(carProducerLabel);
		deletePanel.add(modelLabel);
		deletePanel.add(carModelLabel);
	}

	
	private void addResaultLabel(){
		resaultLabel = new JLabel("Succes!", SwingConstants.CENTER);
		resaultLabel.setForeground(Color.GREEN);
		resaultLabel.setVisible(false);
		deletePanel.add(resaultLabel);
	}
	private void addEmptySellLabel(){
		JLabel empty = new JLabel("");
		sellPanel.add(empty);
	}
	private void addEmptyDeleteLabel(){
		JLabel empty = new JLabel("");
		deletePanel.add(empty);
	}
	
	private void deleteCar() throws SQLException{
	    Statement stmt = null;
	    String lic_num = licNumDeleteTextField.getText();
	    String query = "DELETE FROM CAR WHERE lic_num = '" + lic_num +"'";

	    if(carExists(lic_num))
	    {
		    deleteBrought_In(lic_num);
		    deletePurchase(lic_num);
	    try{
	        stmt = DataBaseConnection.connection.createStatement();
	        stmt.executeQuery(query);
        	resaultLabel.setForeground(Color.GREEN);
        	resaultLabel.setText("Succes!");
        	resaultLabel.setVisible(true);
        	contener.updateEditTable();
        	
	        } catch (SQLException e ) {
	            System.out.println(e);
	        } finally {
	            if (stmt != null) { stmt.close(); }
	        } 
	    }
	}
	
	private boolean carExists(String lic){
	    Statement stmt = null;
	    String query = "select count(*) from car where lic_num = '" + lic +"'";
	    try{
	        stmt = DataBaseConnection.connection.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
		        if(rs.getInt("count(*)") == 1) 
		        	return true;
	        }

	        } catch (SQLException e ) {
	        	System.out.println(e);
	        	return false;            
	        }
    	resaultLabel.setForeground(Color.RED);
    	resaultLabel.setText("Failed");
    	resaultLabel.setVisible(true);
	    return false;
	}
	
	
	private void updateLabels(String lic)throws SQLException{
	    Statement stmt = null;
	    String query = "select producer, model from car where lic_num = '" + lic +"'";
	    try{
	        stmt = DataBaseConnection.connection.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
		        carProducerLabel.setText(rs.getString("producer"));
		        carModelLabel.setText(rs.getString("model"));
	        }

	        } catch (SQLException e ) {
	        	System.out.println(e);         
	        }
	}
	private void deleteBrought_In(String lic){
	    Statement stmt = null;
	    String query = "DELETE FROM BROUGHT_IN WHERE Car_Lic_Num = '" + lic +"'";
	    try{
	        stmt = DataBaseConnection.connection.createStatement();
	        stmt.executeQuery(query);
	        } catch (SQLException e ) {
	            System.out.println(e);
	        } 
	}
	private void deletePurchase(String lic){
	    Statement stmt = null;
	    String query = "DELETE FROM PURCHASE WHERE Car_Lic_Num = '" + lic +"'";
	    try{
	        stmt = DataBaseConnection.connection.createStatement();
	        stmt.executeQuery(query);
	        } catch (SQLException e ) {
	            System.out.println(e);
	        } 
	}
	
	
}
