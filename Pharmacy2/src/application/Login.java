package application;




import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login implements Initializable {
	@FXML
	private Label label;
	@FXML
	private TextField textFeild ;
	@FXML
	private PasswordField passwordField;
	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException, SQLException{
	Admin admin=new Admin();
		if (textFeild.getText() .equals(admin.getUsername())&&passwordField.getText().equals(admin.getPassword())) {
			LoginDB.connectDB();
			label.setText("Wellcome");
			Stage primaryStage=new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("Data1.fxml"));
			Scene scene = new Scene(root,916,390);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		
		} else {
            label.setText("the user or password not corect");
        }

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
