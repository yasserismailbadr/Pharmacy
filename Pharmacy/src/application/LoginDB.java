package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginDB {
		private static String username="yasser";
		private static String password="yasser";
		private static String con_string="jdbc:mysql://localhost/pharmacy";
		

	public static Connection connectDB() throws SQLException{
		return DriverManager.getConnection(con_string, username, password);
		
	}

	}

