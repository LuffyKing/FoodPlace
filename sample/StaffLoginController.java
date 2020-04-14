package sample;

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
import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        Parent CustomerViewParent = FXMLLoader.load(getClass().getResource("Customer_login_Scene.fxml"));
        Scene CustomerLoginScene = new Scene(CustomerViewParent);
        // Get Stage Info
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(CustomerLoginScene);
        window.show();
    }
    public StaffLoginController() {
        con = DBPool.DBPool("root","");
    }
    

    public void LoginButtonPressed2(ActionEvent event) throws IOException {
        if (login() == true) {
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
    public Boolean login() {
        String staffusername = StaffusernameTextField.getText();
        String staffpassword = StaffpassswordField.getText();
        if (staffpassword.isEmpty() || (staffusername.isEmpty())) {
            StaffLoginStatus.setText("Invalid Username/Password");
            return false;
        }
        else{
            //SQL query
            String Loginquery = "SELECT * FROM Staff WHERE S_id = ? AND Password = ?";
            try{
                preparedStatement = con.prepareStatement(Loginquery);
                preparedStatement.setString(1,staffusername);
                preparedStatement.setString(2,staffpassword);
                resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    StaffLoginStatus.setText("Username/Password incorrect");
                    return false;
                }
                else {
                    return true;
                }

            } catch (SQLException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
        //testing use only
        System.out.println(staffusername);
        System.out.println(staffpassword);
        return false;

    }
}
