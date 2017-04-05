package controllers;

import javafx.fxml.FXML;

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
    }

    @FXML
    public void createNewAccount() {
        // TODO: 5/04/17 Implement for later release
    }

}
