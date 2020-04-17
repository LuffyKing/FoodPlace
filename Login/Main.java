package FoodPlace.Login;

import FoodPlace.Customer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private Customer customer;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../FXML/Customer_login_Scene.fxml"));
        primaryStage.setTitle("FoodPlace");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
