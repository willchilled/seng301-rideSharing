package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Main controller for the ride share app. Controls the main screen
 * Created by William Muir on 15/03/17.
 */
public class MainController {

    @FXML
    private AnchorPane paneHolder;

    public void setVista(Node node) {
        paneHolder.getChildren().setAll(node);
    }

}
