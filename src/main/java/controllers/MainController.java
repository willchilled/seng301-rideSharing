package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import model.User;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Primary controller which contains all other controllers and their containers
 * Created by wmu16 on 5/04/17.
 */
public class MainController implements Initializable{

    @FXML
    public AnchorPane loginScreen;
    @FXML
    private LoginController includedLoginScreenController;


    @FXML
    public AnchorPane homeScreen;
    @FXML
    private HomeController includedHomeScreenController;

    // TODO: 5/04/17 Make getters for these rather than directly accesing through sub controllers
    @FXML
    public AnchorPane profileScreen;
    @FXML
    private ProfileController includedProfileScreenController;

    private AnchorPane previousPane;

    private User user;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        includedLoginScreenController.setup(this);
        includedHomeScreenController.setup(this);
        includedProfileScreenController.setup(this);

        loginScreen.setVisible(true);
        previousPane = loginScreen;
    }


    // TODO: 5/04/17 Implement properly
    public void goBack() {
        loginScreen.setVisible(false);
        homeScreen.setVisible(false);
        profileScreen.setVisible(false);

        previousPane.setVisible(true);

    }


    public void setScreen() {
        loginScreen.setVisible(false);
        homeScreen.setVisible(false);
        profileScreen.setVisible(false);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
