package FoodPlace.Controller;

import java.io.IOException;

/**
 *Controller for the scene a Chef views when they go to add a menu item.
 *@author Haixin Wang
 *@version ?
 */
public class ControllerAddMenuItem {
    public Button linktostaff;
    public Button linktoorders;
    public Button linktomenu;
    public Button linktobookings;
    public Button linktoreports;
    public Button notificationspage;
    public Button logoutbutton;
    public Button linktoeidtmenuitem;

    /**
     *Changes the scene to the permission denied scene.
     *@param event Clicking on the staff button.
     */
    public void linktostaffButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent staffParent = FXMLLoader.load(getClass().getResource("permissiondeniedchef.fxml"));
        Scene staffScene = new Scene(staffParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(staffScene);
        window.show();
    }

    /**
     *Changes the scene to the chef view orders scene.
     *@param event Clicking on the orders button.
     */
    public void linktoordersdriverButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent ordersParent = FXMLLoader.load(getClass().getResource("ordersChef.fxml"));
        Scene ordersScene = new Scene(ordersParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(ordersScene);
        window.show();
    }

    /**
     *Changes the scene to the chef view Menu scene.
     *@param event Clicking on the menu button.
     */
    public void linktomenusceneButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent menuParent = FXMLLoader.load(getClass().getResource("Menu_Scene.fxml"));
        Scene menuScene = new Scene(menuParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuScene);
        window.show();
    }

    /**
     *Changes the scene to the permission denied scene.
     *@param event Clicking on the bookings button.
     */
    public void linktobookinghomeButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent bookingsParent = FXMLLoader.load(getClass().getResource("permissiondeniedchef.fxml"));
        Scene bookingsScene = new Scene(bookingsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(bookingsScene);
        window.show();
    }

    /**
     *Changes the scene to the permission denied scene.
     *@param event Clicking on the reports button.
     */
    public void linktoreportsButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent reportsParent = FXMLLoader.load(getClass().getResource("permissiondeniedchef.fxml"));
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
        Parent notificationsParent = FXMLLoader.load(getClass().getResource("ChefNotifications.fxml"));
        Scene notificationsScene = new Scene(notificationsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(notificationsScene);
        window.show();
    }

    /**
     *Changes the scene to the Staff login scene.
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
     *Changes the scene to the Edit Menu Item scene.
     *@param event Clicking on the confirm button.
     */
    public void linktoeidtmenuitemButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent confirmParent = FXMLLoader.load(getClass().getResource("EditMenuItem_Scene.fxml"));
        Scene confirmScene = new Scene(confirmParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(confirmScene);
        window.show();
    }

    //need to be able to actually add menu items
}
