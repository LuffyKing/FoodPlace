package FoodPlace.Controller;

import java.io.IOException;

/**
 *Controller for the scene a Delivery Driver gets when they log in.
 *@author Haixin Wang
 *@version ?
 */

public class ControllerOrdersDriver {
    public Button linktostaff;
    public Button linktoorders;
    public Button linktomenu;
    public Button linktobookings;
    public Button linktoreports;
    public Button notificationspage;
    public Button logoutbutton;
    public Button linktoordereditdriver;

    /**
     *Changes the scene to the permissiondenied scene.
     *@param event Clicking on the staff button.
     */
    public void linktostaffButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent staffParent = FXMLLoader.load(getClass().getResource("permissiondenieddriver.fxml"));
        Scene staffScene = new Scene(staffParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(staffScene);
        window.show();
    }

    /**
     *Changes the scene to the ordersChef scene.
     *@param event Clicking on the orders button.
     */
    public void linktoordersdriverButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent ordersParent = FXMLLoader.load(getClass().getResource("ordersDriver.fxml"));
        Scene ordersScene = new Scene(ordersParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(ordersScene);
        window.show();
    }

    /**
     *Changes the scene to the Menu_Scene scene.
     *@param event Clicking on the menu button.
     */
    public void linktomenusceneButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent menuParent = FXMLLoader.load(getClass().getResource("permissiondenieddriver.fxml"));
        Scene menuScene = new Scene(menuParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuScene);
        window.show();
    }

    /**
     *Changes the scene to the permissiondeniedchef scene.
     *@param event Clicking on the bookings button.
     */
    public void linktobookinghomeButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent bookingsParent = FXMLLoader.load(getClass().getResource("permissiondenieddriver.fxml"));
        Scene bookingsScene = new Scene(bookingsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(bookingsScene);
        window.show();
    }

    /**
     *Changes the scene to the permissiondeniedchef scene.
     *@param event Clicking on the reports button.
     */
    public void linktoreportsButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent reportsParent = FXMLLoader.load(getClass().getResource("permissiondenieddriver.fxml"));
        Scene reportsScene = new Scene(reportsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(reportsScene);
        window.show();
    }

    /**
     *Changes the scene to the Chef Notifications scene.
     *@param event Clicking on the Notifications button.
     */
    public void notificationspageButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent notificationsParent = FXMLLoader.load(getClass().getResource("DriverNotifications.fxml"));
        Scene notificationsScene = new Scene(notificationsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(notificationsScene);
        window.show();
    }

    /**
     *Changes the scene to the Staff login Draft scene.
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
     *Changes the scene to the orderEditDrivere scene.
     *@param event Clicking on the Edit Order button.
     */
    public void linktoordereditdriverButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent editParent = FXMLLoader.load(getClass().getResource("orderEditDriver.fxml"));
        Scene editScene = new Scene(editParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(editScene);
        window.show();
    }
//order display method missing
    //way to select individual orders to edit missing.
}
