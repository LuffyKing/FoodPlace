package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class StaffLoginController {
    @FXML TextField StaffusernameTextField;
    @FXML PasswordField StaffpassswordField;
    private String Staffusername;
    private String Staffpassword;
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
    
    /**
     * Method for getting staff username &password
     */
    public void LoginButtonPressed2(javafx.event.ActionEvent event) {
        Staffusername = StaffusernameTextField.getText();
        Staffpassword = StaffpassswordField.getText();
        //testing use only
        System.out.println(Staffusername);
        System.out.println(Staffpassword);
    }
    public boolean isStaff() {
        return vaildation();
    }

    private boolean vaildation() {
        return true;
    }
}
