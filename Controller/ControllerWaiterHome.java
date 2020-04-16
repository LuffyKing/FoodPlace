package FoodPlace.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

/**
*Controller for the scene the waiter sees when they log in.
*@author Sara Philipson
*@version ?
*/
public class ControllerWaiterHome {

    public Button linktostaff;
    public Button linktoorders;
    public Button linktomenu;
    public Button linktobookings;
    public Button linktoreports;
    public Button notificationspage;
    public Button logoutbutton;

    /**
    *Changes the waiter's scene to the waiter notifications scene.
    *@param event Clicking on the Notifications button.
    */
    public void notificationspageButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent notificationsParent = FXMLLoader.load(getClass().getResource("WaiterNotifications.fxml"));
        Scene notificationsScene = new Scene(notificationsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(notificationsScene);
        window.show();
    }

    /**
    *Changes the waiter's scene to the staff login scene.
    *@param event Clicking on the Logout button.
    */
    public void logoutbuttonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent logoutParent = FXMLLoader.load(getClass().getResource("Staff_login_Draft.fxml"));
        Scene logoutScene = new Scene(logoutParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(logoutScene);
        window.show();
    }

    /**
    *Changes the waiter's scene to the waiter permission denied scene.
    *@param event Clicking on a button that would lead to a scene that the waiter doesn't have access to.
    */
    public void permissiondeniedscreen(javafx.event.ActionEvent event) throws IOException {
        Parent permissiondeniedParent = FXMLLoader.load(getClass().getResource("permissiondeniedwaiter.fxml"));
        Scene permissiondeniedScene = new Scene(permissiondeniedParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(permissiondeniedScene);
        window.show();
    }

    /**
    *Changes the waiter's scene to the waiter orders scene.
    *@param event Clicking on the Orders button.
    */
    public void ordershomewaiterview(javafx.event.ActionEvent event) throws IOException {
        Parent ordershomewaiterParent = FXMLLoader.load(getClass().getResource("waiterOrderHomepage.fxml"));
        Scene ordershomewaiterScene = new Scene(ordershomewaiterParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(ordershomewaiterScene);
        window.show();
    }

    /**
    *Changes the waiter's scene to the waiter menu scene.
    *@param event Clicking on the Menu button.
    */
    public void menuhomewaiter(javafx.event.ActionEvent event) throws IOException {
        Parent menuhomewaiterParent = FXMLLoader.load(getClass().getResource("menuWaiter.fxml"));
        Scene menuhomewaiterScene = new Scene(menuhomewaiterParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuhomewaiterScene);
        window.show();
    }

    /**
    *Changes the waiter's scene to the waiter bookings scene.
    *@param event Clicking on the Bookings button.
    */
    public void bookinghomewaiterlink(javafx.event.ActionEvent event) throws IOException {
        Parent bookinghomewaiterParent = FXMLLoader.load(getClass().getResource("staffBookingHome.fxml"));
        Scene bookinghomewaiterScene = new Scene(bookinghomewaiterParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(bookinghomewaiterScene);
        window.show();
    }

}
