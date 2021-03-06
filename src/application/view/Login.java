package application.view;

import java.net.URL;
import java.util.ResourceBundle;

import application.db.ConnectionSingleton;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Login extends AnchorPane implements Initializable {
	
    @FXML
    private Button cancelButton;
    @FXML
    private Button okButton;
    @FXML
    private TextField emailText;
    @FXML
    private TextField passwordText;
    @FXML
    private Label invalidLabel;

    private Stage stage;
    private boolean result = false;

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
    	
    	invalidLabel.setVisible(false);
    	
		cancelButton.setOnAction((event)-> {
			//Close Window
			result = false;
			Platform.exit();
			stage.hide();
		});
		
    	
		okButton.setOnAction((event)-> {
			//Close Window

			result = ConnectionSingleton.getConnectionInstance().Login(emailText.getText(), passwordText.getText());
			
			if(!result)
				invalidLabel.setVisible(true);
			else
				stage.hide();
		});
		
		
		
	
    }
    
	public boolean getResult() {
		return result;
	}
    
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
 
}
