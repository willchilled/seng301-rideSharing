package controllers;

import javafx.fxml.FXML;

/**
 * Created by wmu16 on 5/04/17.
 */
public class HomeController {

    private MainController mainController;

    void setup(MainController mainController) {
        this.mainController = mainController;
    }


    @FXML
    public void goToProfile() {
        mainController.homeScreen.setVisible(false);
        mainController.profileScreen.setVisible(true);
    }

    @FXML
    public void goToLogin() {
        mainController.homeScreen.setVisible(false);
        mainController.loginScreen.setVisible(true);
    }

    @FXML
    public void goToHome() {
        // TODO: 5/04/17 Lol i think this can go
        mainController.homeScreen.setVisible(false);
        mainController.homeScreen.setVisible(true);
    }

}
