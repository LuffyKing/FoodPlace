package FoodPlace.Controller;

import java.io.IOException;

/**
 *Controller for the scene Customers view of the order basket.
 *@author Haixin Wang
 *@version ?
 */
public class ControllerBasket {
    public Button linktomyaccount;
    public Button linktomenu;
    public Button linktomyorders;
    public Button linktobookinghome;
    public Button notificationspage;
    public Button logoutbutton;
    public Button confirmorderedit;

    /**
     *Changes the scene to the My Account scene.
     *@param event Clicking on the My Account button.
     */
    public void linktomyaccountButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent myaccountParent = FXMLLoader.load(getClass().getResource("MyAccount.fxml"));
        Scene myaccountScene = new Scene(myaccountParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(myaccountScene);
        window.show();
    }

    /**
     *Changes the scene to the customer view Menu scene.
     *@param event Clicking on the Menu button.
     */
    public void linktomenuButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent menuParent = FXMLLoader.load(getClass().getResource("customerMenu.fxml"));
        Scene menuScene = new Scene(menuParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuScene);
        window.show();
    }

    /**
     *Changes the scene to the my Orders home scene.
     *@param event Clicking on the My Orders button.
     */
    public void linktomyordersButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent myordersParent = FXMLLoader.load(getClass().getResource("myOrdersHome.fxml"));
        Scene myordersScene = new Scene(myordersParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(myordersScene);
        window.show();
    }

    /**
     *Changes the scene to the booking home scene.
     *@param event Clicking on the My Bookings button.
     */
    public void linktobookinghomeButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent mybookingsParent = FXMLLoader.load(getClass().getResource("bookingHome.fxml"));
        Scene mybookingsScene = new Scene(mybookingsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(mybookingsScene);
        window.show();
    }

    /**
     *Changes the scene to the Notification scene.
     *@param event Clicking on the Notifications button.
     */
    public void notificationspageButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent notificationsParent = FXMLLoader.load(getClass().getResource("Notification.fxml"));
        Scene notificationsScene = new Scene(notificationsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(notificationsScene);
        window.show();
    }

    /**
     *Changes the scene to the Customer login scene.
     *@param event Clicking on the Logout button.
     */
    public void logoutbuttonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent logoutParent = FXMLLoader.load(getClass().getResource("Customer_login_Scene.fxml"));
        Scene logoutScene = new Scene(logoutParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(logoutScene);
        window.show();
    }

    /**
     *Changes the scene to the scene where a customer can edit their order.
     *@param event Clicking on the Add to my orders button.
     */
    public void linktomyorderseditButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent addtomyordersParent = FXMLLoader.load(getClass().getResource("myOrdersEdit.fxml"));
        Scene addtomyordersScene = new Scene(addtomyordersParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(addtomyordersScene);
        window.show();
    }

    //display of items in basket missing.
    
}
