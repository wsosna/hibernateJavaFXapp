package JavaFX.List;


import Hibernate.Dao.Entity.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


public class ListController {
    @FXML
    private Text login;
    @FXML
    private Text password;
    @FXML
    private Button showButton;
    private User user;
    private boolean stan;

    public ListController(User user) {
        this.user = user;
        stan = false;
    }

    public void setProperties(String login, String password) {
        this.login.setText(login);
        hidePassword(password);
    }

    @FXML
    public void show() {
        if(!stan){
            this.password.setText(user.getPassword());
            stan = true;
        }else {
            hidePassword(user.getPassword());
            stan = false;
        }
    }

    public void hidePassword(String password) {
        StringBuilder strB = new StringBuilder();
        for ( int i = 0; i < password.length(); i++) {
            strB.append("*");
        }
        this.password.setText(strB.toString());
    }
}

