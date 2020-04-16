package FoodPlace.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

/**
*Controller for the scene the manager views when they log in.
*@author Sara Philipson
*@version ?
*/
public class ControllerManagerHome {

    public Button linktostaff;
    public Button linktoorders;
    public Button linktomenu;
    public Button linktobookings;
    public Button linktoreports;
    public Button notificationspage;
    public Button logoutbutton;

    /**
    *Changes the scene to the Manager Notifications scene.
    *@param event Clicking on the Notifications button.
    */
    public void notificationspageButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent notificationsParent = FXMLLoader.load(getClass().getResource("------.fxml"));
        Scene notificationsScene = new Scene(notificationsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(notificationsScene);
        window.show();
    }

    /**
    *Changes the scene to the staff login scene.
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
    *Changes the scene to the Manager permission denied scene.
    *@param event Clicking on the a button that would lead to a scene that the manager has no access to.
    */
    public void permissiondeniedscreen(javafx.event.ActionEvent event) throws IOException {
        Parent permissiondeniedParent = FXMLLoader.load(getClass().getResource("permissiondeniedmanager.fxml"));
        Scene permissiondeniedScene = new Scene(permissiondeniedParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(permissiondeniedScene);
        window.show();
    }

    /**
    *Changes the scene to the Manager Staff scene.
    *@param event Clicking on the Staff button.
    */
    public void managerstaffpagelink(javafx.event.ActionEvent event) throws IOException{
        Parent managerstaffParent = FXMLLoader.load(getClass().getResource("ManagerStaffScene.fxml"));
        Scene managerstaffScene = new Scene(managerstaffParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(managerstaffScene);
        window.show();
    }

    /**
    *Changes the scene to the Manager reports scene.
    *@param event Clicking on the Reports button.
    */
    public void managereportsscreen(javafx.event.ActionEvent event) throws IOException {
        Parent managerreportParent = FXMLLoader.load(getClass().getResource("Report.fxml"));
        Scene managerreportScene = new Scene(managerreportParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(managerreportScene);
        window.show();
    }
}
