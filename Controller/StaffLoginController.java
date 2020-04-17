package FoodPlace.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import uti.DBConUtil;

public class StaffLoginController implements Initializable {
    @FXML
    private TextField StaffusernameTextField;
    @FXML
    private PasswordField StaffpassswordField;
    @FXML
    private Label StaffLoginStatus;
    @FXML
    private ComboBox <String> StaffTypeCombo;
    Connection con = null;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    @Override
    /**
     * initialize the controller
     */
    public void initialize(URL url, ResourceBundle resourceBundle ) {
        StaffTypeCombo.getItems().addAll("Manager","Waiter","Chef","Driver");
        StaffTypeCombo.getSelectionModel().select("Manager");

        if (con == null) {
            StaffLoginStatus.setText("Connection Error");
        }

    }
    /**
     * Method for changing the Scene to CustomerLogin
     * @param event
     */
    public void CustomerLoginbuttonPressed(ActionEvent event) throws IOException {
        Parent CustomerViewParent = FXMLLoader.load(getClass().getResource("Customer_login_Scene.fxml"));
        Scene CustomerLoginScene = new Scene(CustomerViewParent);
        // Get Stage Info
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(CustomerLoginScene);
        window.show();
    }
    public StaffLoginController() {
        con = DBConUtil.connectDB();;
    }
    /**
     * Method for changing the scene depending on what type of staff
     * @param event
     * @throws IOException
     */

    public void LoginButtonPressed2(ActionEvent event) throws IOException {
        if (login() == true) {
            if (StaffTypeCombo.getValue().toString() == "Manager") {
                Parent HomeViewParent = FXMLLoader.load(getClass().getResource("ManagerStaffScene.fxml"));
                Scene HomeScene = new Scene(HomeViewParent);
                // Get Stage Info
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                window.setScene(HomeScene);
                window.show();
            }
            else if (StaffTypeCombo.getValue().toString() =="Waiter") {
                Parent HomeViewParent = FXMLLoader.load(getClass().getResource("homeWaiter.fxml"));
                Scene HomeScene = new Scene(HomeViewParent);
                // Get Stage Info
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                window.setScene(HomeScene);
                window.show();

            }
            else if(StaffTypeCombo.getValue().toString() == "Chef") {
                Parent HomeViewParent = FXMLLoader.load(getClass().getResource("homeChef.fxml"));
                Scene HomeScene = new Scene(HomeViewParent);
                // Get Stage Info
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                window.setScene(HomeScene);
                window.show();

            }
            else {
                Parent HomeViewParent = FXMLLoader.load(getClass().getResource("homeDriver.fxml"));
                Scene HomeScene = new Scene(HomeViewParent);

                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                window.setScene(HomeScene);
                window.show();

            }
        }
    }
    /**
     * Method for staff username & password login
     */
    public Boolean login() {
        String staffusername = StaffusernameTextField.getText();
        String staffpassword = StaffpassswordField.getText();
        String stafftype = StaffTypeCombo.getValue().toString();
        if (staffpassword.isEmpty() || (staffusername.isEmpty())) {
            StaffLoginStatus.setText("Empty Username/Password");
            return false;
        }
        else{
            //SQL query
            String Loginquery = "SELECT * FROM Staff WHERE S_Username = ? AND Password = ? AND type = ?";
            try{
                preparedStatement = con.prepareStatement(Loginquery);
                preparedStatement.setString(1,staffusername);
                preparedStatement.setString(2,staffpassword);
                preparedStatement.setString(3,stafftype);
                resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    StaffLoginStatus.setText("Username/Password or stafftype incorrect");
                    return false;
                }
                else {
                    return true;
                }

            } catch (SQLException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }
}

