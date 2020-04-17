package FoodPlace.Controller;


import FoodPlace.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

/**
*Controller for the scene that the customer see the Notifications.
*@author Chunlei Liu
*@version ?
*/

public class ControllerCustomerNotifications {
    public Button linktomyaccount;
    public Button linktomenu;
    public Button linktomyorders;
    public Button linktobookinghome;
    public Button linktomyordersupdated;
    public Button linktobookingedit;
    public Button notificationspage;
    public Button logoutbutton;
    private Customer customer;
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
    *Changes the customer's scene to the customer new orders.
    *@param event Clicking on the check orders button.
    */
    public void linktomyordersupdatedButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent myordersParent = FXMLLoader.load(getClass().getResource("myOredersUpdated.fxml"));
        Scene myordersScene = new Scene(myordersParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(myordersScene);
        window.show();
    }

    /**
    *Changes the customer's scene to the customer booking edit.
    *@param event Clicking on the check booking button.
    */
    public void linktobookingeditButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent mybookingsParent = FXMLLoader.load(getClass().getResource("bookingEdit.fxml"));
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

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}