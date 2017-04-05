package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        includedLoginScreenController.setup(this);
        includedHomeScreenController.setup(this);

        loginScreen.setVisible(true);
    }


}
