package FoodPlace.Controller;

import FoodPlace.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *Controller for the scene a Delivery Driver gets when they log in.
 *@author Haixin Wang
 *@version ?
 */

public class ControllerCustomerMenu implements Initializable {
    @FXML
    private Button linktomyaccount;
    @FXML
    private Button linktomenu;
    @FXML
    private Button linktomyorders;
    @FXML
    private Button linktobookinghome;
    @FXML
    private Button notificationspage;
    @FXML
    private Button logoutbutton;
    private Button add;

    private Customer customer;

    @Override
    public void initialize(URL location, ResourceBundle resources){

    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
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

    /**
     *Changes the scene to the Basket scene.
     *@param event Clicking on the Add button.
     */
    public void linktobasketButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent addParent = FXMLLoader.load(getClass().getResource("basket.fxml"));
        Scene addScene = new Scene(addParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(addScene);
        window.show();
    }
  //method to actually display menu data missing
}
