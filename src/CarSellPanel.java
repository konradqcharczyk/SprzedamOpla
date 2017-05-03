

import java.awt.Color;
import java.awt.Font;
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

public class CarSellPanel extends JPanel{

	private static final long serialVersionUID = 656477859888030029L;
	private Cont contener;
	private JLabel sellLabel;
	private JLabel licenceNumberLabel;
	private JTextField licenceNumberTextField;
	private JLabel clientIDLabel;
	private JTextField clientIDTextField;
	private MyButton sellButton;
	
	private JLabel deleteLabel;
	private JLabel licNumDeleteLabel;
	private JTextField licNumDeleteTextField;
	private MyButton deleteButton;
	private JLabel resaultLabel;


	public CarSellPanel(Cont contener){
		this.contener = contener;
		setLayout(new GridLayout(8,2, 0, 10));
		setVisible(false);
		addSellLabel();
		addEmptyLabel();
		addLicenceNumberTextField();
		addClientTextField();
		addSellButton();
		addEmptyLabel();
		addEmptyLabel();
		addEmptyLabel();
		
		addDeleteLabel();
		addEmptyLabel();
		addLicNumDeleteTextField();
		addDeleteButton();
		addResaultLabel();
	}
	private void addSellLabel(){
		sellLabel = new JLabel("Sell", SwingConstants.CENTER);
		sellLabel.setFont(new Font("Helvetica",1,20));
		add(sellLabel);
	}
	
	private void addLicenceNumberTextField()
	{
		licenceNumberLabel = new JLabel("Licence number");
		licenceNumberTextField = new JTextField();
		add(licenceNumberLabel);
		add(licenceNumberTextField);
	}
	
	private void addClientTextField()
	{
		clientIDLabel = new JLabel("Client ID");
		clientIDTextField= new JTextField();
		add(clientIDLabel);
		add(clientIDTextField);
	}
	
	private void addSellButton(){
		sellButton = new MyButton("Sell");
		add(sellButton);
	}
	
	
	
	private void addDeleteLabel(){
		deleteLabel = new JLabel("Delete", SwingConstants.CENTER);
		deleteLabel.setFont(new Font("Helvetica",1,20));
		add(deleteLabel);
	}
	
	private void addLicNumDeleteTextField(){
		licNumDeleteTextField = new JTextField();
		licNumDeleteLabel = new JLabel("Licence number");
		add(licNumDeleteLabel);
		add(licNumDeleteTextField);
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
		
		add(deleteButton);
	}

	
	private void addResaultLabel(){
		resaultLabel = new JLabel("Succes!", SwingConstants.CENTER);
		resaultLabel.setForeground(Color.GREEN);
		resaultLabel.setVisible(false);
		add(resaultLabel);
	}
	private void addEmptyLabel(){
		JLabel empty = new JLabel("");
		add(empty);
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
