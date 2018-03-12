package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class FunctionData {
	public static int insertData(Pharmacopia phar) {
		int st=0;
		try(	
				Connection conn=LoginDB.connectDB();
				PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement("INSERT INTO `pharmacopeia`(`name_medication`, `quantity`, `price`, `type`, `concentrates`, `effective_substance`, `Purpose_of_medications`, `production_date`, `expiry_date`) VALUES (?,?,?,?,?,?,?,?,?)");
				
				
				
	 ){
			
			preparedStatement.setString(1, phar.getName_medication());
			preparedStatement.setString(2, phar.getQuantity());
			preparedStatement.setDouble(3, phar.getPrice());
			preparedStatement.setString(4, phar.getType());
			preparedStatement.setString(5, phar.getConcentrates());
			preparedStatement.setString(6, phar.getEffective_substance());
			preparedStatement.setString(7, phar.getPurpose_of_medications());
			preparedStatement.setString(8, phar.getProduction_date());
			preparedStatement.setString(9, phar.getExpiry_date());

			st = preparedStatement.executeUpdate();
			
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
		return st;
	}
	public static int updataData(Pharmacopia phar) {
		int st=0;
		try(	
				Connection conn=LoginDB.connectDB();
				PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement("UPDATE `pharmacopeia` SET `quantity`=?,`price`=?,`type`=?,`concentrates`=?,`effective_substance`=?,`Purpose_of_medications`=?,`production_date`=?,`expiry_date`=? WHERE `name_medication`=?");
				
				
				
	 ){
			
			
			preparedStatement.setString(1, phar.getQuantity());
			preparedStatement.setDouble(2, phar.getPrice());
			preparedStatement.setString(3, phar.getType());
			preparedStatement.setString(4, phar.getConcentrates());
			preparedStatement.setString(5, phar.getEffective_substance());
			preparedStatement.setString(6, phar.getPurpose_of_medications());
			preparedStatement.setString(7, phar.getProduction_date());
			preparedStatement.setString(8, phar.getExpiry_date());
			preparedStatement.setString(9, phar.getName_medication());

			st = preparedStatement.executeUpdate();
			
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
		return st;
	}
	public static Pharmacopia findMedication(String str){
		Pharmacopia phar=new Pharmacopia();
		try (
				Connection con = LoginDB.connectDB();
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement("SELECT  `quantity`, `price`, `type`, `concentrates`, `effective_substance`, `Purpose_of_medications`, `production_date`, `expiry_date` FROM `pharmacopeia` WHERE`name_medication`=?");	
				
		){
			
			
			
			preparedStatement.setString(1, str);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				phar.setQuantity(resultSet.getString(1));
				phar.setPrice(resultSet.getDouble(2));
				phar.setType(resultSet.getString(3));
				phar.setConcentrates(resultSet.getString(4));
				phar.setEffective_substance(resultSet.getString(5));
				phar.setPurpose_of_medications(resultSet.getString(6));
				phar.setProduction_date(resultSet.getString(7));
				phar.setExpiry_date(resultSet.getString(8));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return phar;
		
	}
		public static String delete(String name){
			String st =null;
//			int st=0;
			try{
				String sql = "DELETE FROM `pharmacopeia` WHERE `name_medication`=?";
				Connection con = LoginDB.connectDB();
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
				 
				preparedStatement.setString(1, name);
				
				st = String.valueOf(preparedStatement.executeUpdate()) ;
//				st = preparedStatement.executeUpdate() ;
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return st;
			
		}
}
