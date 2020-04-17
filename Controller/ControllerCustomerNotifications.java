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
*Controller for the customer Notification scene.
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

    /**
    *Changes the customer's scene to the my account scene.
    *@param event Clicking on the myaccount button.
    */
    public void linktomyaccountButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent myaccountParent = FXMLLoader.load(getClass().getResource("MyAccount.fxml"));
        Scene myaccountScene = new Scene(myaccountParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(myaccountScene);
        window.show();
    }

    /**
    *Changes the customer's scene to the customer Menu scene.
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
    *Changes the customer's scene to the my orders scene.
    *@param event Clicking on the orders button.
    */
    public void linktomyordersButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent myordersParent = FXMLLoader.load(getClass().getResource("myOrdersHome.fxml"));
        Scene myordersScene = new Scene(myordersParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(myordersScene);
        window.show();
    }

    /**
    *Changes the customer's scene to the customer bookings scene.
    *@param event Clicking on the bookings button.
    */
    public void linktobookinghomeButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent mybookingsParent = FXMLLoader.load(getClass().getResource("bookingHome.fxml"));
        Scene mybookingsScene = new Scene(mybookingsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(mybookingsScene);
        window.show();
    }

    /**
    *Changes the customer's scene to the customer orders page.
    *@param event Clicking on the check orders button.
    */
    public void linktomyordershomeButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent myordersParent = FXMLLoader.load(getClass().getResource("myOrdersHome.fxml"));
        Scene myorderssScene = new Scene(myordersParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(myordersScene);
        window.show();
    }

    /**
    *Changes the customer's scene to the my bookings scene.
    *@param event Clicking on the check bookings button.
    */
    public void linktobookingshometButtonPressed(javafx.event.ActionEvent event) throws IOException {
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
        Parent notificationsParent = FXMLLoader.load(getClass().getResource("Notification.fxml"));
        Scene notificationsScene = new Scene(notificationsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(notificationsScene);
        window.show();
    }

    /**
    *Changes the customer's scene to the customer login scene.
    *@param event Clicking on the logout button.
    */
    public void logoutButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent logoutParent = FXMLLoader.load(getClass().getResource("Customer_login_Scene.fxml"));
        Scene logoutScene = new Scene(logoutParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(logoutScene);
        window.show();
    }
}
