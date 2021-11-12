package task01;
import java.sql.*;

import com.sun.jdi.connect.spi.Connection;

public class mysql {

	public  void sqlDataEntry(String name, int pin, String account_type,double balance) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","tiger12345");
			
			Statement stmt=con.createStatement();
			stmt.execute("account");
			//ResultSet rs=stmt.executeQuery("select * from account");
			String sql="Insert values into account values(?,?,?,?)";	//name,pin,account type,balance
			PreparedStatement stat=con.prepareStatement(sql);
			stat.setString(1,name);
			stat.setInt(1,pin);
			stat.setString(1,account_type);
			stat.setDouble(1,balance);
			
			
			con.close();
		}
		catch(SQLException throwables)
		{
			throwables.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}

	}

}
