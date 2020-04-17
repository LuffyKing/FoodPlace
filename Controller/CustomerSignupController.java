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
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerSignupController {
    @FXML
    private TextField unameField;
    @FXML
    private TextField fnameField;
    @FXML
    private TextField lnameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label signupStatusField;


    /**
     * Method for changing the Scene to CustomerLogin
     * @param event
     */
    public void CustomerLoginbuttonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent CustomerViewParent = FXMLLoader.load(getClass().getResource("../FXML/Customer_login_Scene.fxml"));
        Scene CustomerLoginScene = new Scene(CustomerViewParent);
        // Get Stage Info
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(CustomerLoginScene);
        window.show();
    }

    /**
     * Method for signing up a user
     * @param event
     */
    public void SignUpButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Customer customer = signUp();
        if(customer != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/customerHome.fxml"));
            Parent CustomerViewParent = loader.load();
            ControllerCustomerHome controllerCustomerHome = loader.getController();
            controllerCustomerHome.setCustomer(customer);
            loader.setController(controllerCustomerHome);
            Scene CustomerHomeScene = new Scene(CustomerViewParent);
            // Get Stage Info
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            CustomerHomeScene.setUserData(customer);
            window.setScene(CustomerHomeScene);
            window.show();
        }
    }

    public Customer signUp() {
        Customer customer = null;

        String username = unameField.getText();
        String fname = fnameField.getText();
        String lname = lnameField.getText();
        String address = addressField.getText();
        String pword = passwordField.getText();
        if (username.isEmpty() || address.isEmpty()
                || fname.isEmpty() || lname.isEmpty() ||
                pword.isEmpty()
        ) {
            signupStatusField.setText("Invalid Signup details");
        } else {
            //SQL query
            try {
                CustomerDB cdb = new CustomerDB();
                customer = cdb.createCustomer(fname, lname, address, username, pword);
                if (customer == null) {
                    signupStatusField.setText("User creation failed");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return customer;
    }
}
