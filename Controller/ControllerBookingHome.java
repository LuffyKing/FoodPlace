package FoodPlace.Controller;

import FoodPlace.Customer;
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
*Controller for the scene the customer views when they click on the My Bookings button.
*@author Sara Philipson
*@version ?
*/
public class ControllerBookingHome implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources){

    }

    public Button linktomyaccount;
    public Button linktomenu;
    public Button linktomyorders;
    public Button linktobookinghome;
    public Button notificationspage;
    public Button logoutbutton;
    public Button linktobookingcreate;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
    *Changes the scene the customer can see to the scene where they can create a booking.
    *@param event Clicking on the Create Booking button.
    */
    public void linktobookingcreateButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent bookingCreateParent = FXMLLoader.load(getClass().getResource("bookingCreate.fxml"));
        Scene bookingCreateScene = new Scene(bookingCreateParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(bookingCreateScene);
        window.show();
    }

    /**
    *Changes the scene the customer can see to the My Account scene.
    *@param event Clicking on the My Account button.
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
    *Changes the scene the customer can see to the Menu scene.
    *@param event Clicking on the Menu button.
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
    *Changes the scene the customer can see to the My Orders scene.
    *@param event Clicking on the My Orders button.
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
    *Changes the scene the customer can see to the My Bookings scene.
    *@param event Clicking on the My Bookings button.
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
    *Changes the scene the customer can see to the Notifications scene.
    *@param event Clicking on the Notifications button.
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
    *Changes the scene the customer can see to the Customer Login scene.
    *@param event Clicking on the Logout button.
    */
    public void logoutbuttonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent logoutParent = FXMLLoader.load(getClass().getResource("../FXML/Customer_login_Scene.fxml"));
        Scene logoutScene = new Scene(logoutParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(logoutScene);
        window.show();
    }

    //method to display bookings missing.

}
