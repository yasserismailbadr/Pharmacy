package application;

import java.io.IOException;
import java.text.ParseException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class UpdataDelete {
	@FXML
	private TextField name_medication;
	@FXML
	private TextField quantity;
	@FXML
	private TextField price;
	@FXML
	private TextField type;
	@FXML
	private TextField concentrates;	 
	@FXML
	private TextField effective_substance;
	@FXML
	private TextField Purpose_of_medications;
	@FXML
	private TextField production_date;
	@FXML
	private TextField expiry_date;
	
	public void findMedication(ActionEvent e) throws IOException, ParseException{
	String stri=name_medication.getText();
	
	Pharmacopia phar=FunctionData.findMedication(stri);
	quantity.setText(phar.getQuantity());
	price.setText(String.valueOf(phar.getPrice()));
	type.setText(phar.getType());
	concentrates.setText(phar.getConcentrates());
	effective_substance.setText(phar.getEffective_substance());
	Purpose_of_medications.setText(phar.getPurpose_of_medications());
	production_date.setText(phar.getProduction_date());
	expiry_date.setText(phar.getExpiry_date());
	
	
	}
	public void deleteMedication(ActionEvent e) throws IOException, ParseException{
		String stri=name_medication.getText();
		FunctionData.delete(stri);
//		int strig=Integer.parseInt(FunctionData.delete(stri));
		int strig=Integer.parseInt(FunctionData.delete(stri));
		
		if(strig>0){  
        	
        	
	  		  Alert alert = new Alert(AlertType.INFORMATION);
	  		  alert.setTitle("Data delete");
	  		  alert.setHeaderText("Information Dialog");
	  		  alert.setContentText("Record deleted successfully!");

	  		  alert.showAndWait();
	        	
	        	
//	       	 System.out.println(" Record deleted successfully! ");
	        }else{ 
	        	
	  		  Alert alert = new Alert(AlertType.ERROR);
	  		  alert.setTitle("Data update");
	  		  alert.setHeaderText("ERROR Dialog");
	  		  alert.setContentText("Sorry! unable to delete record");

	  		  alert.showAndWait();
	        	
	        	
	        	
	        	
//	      	System.out.println("Sorry! unable to update record");  
	        } 
		eraseAllData();
	}
	public void updateMedication(ActionEvent e) throws IOException, ParseException{
		String stri=name_medication.getText();
		
		String quant=quantity.getText();
		double pric=Double.parseDouble(price.getText());
		String typ=type.getText();
		String concen=concentrates.getText();
		String effec=effective_substance.getText();
		String purpo=Purpose_of_medications.getText();
		String prod=production_date.getText();
		String ex=expiry_date.getText();
		
		Pharmacopia phar=new Pharmacopia();
		phar.setName_medication(stri);
		phar.setQuantity(quant);
		phar.setPrice(pric);
		phar.setType(typ);
		phar.setConcentrates(concen);
		phar.setEffective_substance(effec);
		phar.setPurpose_of_medications(purpo);
		phar.setProduction_date(prod);
		phar.setExpiry_date(ex);
	
		int status=FunctionData.updataData(phar);  
        if(status>0){  
        	
        	
  		  Alert alert = new Alert(AlertType.INFORMATION);
  		  alert.setTitle("Data update");
  		  alert.setHeaderText("Information Dialog");
  		  alert.setContentText("Record updated successfully!");

  		  alert.showAndWait();
        	
        	
        	// System.out.println(" Record saved successfully! ");
        }else{ 
        	
  		  Alert alert = new Alert(AlertType.ERROR);
  		  alert.setTitle("Data update");
  		  alert.setHeaderText("ERROR Dialog");
  		  alert.setContentText("Sorry! unable to update record");

  		  alert.showAndWait();
        	
        	
        	
        	
        //	System.out.println("Sorry! unable to update record");  
        }
        eraseAllData();
	}
	private void eraseAllData(){
		name_medication.setText("");
		quantity.setText("");
		price.setText("");
		type.setText("");
		concentrates.setText("");
		effective_substance.setText("");
		Purpose_of_medications.setText("");
		production_date.setText("");
		expiry_date.setText("");
	}

}
