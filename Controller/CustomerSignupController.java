package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import uti.DBConUtil;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CustomerSignupController implements Initializable {
    @FXML
    private TextField CustomerFirstnameTextField;
    @FXML
    private TextField CustomerLastnameTextField;
    @FXML
    private TextField CustomerUsernameTextField;
    @FXML
    private TextField CustomerAdressTextField;
    @FXML
    private PasswordField CustomerPasswordField;
    @FXML
    private Label CustomerSignupStatusLabel;
    @FXML
    private CheckBox TermsNCondiCheckbox;
    Connection con = null;
    PreparedStatement preparedStatement;
    /**
     * Method for changing the Scene to CustomerLogin
     * @param event
     */
    public void CustomerLoginbuttonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent CustomerViewParent = FXMLLoader.load(getClass().getResource("Customer_login_Scene.fxml"));
        Scene CustomerLoginScene = new Scene(CustomerViewParent);
        // Get Stage Info
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(CustomerLoginScene);
        window.show();
    }
    public CustomerSignupController (){
        con =  DBConUtil.connectDB();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    /**
     * method for when signup button is clicked
     * Check filed is filled then save data
     * @param event
     * @throws IOException
     */
    public void CustomerSignupButtonPressed(ActionEvent event) throws IOException {
        if (CustomerFirstnameTextField.getText().isEmpty() || CustomerLastnameTextField.getText().isEmpty() ||
                CustomerUsernameTextField.getText().isEmpty() || CustomerAdressTextField.getText().isEmpty() || CustomerPasswordField.getText().isEmpty()) {
            CustomerSignupStatusLabel.setText("Incomplete Fields");
        }
        else if(!TermsNCondiCheckbox.isSelected()) {
            CustomerSignupStatusLabel.setText("Please agree to the terms and condition");
        }
        else{
            save();
        }

    }

    /**
     * clearing TextField
     */
    private void ClearText() {
        CustomerFirstnameTextField.clear();
        CustomerLastnameTextField.clear();
        CustomerUsernameTextField.clear();
        CustomerAdressTextField.clear();
        CustomerPasswordField.clear();
    }

    /**
     * Method for Insert data to database
     */
    private void save() {
        try {
            String Savedata = "INSERT INTO Customers (first_name, last_name, C_username, address, password) VALUES (?,?,?,?,?)";
            preparedStatement =  con.prepareStatement(Savedata);
            preparedStatement.setString(1,CustomerFirstnameTextField.getText());
            preparedStatement.setString(2,CustomerLastnameTextField.getText());
            preparedStatement.setString(3,CustomerUsernameTextField.getText());
            preparedStatement.setString(4,CustomerAdressTextField.getText());
            preparedStatement.setString(5,CustomerPasswordField.getText());
            preparedStatement.executeUpdate();
            CustomerSignupStatusLabel.setText("Sign up success!");
            ClearText();

        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
