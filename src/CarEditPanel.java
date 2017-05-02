
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;


public class CarEditPanel extends JPanel{

	private static final long serialVersionUID = 656477859888030029L;
	private JTable carTable;
	private Vector<Vector<Object>> data;
	JScrollPane scrollPane;
	private MyButton chooseButton;
	
	private JPanel editPanel;
	private JTextField licenceNumberTextField;
	private JTextField modelTextField;
	private JTextField producerTextField;
	private JTextField priceTextField;
	private JTextField fromTextField;
	private JTextField yearTextField;
	private MyButton editButton;
	private GridBagConstraints c; 



	
	public CarEditPanel(){
		setLayout(new GridBagLayout());
		setVisible(false);
		c = new GridBagConstraints();
		addCarTable();
		addChooseButton();
		addEditPanel();
		addEditButton();

//		addProducerTextField();
//		addModelTextField();
//		addPriceTextField();
//		addFromTextField();
//		addYearTextField();
//		addBranchComboBox();
//		addAddButton();
//		addResaultLabel();
	}
	
	private void addCarTable()
	{
		data = new Vector<Vector<Object>>();
		Vector<Object> columnNames = new Vector<Object>();
		columnNames.add("Licence Num");
		columnNames.add("Producer");
		columnNames.add("Model");
		columnNames.add("Price");
		columnNames.add("From");
		columnNames.add("Year of prod");
		Statement stmt = null;	
	    String query = "select lic_num, producer, model, price, country, year_of_prod"
	    		   +   " from CAR";
	    try{
	        stmt = DataBaseConnection.connection.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
	        	Vector<Object> temp = new Vector<Object>();
	        	temp.add((String)rs.getString("lic_num"));
	        	temp.add((String)rs.getString("producer"));
	        	temp.add((String)rs.getString("model"));
	        	temp.add((int)rs.getInt("price"));
	        	temp.add((String)rs.getString("country"));
	        	temp.add((int)rs.getInt("year_of_prod"));
	        	data.add(temp);
	        }
	        } catch (SQLException e ) {
	            System.out.println(e);
	        } 
	    
		carTable = new JTable(data, columnNames);
		carTable.setFillsViewportHeight(true);
		carTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		carTable.setRowSelectionAllowed(true);
		carTable.setColumnSelectionAllowed(false);
		scrollPane = new JScrollPane(carTable);
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.5;
		c.gridwidth = 2;
		c.ipady = 150;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(scrollPane, c);
	}
	
	private void addChooseButton(){
		chooseButton = new MyButton("Choose");
		chooseButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(carTable.getSelectedRow() < 0)
				{
		        	JOptionPane.showMessageDialog(null, "Choose a car!", "Error",
	                        JOptionPane.ERROR_MESSAGE);
		        	return;
				}
				setNewValues(data.get(carTable.getSelectedRow()));
				editButton.setEnabled(true);
			}
		});
		c.gridx = 0;
		c.gridy = 1;
		c.weighty = 0.8;
		c.ipady = 10;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.weightx = 1;
		
		c.ipadx = 50;
		c.insets = new Insets(10,0,0,0);
		add(chooseButton,c);
	}
	
	private void addEditPanel(){
		editPanel = new JPanel(new GridLayout(2, 3, 10, 30));
		licenceNumberTextField = new JTextField("Licence number");
		producerTextField = new JTextField("Producer");
		modelTextField = new JTextField("Model");
		priceTextField = new JTextField("Price");
		fromTextField = new JTextField("From");
		yearTextField = new JTextField("Year");
		editPanel.add(licenceNumberTextField);
		editPanel.add(producerTextField);
		editPanel.add(modelTextField);
		editPanel.add(priceTextField);
		editPanel.add(fromTextField);
		editPanel.add(yearTextField);
		c.gridx = 0;
		c.gridy = 2;
		c.weighty = 1;
		c.weightx = 0;
		c.gridwidth = 2;
		c.ipady = 60;
		c.insets = new Insets(10,0,0,0);
		c.fill = GridBagConstraints.HORIZONTAL;
		add(editPanel, c);
	}
	
	private void setNewValues(Vector<Object> table){
		licenceNumberTextField.setText((String) table.get(0));
		producerTextField.setText((String) table.get(1));
		modelTextField.setText((String) table.get(2));
		priceTextField.setText(Integer.toString((int)table.get(3)));
		fromTextField.setText((String) table.get(4));
		yearTextField.setText(Integer.toString((int)table.get(5)));
		
	}
	private void addEditButton(){
		editButton = new MyButton("Edit");
		editButton.setEnabled(false);
		editButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					editCar();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		c.gridx = 0;
		c.gridy = 3;
		c.weighty = 1;
		c.weightx = 0;
		c.gridwidth = 1;
		c.ipady = 10;
		c.ipadx = 50;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10,0,0,0);
		add(editButton,c);
	}
	
	private void editCar() throws SQLException{
	    Statement stmt = null;
	    String lic_num = licenceNumberTextField.getText();
	    String producer = producerTextField.getText();
	    String model = modelTextField.getText();
	    String price = priceTextField.getText();
	    String from = fromTextField.getText();
	    String year = yearTextField.getText();
	    String query =    "UPDATE CAR "
	    				+ "SET lic_num = '"+lic_num+"' ,producer = '"+producer+"',model = '"+model+"'"
	    				+ ",price = "+price+" ,country = '"+from+"' , year_of_prod = "+year+" "
	    				+ "WHERE lic_num = '"+lic_num+"'";
	    		     
	    try{
	        stmt = DataBaseConnection.connection.createStatement();
	        stmt.executeQuery(query);
	        updateTable();
	        } catch (SQLException e ) {

	        	JOptionPane.showMessageDialog(null, e, "Error",
                        JOptionPane.ERROR_MESSAGE);
	        } finally {
	            if (stmt != null) { stmt.close(); }
	        }  
	}
	
	
	public void updateTable(){
		remove(scrollPane);
		addCarTable();
		setVisible(false);
		setVisible(true);
	}
	

}