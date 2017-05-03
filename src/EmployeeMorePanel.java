
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;


public class EmployeeMorePanel extends JPanel{

	private static final long serialVersionUID = -6550805552220524203L;
	private JTable employeeTable;
	private Vector<Vector<Object>> data;
	private JScrollPane scrollPane;
	
	private JPanel additional;
	private JLabel budget, average;

	
	public EmployeeMorePanel(){
		setLayout(new GridLayout(2, 1, 0, 30));
		setVisible(false);
		addEmployeeTable();
		addAdditionalPanel();
	}
	
	private void addEmployeeTable()
	{
		data = new Vector<Vector<Object>>();
		Vector<Object> columnNames = new Vector<Object>();
		columnNames.add("ID");
		columnNames.add("First Name");
		columnNames.add("Last Name");
		columnNames.add("Salary");
		columnNames.add("Sex");
		columnNames.add("Branch");
		Statement stmt = null;	
	    String query = "select e.id as id, fname, lname, salary, sex , city from EMPLOYEE e join BRANCH b on e.branch_id = b.id";
	    try{
	        stmt = DataBaseConnection.connection.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
	        	Vector<Object> temp = new Vector<Object>();
	        	temp.add((String)rs.getString("id"));
	        	temp.add((String)rs.getString("fname"));
	        	temp.add((String)rs.getString("lname"));
	        	temp.add((int)rs.getInt("salary"));
	        	temp.add((String)rs.getString("sex"));
	        	temp.add((String)rs.getString("city"));
	        	data.add(temp);
	        }
	        } catch (SQLException e ) {
	            System.out.println(e);
	        } 
	    
		employeeTable = new JTable(data, columnNames);
		employeeTable.setFillsViewportHeight(true);
		employeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		employeeTable.setRowSelectionAllowed(true);
		employeeTable.setColumnSelectionAllowed(false);
		scrollPane = new JScrollPane(employeeTable);
		add(scrollPane);
	}
		
	
private void addAdditionalPanel(){
	additional = new JPanel();
	addBudgetLabel();
	addAverageLabel();
	add(additional);
}
private void addBudgetLabel(){
	Statement stmt = null;	
	String text = new String();
    String query = "select sum(salary) as sum from employee";
    try{
        stmt = DataBaseConnection.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
        	text = (String)rs.getString("sum");
        }
        
        } catch (SQLException e ) {
            System.out.println(e);
        } 
    budget = new JLabel("Monthly expenses: " + text, SwingConstants.CENTER);
    additional.add(budget);
}

private void addAverageLabel(){
	Statement stmt = null;	
	String text = new String();
    String query = "select avg(salary) as avg from employee";
    try{
        stmt = DataBaseConnection.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
        	text = (String)rs.getString("avg");
        }
        
        } catch (SQLException e ) {
            System.out.println(e);
        } 
    average = new JLabel("Average salary: " + text, SwingConstants.CENTER);
    additional.add(average);
}

}