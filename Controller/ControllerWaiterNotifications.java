package FoodPlace.Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

/**
*Controller for the scene that the waiter see the notifications.
*@author Chunlei Liu
*@version ?
*/

public class ControllerWaiterNotifications {
    public Button linktostaff;
    public Button linktoorders;
    public Button linktomenu;
    public Button linktobookings;
    public Button linktoreports;
    public Button linktoapprove;
    public Button linktoorderstatus;
    public Button notificationspage;
    public Button logoutbutton;

    /**
    *Changes the waiter's scene to the waiter permission denied scene.
    *@param event Clicking on a button that would lead to a scene that is not accessable for the waiter.
    */
    public void linktostaffButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent permissiondeniedParent = FXMLLoader.load(getClass().getResource("permissiondeniedwaiter.fxml"));
        Scene permissiondeniedScene = new Scene(permissiondeniedParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(permissiondeniedScene);
        window.show();
    }

    /**
    *Changes the waiter's scene to the customer orders.
    *@param event Clicking on the orders button.
    */
    public void linktoordersButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent myordersParent = FXMLLoader.load(getClass().getResource("myOrdersHome.fxml"));
        Scene myordersScene = new Scene(myordersParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(myordersScene);
        window.show();
    }

    /**
    *Changes the waiter's scene to the customer menu.
    *@param event Clicking on the menu button.
    */
    public void linktomenuButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent menuParent = FXMLLoader.load(getClass().getResource("customerMenu.fxml"));
        Scene menuScene = new Scene(menuParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuScene);
        window.show();
    }

    /**
    *Changes the waiter's scene to the customer bookings.
    *@param event Clicking on the booking button.
    */
    public void linktobookingsButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent bookingParent = FXMLLoader.load(getClass().getResource("bookingSubmitted.fxml"));
        Scene bookingScene = new Scene(bookingParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(bookingScene);
        window.show();
    }

    /**
    *Changes the waiter's scene to the waiter permission denied scene.
    *@param event Clicking on a button that would lead to a scene that is not accessable for the waiter.
    */
    public void linktoreportsButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent permissiondeniedParent = FXMLLoader.load(getClass().getResource("permissiondeniedwaiter.fxml"));
        Scene permissiondeniedScene = new Scene(permissiondeniedParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(permissiondeniedScene);
        window.show();
    }

    /**
    *Changes the waiter's scene to the waiter notifications scene.
    *@param event Clicking on the notifications button.
    */
    public void notificationspageButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent notificationsParent = FXMLLoader.load(getClass().getResource("WaiterNotification.fxml"));
        Scene notificationsScene = new Scene(notificationsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(notificationsScene);
        window.show();
    }

    /**
    *Changes the waiter's scene to the waiter logout scene.
    *@param event Clicking on the logout button.
    */
    public void logoutButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent logoutParent = FXMLLoader.load(getClass().getResource("Staff_login_Draft.fxml"));
        Scene logoutScene = new Scene(logoutParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(logoutScene);
        window.show();
    }

}
