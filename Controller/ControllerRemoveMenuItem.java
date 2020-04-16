package FoodPlace;

import java.io.IOException;

public class ControllerRemoveMenuItem {
    public Button linktostaff;
    public Button linktoorders;
    public Button linktomenu;
    public Button linktobookings;
    public Button linktoreports;
    public Button notificationspage;
    public Button logoutbutton;
    public Button linktoeidtmenuitem;

    public void linktostaffButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent staffParent = FXMLLoader.load(getClass().getResource("staffBookingHome.fxml"));
        Scene staffScene = new Scene(staffParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(staffScene);
        window.show();
    }

    public void linktoordersdriverButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent ordersParent = FXMLLoader.load(getClass().getResource("ordersDriver.fxml"));
        Scene ordersScene = new Scene(ordersParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(ordersScene);
        window.show();
    }

    public void linktomenusceneButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent menuParent = FXMLLoader.load(getClass().getResource("Menu_Scene.fxml"));
        Scene menuScene = new Scene(menuParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuScene);
        window.show();
    }

    public void linktobookinghomeButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent bookingsParent = FXMLLoader.load(getClass().getResource("staffBookingHome.fxml"));
        Scene bookingsScene = new Scene(bookingsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(bookingsScene);
        window.show();
    }

    public void linktoreportsButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent reportsParent = FXMLLoader.load(getClass().getResource("Report.fxml"));
        Scene reportsScene = new Scene(reportsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(reportsScene);
        window.show();
    }

    public void notificationspageButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent notificationsParent = FXMLLoader.load(getClass().getResource("Notification.fxml"));
        Scene notificationsScene = new Scene(notificationsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(notificationsScene);
        window.show();
    }

    public void logoutbuttonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent logoutParent = FXMLLoader.load(getClass().getResource("Staff_login_Draft.fxml"));
        Scene logoutScene = new Scene(logoutParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(logoutScene);
        window.show();
    }

    public void linktoeditmenuitemButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent removeParent = FXMLLoader.load(getClass().getResource("basket.fxml"));
        Scene removeScene = new Scene(removeParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(removeScene);
        window.show();
    }

}
