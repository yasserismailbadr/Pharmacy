package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Search implements Initializable {
	@FXML
	private TextField searchField;
	@FXML
	private TableView<Pharmacopia> table;
	@FXML
	private TableColumn<Pharmacopia,Integer>id;
	@FXML
	private TableColumn<Pharmacopia,String>name_medication;
	@FXML
	private TableColumn<Pharmacopia,Integer>quantity;
	@FXML
	private TableColumn<Pharmacopia,Integer>price;
	@FXML
	private TableColumn<Pharmacopia,String>type;
	@FXML
	private TableColumn<Pharmacopia,String>concentrates;
	@FXML
	private TableColumn<Pharmacopia,String>effective_substance;
	@FXML
	private TableColumn<Pharmacopia,String>Purpose_of_medications;
	@FXML
	private TableColumn<Pharmacopia,String>production_date;
	@FXML
	private TableColumn<Pharmacopia,String>expiry_date;
	
	public	ObservableList<Pharmacopia> data = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			String sql = "SELECT * FROM `pharmacopeia` WHERE 1";
			Connection con = LoginDB.connectDB();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			
			while (rs.next()) {
				 
		
				data.add(new Pharmacopia(rs.getInt(1), rs.getString(2), rs.getInt(3), 
						rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), 
						rs.getString(8), rs.getString(9), rs.getString(10)));
				 
				
			}

			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
id.setCellValueFactory(new PropertyValueFactory<Pharmacopia,Integer>("id"));
name_medication.setCellValueFactory(new PropertyValueFactory<Pharmacopia,String>("name_medication"));
quantity.setCellValueFactory(new PropertyValueFactory<Pharmacopia,Integer>("quantity"));
price.setCellValueFactory(new PropertyValueFactory<Pharmacopia,Integer>("price"));
type.setCellValueFactory(new PropertyValueFactory<Pharmacopia,String>("type"));
concentrates.setCellValueFactory(new PropertyValueFactory<Pharmacopia,String>("concentrates"));
effective_substance.setCellValueFactory(new PropertyValueFactory<Pharmacopia,String>("effective_substance"));
Purpose_of_medications.setCellValueFactory(new PropertyValueFactory<Pharmacopia,String>("Purpose_of_medications"));
production_date.setCellValueFactory(new PropertyValueFactory<Pharmacopia,String>("production_date"));
expiry_date.setCellValueFactory(new PropertyValueFactory<Pharmacopia,String>("expiry_date"));
table.setItems(data);
FilteredList<Pharmacopia> filteredData = new FilteredList<>(data, p -> true);
	searchField.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredData.setPredicate(person -> {
            // If filter text is empty, display all persons.
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }

            // Compare first name and last name of every person with filter text.
            String lowerCaseFilter = newValue.toLowerCase();

            if (person.getName_medication().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches first name.
            } else if (person.getPurpose_of_medications().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches last name.
            }
            return false; // Does not match.
        });
	 });

    // 3. Wrap the FilteredList in a SortedList. 
    SortedList<Pharmacopia> sortedData = new SortedList<>(filteredData);

    // 4. Bind the SortedList comparator to the TableView comparator.
    sortedData.comparatorProperty().bind(table.comparatorProperty());

    // 5. Add sorted (and filtered) data to the table.
    table.setItems(sortedData);
	
	}


}

