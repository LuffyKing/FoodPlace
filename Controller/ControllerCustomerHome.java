package FoodPlace.Controller;

import FoodPlace.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *Controller for the scene a Customer gets when they log in.
 *@author Haixin Wang
 *@version ?
 */
public class ControllerCustomerHome implements Initializable {
    private Customer customer;
    public Button linktomyaccount;
    public Button linktomenu;
    public Button linktomyorders;
    public Button linktobookinghome;
    public Button notificationspage;
    public Button logoutbutton;
    @FXML
    private Text welcomeText;


    @Override
    public void initialize(URL location, ResourceBundle resources){

    }

    /**
    *Sets the customer to the logged in customer.
    *@param customer The logged in customer.
    */
    public void setCustomer(Customer customer) {
        this.customer = customer;
        welcomeText.setText("Welcome "+customer.getFirstName());;
    }

    public Customer getCustomer() {
        return customer;
    }



    /**
<<<<<<< HEAD
     *Changes the customer's scene to the customer account scene.
     *@param event Clicking on the account button.
=======
     *Changes the scene to the My Account scene.
     *@param event Clicking on the My Account button.
>>>>>>> e27f3093bc39f2391af64b88a0378033a9138805
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
<<<<<<< HEAD
     *Changes the customer's scene to the customer Menu scene.
     *@param event Clicking on the menu button.
=======
     *Changes the scene to the customer Menu scene.
     *@param event Clicking on the Menu button.
>>>>>>> e27f3093bc39f2391af64b88a0378033a9138805
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
<<<<<<< HEAD
     *Changes the customer's scene to the customer own orders.
     *@param event Clicking on the orders button.
=======
     *Changes the scene to the my orders scene.
     *@param event Clicking on the My Orders button.
>>>>>>> e27f3093bc39f2391af64b88a0378033a9138805
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
<<<<<<< HEAD
     *Changes the customer's scene to the customer own bookings.
     *@param event Clicking on the bookings button.
=======
     *Changes the scene to the my bookings scene.
     *@param event Clicking on the My Bookings button.
>>>>>>> e27f3093bc39f2391af64b88a0378033a9138805
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
