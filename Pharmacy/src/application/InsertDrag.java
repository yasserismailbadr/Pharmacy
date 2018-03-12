package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class InsertDrag {
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
	
	public void insertData(ActionEvent e) throws IOException{
		
		if(name_medication.getText().trim().isEmpty()){
	        Alert fail= new Alert(AlertType.INFORMATION);
	        fail.setHeaderText("failure");
	        fail.setContentText("you havent typed something");
	        fail.showAndWait();
	    } else {
	        
	   
	
		String nameMedic=name_medication.getText();
		String quant=quantity.getText();
		String pric=price.getText();
		String typ=type.getText();
		String concen=concentrates.getText();
		String effec=effective_substance.getText();
		String purpo=Purpose_of_medications.getText();
		String prod=production_date.getText();
		String ex=expiry_date.getText();
		
		
		double pr=Double.parseDouble(pric);
		
		Pharmacopia phar=new Pharmacopia();
		
		phar.setName_medication(nameMedic);
		phar.setQuantity(quant);
		phar.setPrice(pr);
		phar.setType(typ);
		phar.setConcentrates(concen);
		phar.setEffective_substance(effec);
		phar.setPurpose_of_medications(purpo);
		phar.setProduction_date(prod);
		phar.setExpiry_date(ex);
		
		int status=FunctionData.insertData(phar);
		
		if(status>0){  
			  
			  
			  Alert alert = new Alert(AlertType.INFORMATION);
			  alert.setTitle("Data Insert");
			  alert.setHeaderText("Information Dialog");
			  alert.setContentText("Record saved successfully!");

			  alert.showAndWait();
			  
			  
			  
	      System.out.println(" Record saved successfully! ");  
	           
	      }else{  
	    	  
	    	  
			  Alert alert = new Alert(AlertType.ERROR);
			  alert.setTitle("Data Insert");
			  alert.setHeaderText("ERROR Dialog");
			  alert.setContentText("Sorry! unable to save record");

			  alert.showAndWait();
	      	}
	      }
		eraseAllData();
	}

	private void eraseAllData() {
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
