package controllers;

import javafx.fxml.FXML;
import model.User;

/**
 * Class for controlling the Login screen
 * Created by wmu16 on 5/04/17.
 */
public class LoginController {


    private MainController mainController;


    void setup(MainController mainController){
        this.mainController = mainController;
    }


    @FXML
    public void login() {
        mainController.loginScreen.setVisible(false);
        mainController.homeScreen.setVisible(true);

        //Create a dummy user for this session
        mainController.setUser(new User("awesomewilly",
                "password",
                "William",
                "Muir",
                20));
    }

    @FXML
    public void createNewAccount() {
        // TODO: 5/04/17 Implement for later release
    }

}
