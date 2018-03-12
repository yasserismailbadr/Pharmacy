package test1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;




public class Delete {
	public static String delete(String id){
	String st =null;
	
	try {
		String sql = "DELETE FROM `pharmacopeia` WHERE `name_medication`=?";
		Connection con = Login.connectDB();
		PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
		 
		preparedStatement.setString(1, id);
		
		st = String.valueOf(preparedStatement.executeUpdate()) ;
		
		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return st;
	
}
}
