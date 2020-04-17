package FoodPlace.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

/**
*Controller for the homepage a Chef sees upon login.
*@author Sara Philipson
*@version ?
*/
public class ControllerChefHome {
    public Button linktostaff;
    public Button linktoorders;
    public Button linktomenu;
    public Button linktobookings;
    public Button linktoreports;
    public Button notificationspage;
    public Button logoutbutton;

    /**
    *Changes the scene to the Chef Notifications scene.
    *@param event Clicking on the Notifications button.
    */
    public void notificationspageButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent notificationsParent = FXMLLoader.load(getClass().getResource("../FXML/ChefNotifications.fxml"));
        Scene notificationsScene = new Scene(notificationsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(notificationsScene);
        window.show();
    }

    /**
    *Changes the scene to the Staff Login scene.
    *@param event Clicking on the Logout button.
    */
    public void logoutbuttonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent logoutParent = FXMLLoader.load(getClass().getResource("../FXML/Staff_login_Draft.fxml"));
        Scene logoutScene = new Scene(logoutParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(logoutScene);
        window.show();
    }
    
    /**
    *Changes the scene to the Chef permission denied scene.
    *@param event Clicking on any button that would lead to a scene that the chef has no access to.
    */
    public void permissiondeniedscreen(javafx.event.ActionEvent event) throws IOException {
        Parent permissiondeniedParent = FXMLLoader.load(getClass().getResource("../FXML/permissiondeniedchef.fxml"));
        Scene permissiondeniedScene = new Scene(permissiondeniedParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(permissiondeniedScene);
        window.show();
    }

    /**
    *Changes the scene to the Chef Menu scene.
    *@param event Clicking on the Menu button.
    */
    public void linktomenuchefview(javafx.event.ActionEvent event) throws IOException {
        Parent menuchefParent = FXMLLoader.load(getClass().getResource("../FXML/Menu_Scene.fxml"));
        Scene menuchefScene = new Scene(menuchefParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuchefScene);
        window.show();
    }

    /**
    *Changes the scene to the Chef Orders scene.
    *@param event Clicking on the Orders button.
    */
    public void linktoorderschefview(javafx.event.ActionEvent event) throws IOException {
        Parent ordershomeParent = FXMLLoader.load(getClass().getResource("../FXML/ChefOrderHomepage.fxml"));
        Scene ordershomeScene = new Scene(ordershomeParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(ordershomeScene);
        window.show();
    }
}
