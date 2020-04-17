package FoodPlace.Login;

import FoodPlace.FoodDB.StaffDB;
import FoodPlace.Staff;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StaffLoginController {
    @FXML TextField StaffusernameTextField;
    @FXML PasswordField StaffpassswordField;
    @FXML Label StaffLoginStatus;
    Connection con = null;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    /**
     * Method for changing the Scene to CustomerLogin
     * @param event
     */
    public void CustomerLoginbuttonPressed(ActionEvent event) throws IOException {
        Parent CustomerViewParent = FXMLLoader.load(getClass().getResource("../FXML/Customer_login_Scene.fxml"));
        Scene CustomerLoginScene = new Scene(CustomerViewParent);
        // Get Stage Info
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(CustomerLoginScene);
        window.show();
    }

    public void LoginButtonPressed2(ActionEvent event) throws IOException {
        Staff staff = login();
        if (staff != null) {
            Parent HomeViewParent = FXMLLoader.load(getClass().getResource("Home.fxml"));
            Scene HomeScene = new Scene(HomeViewParent);
            // Get Stage Info
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(HomeScene);
            window.show();
        }
    }
    /**
     * Method for staff username & password login
     */
    public Staff login() {
        Staff staff = null;
        String staffUsername = StaffusernameTextField.getText();
        String staffPassword = StaffpassswordField.getText();
        if (staffPassword.isEmpty() || (staffUsername.isEmpty())) {
            StaffLoginStatus.setText("Invalid Username/Password");
        }
        else{
            //SQL query
            try {
                StaffDB sdb = new StaffDB();
                staff = sdb.getStaff(staffUsername, staffPassword);
                if (staff == null){
                    StaffLoginStatus.setText("User not found");
                }
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
        return staff;

    }
}
