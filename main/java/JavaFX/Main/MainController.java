package JavaFX.Main;

import Hibernate.Dao.Entity.User;
import Hibernate.Dao.Util.*;
import JavaFX.List.ListController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MainController {

    @FXML
    private Button addButton;
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    @FXML
    private VBox listOfElements;

    private UserDaoImpl database;

    public MainController() {
        database = new UserDaoImpl();
    }

    @FXML
    public void addData() {
        if(login.getText().length()==0 || password.getText().length()==0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Uwaga!");
            alert.setHeaderText("Nie odnaleziono znaku");
            alert.setContentText("Wpisz swój login i hasło");
            alert.showAndWait();
        }else {
            User user = new User(login.getText(), password.getText());
            login.setText("");
            password.setText("");
            database.insert(user);
            createChildElement(user);
        }
    }

    private void createChildElement(User user) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../List.fxml"));
        ListController controller = new ListController(user);
        loader.setController(controller);
        Pane pane = null;
        try {
            pane = loader.load();
            listOfElements.getChildren().add(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
        controller.setProperties(user.getLogin(), user.getPassword());
    }
}
