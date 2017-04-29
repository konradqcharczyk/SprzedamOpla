
import java.sql.*;

public class DataBaseConnection {
    String usernameDB = "C##QQS";
    String passwordDB = "qqsdb";
    public Connection connection;


    public DataBaseConnection() throws SQLException{
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/KokosORCL", usernameDB, passwordDB);

        } catch(ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        viewTable(connection);
        
    }
    
    public static void viewTable(Connection con)
    	    throws SQLException {

    	    Statement stmt = null;
    	    String query = "select FNAME, LNAME, SALARY "
    	    		+ "from EMPLOYEE ";
    	    try{
    	        stmt = con.createStatement();
    	        ResultSet rs = stmt.executeQuery(query);
    	        while (rs.next()) {
    	            String fName = rs.getString("FNAME");
    	            String lName = rs.getString("LNAME");
    	            float price = rs.getFloat("SALARY");
    	            System.out.println(fName + "\t" + lName +
    	                               "\t" + price);
    	        }
    	        } catch (SQLException e ) {
    	            System.out.println(e);
    	        } finally {
    	            if (stmt != null) { stmt.close(); }
    	        }        
    	}

}

