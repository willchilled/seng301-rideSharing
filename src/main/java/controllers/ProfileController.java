package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by wmu16 on 5/04/17.
 */
public class ProfileController implements Initializable{

    @FXML
    public AnchorPane editVehiclesScreen;

    @FXML
    public AnchorPane myRoutesScreen;

    @FXML
    private MyRoutesController includedMyRoutesController;

    @FXML
    private EditVehiclesController includedEditVehiclesController;

    private MainController mainController;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        includedMyRoutesController.setup(this);
        includedEditVehiclesController.setup(this);
    }


    public void setup(MainController mainController) {
        this.mainController = mainController;
    }

    //NAVIGATION

    @FXML
    public void goToLogin() {
        mainController.profileScreen.setVisible(false);
        mainController.loginScreen.setVisible(true);
    }

    @FXML
    public void goToHome() {
        mainController.profileScreen.setVisible(false);
        mainController.homeScreen.setVisible(true);

    }

    @FXML
    public void goBack() {
        // TODO: 5/04/17 This should be a function of the main controller, remembering the last panel opened
    }


    //SETTINGS

    @FXML
    public void goToEditDetails() {

    }

    @FXML
    public void goToEditVehicles() {
        myRoutesScreen.setVisible(false);
        editVehiclesScreen.setVisible(true);
    }


    @FXML
    public void goToMyRoutes() {
        editVehiclesScreen.setVisible(false);
        myRoutesScreen.setVisible(true);
    }


    public MainController getMainController() {
        return mainController;
    }
}
