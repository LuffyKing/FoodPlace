package FoodPlace.Controller;

import java.io.IOException;

public class ControllerCustomerHome {
    public Button linktostaff;
    public Button linktoorders;
    public Button linktomenu;
    public Button linktobookings;
    public Button linktoreports;
    public Button linktocheckevent;
    public Button linktostaffrequirements;
    public Button notificationspage;
    public Button logoutbutton;

    public void linktostaffButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent staffParent = FXMLLoader.load(getClass().getResource("staff.fxml"));
        Scene staffScene = new Scene(staffParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(staffScene);
        window.show();
    }

    public void linktoordersButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent permissiondeniedParent = FXMLLoader.load(getClass().getResource("permissiondeniedmanager.fxml"));
        Scene permissiondeniedScene = new Scene(permissiondeniedParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(permissiondeniedScene);
        window.show();
    }

    public void linktomenuButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent menuParent = FXMLLoader.load(getClass().getResource("customerMenu.fxml"));
        Scene menuScene = new Scene(menuParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuScene);
        window.show();
    }

    public void linktobookingsButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent bookingParent = FXMLLoader.load(getClass().getResource("bookingSubmitted.fxml"));
        Scene bookingScene = new Scene(bookingParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(bookingScene);
        window.show();
    }

    public void linktoreportsButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent reportParent = FXMLLoader.load(getClass().getResource("report.fxml"));
        Scene reportScene = new Scene(reportParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(reportScene);
        window.show();
    }

    public void notificationspageButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent notificationsParent = FXMLLoader.load(getClass().getResource("Notification.fxml"));
        Scene notificationsScene = new Scene(notificationsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(notificationsScene);
        window.show();
    }

    public void logoutButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent logoutParent = FXMLLoader.load(getClass().getResource("Customer_login_Scene.fxml"));
        Scene logoutScene = new Scene(logoutParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(logoutScene);
        window.show();
    }

}
