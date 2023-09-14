package DatabaseJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataToDataBase {

	public static void main(String[] args) throws SQLException {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb ", "root", "supernatural05");
		Statement state = connection.createStatement();
		String query = "insert into student(first_name,last_name,address)values('heesung','kim','daegu')";
		int result = state.executeUpdate(query);
		
		if(result == 1)
		{
			System.out.println("Data Updated");
		}
		else
		{
			System.out.println("Update Failed");
		}
	}

}
