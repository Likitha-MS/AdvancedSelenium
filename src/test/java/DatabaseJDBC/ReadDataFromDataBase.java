package DatabaseJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDataBase {

	public static void main(String[] args) throws Throwable {
		Driver driverRef = new Driver();
		//register the driver
		DriverManager.registerDriver(driverRef);		
		//create connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb ", "root", "supernatural05");
		
		Statement state = connection.createStatement();
		//query
		String query = "Select * from student";
		//execute the query
		ResultSet result = state.executeQuery(query);
		//print result
		while(result.next()) //next() checks if data is present
		{
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		//close connection
		connection.close();
	}

}
