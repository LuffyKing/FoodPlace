package FoodPlace.Controller;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;
import uti.DBConUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *Controller for the Chef's Order homepage.
 *@author Chunlei Liu
 *@version ?
 */
public class ControllerChefOrderHome implements Initializable {
    @FXML
    private Button linktostaff;
    @FXML
    private Button linktoorders;
    @FXML
    private Button linktomenu;
    @FXML
    private Button linktobookings;
    @FXML
    private Button linktoreports;
    @FXML
    private Button notificationspage;
    @FXML
    private Button logoutbutton;
    @FXML
    private TableView ChefTable;

    /**
     *Changes the chef's scene to the chef permission denied scene.
     *@param event Clicking on a button that would lead to a scene that is not accessable for the chef.
     */
    public void linktostaffButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent permissiondeniedParent = FXMLLoader.load(getClass().getResource("permissiondeniedchef.fxml"));
        Scene permissiondeniedScene = new Scene(permissiondeniedParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(permissiondeniedScene);
        window.show();
    }

    /**
     *Changes the chef's scene to the chef orders scene.
     *@param event Clicking on the orders button.
     */
    public void linktoordersButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent myordersParent = FXMLLoader.load(getClass().getResource("ChefOrderHomepage.fxml"));
        Scene myordersScene = new Scene(myordersParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(myordersScene);
        window.show();
    }

    /**
     *Changes the chef's scene to the chef menu scene.
     *@param event Clicking on the menu button.
     */
    public void linktomenuButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent menuParent = FXMLLoader.load(getClass().getResource("Menu_Scene.fxml"));
        Scene menuScene = new Scene(menuParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuScene);
        window.show();
    }

    /**
     *Changes the chef's scene to the chef permission denied scene.
     *@param event Clicking on a button that would lead to a scene that is not accessable for the chef.
     */
    public void linktobookingsButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent permissiondeniedParent = FXMLLoader.load(getClass().getResource("permissiondeniedchef.fxml"));
        Scene permissiondeniedScene = new Scene(permissiondeniedParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(permissiondeniedScene);
        window.show();
    }

    /**
     *Changes the chef's scene to the chef permission denied scene.
     *@param event Clicking on a button that would lead to a scene that is not accessable for the chef.
     */
    public void linktoreportsButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent permissiondeniedParent = FXMLLoader.load(getClass().getResource("permissiondeniedchef.fxml"));
        Scene permissiondeniedScene = new Scene(permissiondeniedParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(permissiondeniedScene);
        window.show();
    }

    /**
     *Changes the chef's scene to the chef notifications scene.
     *@param event Clicking on the notifications button.
     */
    public void notificationspageButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent notificationsParent = FXMLLoader.load(getClass().getResource("ChefNotifications.fxml"));
        Scene notificationsScene = new Scene(notificationsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(notificationsScene);
        window.show();
    }

    /**
     *Changes the chef's scene to the staff login scene.
     *@param event Clicking on the logout button.
     */
    public void logoutButtonPressed(javafx.event.ActionEvent event) throws IOException {
        Parent logoutParent = FXMLLoader.load(getClass().getResource("Staff_login_Draft.fxml"));
        Scene logoutScene = new Scene(logoutParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(logoutScene);
        window.show();
    }
    Connection con = null;
    private ObservableList<ObservableList> data;
    public ControllerChefOrderHome() {
        con = DBConUtil.connectDB();
    }


    public void getcol() {
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM Orders");

            //SQL FOR SELECTING ALL OF CUSTOMER
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));

                ChefTable.getColumns().removeAll(col);
                ChefTable.getColumns().addAll(col);

                System.out.println("Column [" + i + "] ");
            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());

        }

    }
    private void getRow() {
        data = FXCollections.observableArrayList();
        ResultSet rs;
        try {
            rs = con.createStatement().executeQuery("SELECT * FROM Orders");

            while (rs.next()) {
                //Iterate Row
                ObservableList row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added " + row);
                data.add(row);

            }

            ChefTable.setItems(data);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ChefTable.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
        ChefTable.setTableMenuButtonVisible(true);
        getcol();
        getRow();
    }


}