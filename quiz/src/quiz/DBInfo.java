package quiz;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBInfo
{
	static Connection con;
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","rat");
		}
		catch(Exception e)
		{
			
		}
	}
}
