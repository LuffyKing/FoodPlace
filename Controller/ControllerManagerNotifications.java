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
*Controller for the scene that the Manager see the Notifications.
*@author Chunlei Liu
*@version ?
*/

public class ControllerManagerNotifications {
    public Button linktostaff;
    public Button linktoorders;
    public Button linktomenu;
    public Button linktobookings;
    public Button linktoreports;
    public Button linktocheckevent;
    public Button linktostaffrequirements;
    public Button notificationspage;
    public Button logoutbutton;

    /**
    *Changes the Manager's scene to the Manager staff scene.
    *@param event Clicking on the staff button.
    */
    public void linktostaffButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent staffParent = FXMLLoader.load(getClass().getResource("staff.fxml"));
        Scene staffScene = new Scene(staffParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(staffScene);
        window.show();
    }

    /**
    *Changes the manager's scene to the manager permission denied scene.
    *@param event Clicking on a button that would lead to a scene that is not accessable for the manager.
    */
    public void linktoordersButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent permissiondeniedParent = FXMLLoader.load(getClass().getResource("permissiondeniedmanager.fxml"));
        Scene permissiondeniedScene = new Scene(permissiondeniedParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(permissiondeniedScene);
        window.show();
    }

    /**
    *Changes the Manager's scene to the Manager menu scene.
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
    *Changes the Manager's scene to the Manager bookingSubmitted scene.
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
    *Changes the Manager's scene to the Manager report scene.
    *@param event Clicking on the report button.
    */
    public void linktoreportsButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent reportParent = FXMLLoader.load(getClass().getResource("report.fxml"));
        Scene reportScene = new Scene(reportParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(reportScene);
        window.show();
    }

    /**
    *Changes the manager's scene to the manager notifications scene.
    *@param event Clicking on the notifications button.
    */
    public void notificationspageButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent notificationsParent = FXMLLoader.load(getClass().getResource("ManagerNotification.fxml"));
        Scene notificationsScene = new Scene(notificationsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(notificationsScene);
        window.show();
    }

    /**
    *Changes the manager's scene to the manager logout scene.
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
