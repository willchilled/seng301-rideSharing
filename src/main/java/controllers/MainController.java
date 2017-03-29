package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Main controller for the ride share app. Controls the main screen
 * Created by William Muir on 15/03/17.
 */
public class MainController implements Initializable {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("test");
    }


    public void login() {
        System.out.println("Logging in " + usernameField.getText() + "! (their password is: " + passwordField.getText() + ")" );
    }

    public void createNewAccount() {
        System.out.println("Creating new account!");
    }
}
