package FoodPlace.Controller;

import FoodPlace.FoodDB.OrderDB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import jdk.internal.module.Resources;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
*Controller for the scene the customer views when they click on My Orders.
*@author Sara Philipson
*@version ?
*/
public class ControllerMyOrdersHome {

    public Button linktomyaccount;
    public Button linktobookinghome;
    public Button linktomenu;
    public Button linktomyorders;
    public Button notificationspage;
    public Button logoutbutton;
    public Button linktomyordersedit;
    public TableColumn orderIdColumn = new TableColumn();
    public TableColumn datetimeColumn = new TableColumn();
    public TableColumn orderStatusColumn = new TableColumn();
    public TableColumn orderTypeColumn = new TableColumn();
    public TableColumn editbuttoncolumn = new TableColumn();
    public TableView orderstable;

    /**
    *Changes the customer's scene to the My Account scene.
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
    *Changes the customer's scene to the Menu scene.
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
    *Changes the customer's scene to the My Orders scene.
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
    *Changes the customer's scene to the My Bookings scene.
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
    *Changes the customer's scene to the Notifications scene.
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
    *Changes the customer's scene to the customer login scene.
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
    *Changes the customer's scene to the Edit Order scene.
    *@param event Clicking on the Edit Order button.
    */
    public void linktomyorderseditbuttonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent myorderseditParent = FXMLLoader.load(getClass().getResource("myOrdersEdit.fxml"));
        Scene myorderseditScene = new Scene(myorderseditParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(myorderseditScene);
        window.show();
    }

   //may or may not work, I can't get this program to run so I can't check. Made using many different tutorials until it stopped producing error messages.
   //* Displays orders in the table on the scene.
     * @param location
     * @param resources
     */
    @FXML
    protected void initialize(URL location, Resources resources) {
        orderIdColumn.setCellValueFactory(new PropertyValueFactory<OrderDB, Integer>("Order ID"));
        datetimeColumn.setCellValueFactory(new PropertyValueFactory<OrderDB, LocalDateTime>("Date & Time Placed"));
        orderStatusColumn.setCellValueFactory(new PropertyValueFactory<OrderDB, String>("Status"));
        orderTypeColumn.setCellValueFactory(new PropertyValueFactory<OrderDB, String>("Type"));
        editbuttoncolumn.setCellValueFactory(new PropertyValueFactory<OrderDB, CheckBox>("Edit?"));
        try{
            OrderDB x = new OrderDB();
            orderstable.getItems().setAll(x.getAllOrders());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
