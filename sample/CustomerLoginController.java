package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import java.awt.*;
import java.io.IOException;

/**
 * Controller class for Customer Login scene
 */
public class CustomerLoginController {
    @FXML private TextField customerusernameTextField;
    @FXML private PasswordField customerpasswordPasswordField;
    private String Customerusername;
    private String Customerpassword;
    /**
     * Method for changing the Scene to StaffLogin
     */
    public void StaffLoginbuttonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent StaffViewParent = FXMLLoader.load(getClass().getResource("Staff_login_Draft.fxml"));
        Scene StaffLoginScene = new Scene(StaffViewParent);
        // Get Stage Info
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(StaffLoginScene);
        window.show();
    }
    /**
     * Method for changing the Scene to CustomerLogin
     * @param event
     */
    public void CustomerSignupbuttonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent CustomerViewParent = FXMLLoader.load(getClass().getResource("Customer_signup_Scene.fxml"));
        Scene CustomerSignupScene = new Scene(CustomerViewParent);
        // Get Stage Info
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(CustomerSignupScene);
        window.show();
    }

    /**
     * Method for getting Username and password
     * @param event
     */

    public void LoginButtonPressed(javafx.event.ActionEvent event) {
        Customerusername = customerusernameTextField.getText();
        Customerpassword = customerpasswordPasswordField.getText();
        //testing use only
        System.out.println(Customerusername);
        System.out.println(Customerpassword);
    }
}