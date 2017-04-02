package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Created by wmu16 on 2/04/17.
 */
public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;


    @FXML
    public void createNewAccount() {
        System.out.println("Creating account!");
    }

    @FXML
    public void login() {
        System.out.println("logging in: " + usernameField.getText() + " (password: " + passwordField.getText() + ")");
    }
}
