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
*Controller for the driver Notifications scene.
*@author Chunlei Liu
*@version ?
*/
public class ControllerDriverNotifications {
    public Button linktostaff;
    public Button linktoorders;
    public Button linktomenu;
    public Button linktobookings;
    public Button linktoreports;
    public Button linktocheckdelivery;
    public Button notificationspage;
    public Button logoutbutton;
    public button linktodelivery;

    /**
    *Changes the driver's scene to the driver permission denied scene.
    *@param event Clicking on a button that would lead to a scene that is not accessable for the driver.
    */
    public void linktostaffButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent permissiondeniedParent = FXMLLoader.load(getClass().getResource("permissiondenieddriver.fxml"));
        Scene permissiondeniedScene = new Scene(permissiondeniedParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(permissiondeniedScene);
        window.show();
    }

    /**
    *Changes the driver's scene to the delivery orders.
    *@param event Clicking on the orders button.
    */
    public void linktoordersButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent myordersParent = FXMLLoader.load(getClass().getResource("ordersDriver.fxml"));
        Scene myordersScene = new Scene(myordersParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(myordersScene);
        window.show();
    }

    /**
    *Changes the driver's scene to the driver permission denied scene.
    *@param event Clicking on a button that would lead to a scene that is not accessable for the driver.
    */
    public void linktomenuButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent permissiondeniedParent = FXMLLoader.load(getClass().getResource("permissiondenieddriver.fxml"));
        Scene permissiondeniedScene = new Scene(permissiondeniedParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(permissiondeniedScene);
        window.show();
    }

    /**
    *Changes the driver's scene to the driver permission denied scene.
    *@param event Clicking on a button that would lead to a scene that is not accessable for the driver.
    */
    public void linktobookingsButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent permissiondeniedParent = FXMLLoader.load(getClass().getResource("permissiondenieddriver.fxml"));
        Scene permissiondeniedScene = new Scene(permissiondeniedParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(permissiondeniedScene);
        window.show();
    }

    /**
    *Changes the driver's scene to the chef permission denied scene.
    *@param event Clicking on a button that would lead to a scene that is not accessable for the driver.
    */
    public void linktoreportsButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent permissiondeniedParent = FXMLLoader.load(getClass().getResource("permissiondenieddriver.fxml"));
        Scene permissiondeniedScene = new Scene(permissiondeniedParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(permissiondeniedScene);
        window.show();
    }

    /**
    *Changes the driver's scene to the driver notifications scene.
    *@param event Clicking on the notifications button.
    */
    public void notificationspageButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent notificationsParent = FXMLLoader.load(getClass().getResource("DriverNotification.fxml"));
        Scene notificationsScene = new Scene(notificationsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(notificationsScene);
        window.show();
    }

    /**
    *Changes the driver's scene to the staff login scene.
    *@param event Clicking on the logout button.
    */
    public void logoutButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent logoutParent = FXMLLoader.load(getClass().getResource("Staff_login_Draft.fxml"));
        Scene logoutScene = new Scene(logoutParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(logoutScene);
        window.show();
    }
    
    /**
    *Changes the driver's scene to the delivery orders.
    *@param event Clicking on the check delivery button.
    */
    public void deliveryview(javafx.event.ActionEvent event) throws IOException {
        Parent myordersParent = FXMLLoader.load(getClass().getResource("ordersDriver.fxml"));
        Scene myordersScene = new Scene(myordersParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(myordersScene);
        window.show();
    }

}
