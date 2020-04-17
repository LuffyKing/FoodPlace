package FoodPlace.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import uti.DBConUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Controller class for Customer Login scene
 */
public class CustomerLoginController implements Initializable {
    @FXML
    private TextField customerusernameTextField;
    @FXML
    private PasswordField customerpasswordPasswordField;
    @FXML
    private Label CustomerLoginStatus;
    Connection con = null;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    /**
     * Method for changing the Scene to StaffLogin
     */
    public void StaffLoginbuttonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent StaffViewParent = FXMLLoader.load(getClass().getResource("Staff_login_Draft.fxml"));
        Scene StaffLoginScene = new Scene(StaffViewParent);
        // Get Stage Info
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(StaffLoginScene);
        window.show();
    }

    /**
     * Method for changing the Scene to CustomerLogin
     *
     * @param event
     */
    public void CustomerSignupbuttonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent CustomerViewParent = FXMLLoader.load(getClass().getResource("Customer_signup_Scene.fxml"));
        Scene CustomerSignupScene = new Scene(CustomerViewParent);
        // Get Stage Info
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(CustomerSignupScene);
        window.show();
    }

    public CustomerLoginController() {
        con = DBConUtil.connectDB();;
    }

    /**
     * Method for login and scene change
     *
     * @param event
     */

    public void LoginButtonPressed(javafx.event.ActionEvent event) throws IOException {
        if (login() == true) {
            Parent HomeViewParent = FXMLLoader.load(getClass().getResource("customerHome.fxml"));
            Scene HomeScene = new Scene(HomeViewParent);
            // Get Stage Info
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(HomeScene);
            window.show();
        }
    }

    /**
     * Boolean check for entered credentials match with database account
     * @return
     */

    public Boolean login() {
        String customerusername = customerusernameTextField.getText();
        String customerpassword = customerpasswordPasswordField.getText();
        if (customerpassword.isEmpty() || (customerusername.isEmpty())) {
            CustomerLoginStatus.setText("Empty Username/Password");
            return false;
        } else {
            //SQL query
            String Loginquery = "SELECT * FROM Customers WHERE C_Username = ? AND Password = ?";
            try {
                preparedStatement = con.prepareStatement(Loginquery);
                preparedStatement.setString(1, customerusername);
                preparedStatement.setString(2, customerpassword);
                resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    CustomerLoginStatus.setText("Username/Password incorrect");
                    return false;
                } else {
                    return true;
                }

            } catch (SQLException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }

    /**
     * initialize the controller
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (con == null) {
            CustomerLoginStatus.setText("Connection Error");
        }
    }
}
