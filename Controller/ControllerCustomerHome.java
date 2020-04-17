package FoodPlace.Controller;

import FoodPlace.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCustomerHome implements Initializable {
    private Customer customer;
    public Button linktomyaccount;
    public Button linktomenu;
    public Button linktomyorders;
    public Button linktobookinghome;
    public Button notificationspage;
    public Button logoutbutton;
    @FXML
    private Text welcomeText;


    @Override
    public void initialize(URL location, ResourceBundle resources){

    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        welcomeText.setText("Welcome "+customer.getFirstName());;
    }

    public Customer getCustomer() {
        return customer;
    }



    public void linktomyaccountButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent myaccountParent = FXMLLoader.load(getClass().getResource("../FXML/MyAccount.fxml"));
        Scene myaccountScene = new Scene(myaccountParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(myaccountScene);
        window.show();
    }

    public void linktomenuButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent menuParent = FXMLLoader.load(getClass().getResource("../FXML/customerMenu.fxml"));
        Scene menuScene = new Scene(menuParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuScene);
        window.show();
    }

    public void linktomyordersButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent myordersParent = FXMLLoader.load(getClass().getResource("../FXML/myOrdersHome.fxml"));
        Scene myordersScene = new Scene(myordersParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(myordersScene);
        window.show();
    }

    public void linktobookinghomeButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent mybookingsParent = FXMLLoader.load(getClass().getResource("../FXML/bookingHome.fxml"));
        Scene mybookingsScene = new Scene(mybookingsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(mybookingsScene);
        window.show();
    }

    public void notificationspageButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent notificationsParent = FXMLLoader.load(getClass().getResource("../FXML/Notification.fxml"));
        Scene notificationsScene = new Scene(notificationsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(notificationsScene);
        window.show();
    }

    public void logoutbuttonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent logoutParent = FXMLLoader.load(getClass().getResource("../FXML/Customer_login_Scene.fxml"));
        Scene logoutScene = new Scene(logoutParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(logoutScene);
        window.show();
    }

}
