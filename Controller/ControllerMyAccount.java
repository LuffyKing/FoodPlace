package FoodPlace.Controller;


import FoodPlace.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
*Controller for the scene that the customer see their account details.
*@author Chunlei Liu
*@version ?
*/

public class ControllerMyAccount implements Initializable {
    public Button linktomyaccount;
    public Button linktomenu;
    public Button linktomyorders;
    public Button linktobookinghome;
    public Button linktoedit;
    public Button linktochangepassword;
    public Button notificationspage;
    public Button logoutbutton;
    private Customer customer;

    @FXML
    private Label address;

    @FXML
    private Label firstName;

    @FXML
    private Label lastName;

    @FXML
    private Label username;

    @Override
    public void initialize(URL location, ResourceBundle resources){

    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        setFirstName(customer.getFirstName());
        setLastName(customer.getLastName());
        setUsername(customer.getUsername());
        setAddress(customer.getAddress());
    }

    public Customer getCustomer() {
        return customer;
    }


    public void setUsername(String uname) {
        this.username.setText("Username: "+uname);
    }

    public void setAddress(String address) {
        this.address.setText("Address: " + address);
    }

    public void setFirstName(String firstName){
        this.firstName.setText("First name: " + firstName);
    }

    public void setLastName(String lastName){
        this.lastName.setText("Last name: " + lastName);
    }

    /**
     *Changes the customer's scene to the customer account scene.
     *@param event Clicking on the account button.
     */
    public void linktomyaccountButtonPressed(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/MyAccount.fxml"));
        Parent CustomerViewParent = loader.load();
        ControllerMyAccount controllerMyAccount = loader.getController();
        controllerMyAccount.setCustomer(customer);
        Scene myAccountScene = new Scene(CustomerViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(myAccountScene);
        window.show();
    }

    /**
    *Changes the customer's scene to the customer Menu scene.
    *@param event Clicking on the menu button.
    */
    public void linktomenuButtonPressed(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/customerMenu.fxml"));
        Parent menuParent = loader.load();
        ControllerCustomerMenu controllerCustomerMenu = loader.getController();
        controllerCustomerMenu.setCustomer(customer);
        Scene menuScene = new Scene(menuParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuScene);
        window.show();
    }

    /**
    *Changes the customer's scene to the customer own orders.
    *@param event Clicking on the orders button.
    */
    public void linktomyordersButtonPressed(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/myOrdersHome.fxml"));
        ControllerMyOrdersHome controllerMyOrdersHome = loader.getController();
        controllerMyOrdersHome.setCustomer(customer);
        Parent myordersParent = loader.load();
        Scene myordersScene = new Scene(myordersParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(myordersScene);
        window.show();
    }

    /**
    *Changes the customer's scene to the customer own bookings.
    *@param event Clicking on the bookings button.
    */
    public void linktobookinghomeButtonPressed(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/bookingHome.fxml"));
        ControllerBookingHome controllerBookingHome = loader.getController();
        controllerBookingHome.setCustomer(customer);
        Parent mybookingsParent = loader.load();
        Scene mybookingsScene = new Scene(mybookingsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(mybookingsScene);
        window.show();
    }

    /**
    *Changes the customer's scene to the customer notifications scene.
    *@param event Clicking on the notifications button.
    */
    public void notificationspageButtonPressed(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/CustomerNotification.fxml"));
        ControllerCustomerNotifications controllerCustomerNotifications = loader.getController();
        controllerCustomerNotifications.setCustomer(customer);
        Parent notificationsParent = loader.load();
        Scene notificationsScene = new Scene(notificationsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(notificationsScene);
        window.show();
    }

    /**
    *Changes the customer's scene to the customer logout scene.
    *@param event Clicking on the logout button.
    */
    public void logoutButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent logoutParent = FXMLLoader.load(getClass().getResource("../FXML/Customer_login_Scene.fxml"));
        Scene logoutScene = new Scene(logoutParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(logoutScene);
        window.show();
    }
}