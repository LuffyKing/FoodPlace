package FoodPlace.Controller;

import FoodPlace.Controller.ControllerCustomerHome;
import FoodPlace.Customer;
import FoodPlace.FoodDB.CustomerDB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Controller class for Customer Login scene
 */
public class CustomerLoginController {
    @FXML private TextField customerUsernameTextField;
    @FXML private PasswordField customerPasswordField;
    private String customerUsername;
    private String customerPassword;
    @FXML
    Label CustomerLoginStatus;
    /**
     * Method for changing the Scene to StaffLogin
     */
    public void StaffLoginbuttonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent StaffViewParent = FXMLLoader.load(getClass().getResource("../FXML/Staff_login_Draft.fxml"));
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
        Parent CustomerViewParent = FXMLLoader.load(getClass().getResource("../FXML/Customer_signup_Scene.fxml"));
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

    public void LoginButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Customer customer = login();
        if (customer != null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/customerHome.fxml"));
            Parent CustomerViewParent = loader.load();
            ControllerCustomerHome controllerCustomerHome = loader.getController();
            controllerCustomerHome.setCustomer(customer);
            loader.setController(controllerCustomerHome);
            Scene CustomerHomeScene = new Scene(CustomerViewParent);
            // Get Stage Info
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(CustomerHomeScene);
            window.show();
        }
    }

    /**
     * Method for customer username & password login
     */
    public Customer login() {
        Customer customer = null;
        customerUsername = customerUsernameTextField.getText();
        customerPassword = customerPasswordField.getText();
        if (customerUsername.isEmpty() || (customerPassword.isEmpty())) {
            CustomerLoginStatus.setText("Invalid Username/Password");
        }
        else{
            //SQL query
            try {
                CustomerDB cdb = new CustomerDB();
                customer = cdb.getCustomer(customerUsername, customerPassword);
                if (customer == null){
                    CustomerLoginStatus.setText("User not found");
                }
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
        return customer;

    }
}