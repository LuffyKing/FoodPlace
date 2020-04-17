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
*Controller class for the Waiter Update Order page.
*@author Chunlei Liu (JavaDoc by Sara Philipson)
*@version ?
*/

public class ControllerWaiterUpdateOrder {
    public Button linktostaff;
    public Button linktoorders;
    public Button linktomenu;
    public Button linktobookings;
    public Button linktoreports;
    public Button linktobasket;
    public Button linktoreceipt;
    public Button notificationspage;
    public Button logoutbutton;

    /**
    *Changes scene to permission denied scene as waiter doesn't have access to the Staff page.
    *@param even Click on Staff button.
    */
    public void linktostaffButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent permissiondeniedParent = FXMLLoader.load(getClass().getResource("permissiondeniedwaiter.fxml"));
        Scene permissiondeniedScene = new Scene(permissiondeniedParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(permissiondeniedScene);
        window.show();
    }

    /**
    *Changes scene to Waiter Orders homepage.
    *@param event Click on Order button.
    */
    public void linktoordersButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent permissiondeniedParent = FXMLLoader.load(getClass().getResource("permissiondeniedwaiter.fxml"));
        Scene permissiondeniedScene = new Scene(permissiondeniedParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(permissiondeniedScene);
        window.show();
    }

    /**
    *Changes scene to the waiter view of the menu.
    *@param event Click on Menu button.
    */
    public void linktomenuButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent menuParent = FXMLLoader.load(getClass().getResource("customerMenu.fxml"));
        Scene menuScene = new Scene(menuParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuScene);
        window.show();
    }

    /**
    *Changes scene to the staff bookings page.
    *@param event Click on Bookings button.
    */
    public void linktobookingsButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent bookingParent = FXMLLoader.load(getClass().getResource("bookingSubmitted.fxml"));
        Scene bookingScene = new Scene(bookingParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(bookingScene);
        window.show();
    }

    /**
    *Changes scene to permission denied scene as waiter doesn't have access to the Reports scene.
    *@param event Click on Reports button.
    */
    public void linktoreportsButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent permissiondeniedParent = FXMLLoader.load(getClass().getResource("permissiondeniedwaiter.fxml"));
        Scene permissiondeniedScene = new Scene(permissiondeniedParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(permissiondeniedScene);
        window.show();
    }

    /**
    *Changes scene to the basket page
    *@param event Click on Add or remove item button.
    */
    public void linktobasketButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent basketParent = FXMLLoader.load(getClass().getResource("basket.fxml"));
        Scene basketScene = new Scene(basketParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(basketScene);
        window.show();
    }

    /**
    *Changes scene to notification scene.
    *@param event Click on Notifications button.
    */
    public void notificationspageButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent notificationsParent = FXMLLoader.load(getClass().getResource("WaiterNotification.fxml"));
        Scene notificationsScene = new Scene(notificationsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(notificationsScene);
        window.show();
    }

    /**
    *Changes scene to the Staff Login page.
    *@param event Clock on Logout button.
    */
    public void logoutButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent logoutParent = FXMLLoader.load(getClass().getResource("Staff_login_Draft.fxml"));
        Scene logoutScene = new Scene(logoutParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(logoutScene);
        window.show();
    }
}
