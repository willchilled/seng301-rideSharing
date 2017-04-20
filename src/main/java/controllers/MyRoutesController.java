package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Route;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Computer Doctor on 4/19/2017.
 */
public class MyRoutesController implements Initializable {

    @FXML
    private TableView routesTable;

    @FXML
    private TableView stopPointTable;

    //Popup FXML stuff
    @FXML
    private TextField routeIdentifierTextField;

    @FXML
    private Text warningText;



    private ProfileController profileController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTables();
    }


    void setup(ProfileController profileController) {
        this.profileController = profileController;
    }


    private void initTables() {
        routesTable.setPlaceholder(new Label("No Routes added"));
        stopPointTable.setPlaceholder(new Label("No Stop Points"));
    }


    @FXML
    public void makeNewRoute() {
        Stage stage;
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("routeCreatorPopUp.fxml"));
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Make New Route");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(routesTable.getScene().getWindow());
        stage.showAndWait();

    }


    @FXML
    public void createRoute() {

        String routeIdentifier = routeIdentifierTextField.getText();
        if(routeIdentifier != null) {
            Route thisRoute = new Route(routeIdentifierTextField.getText());
        } else {
            warningText.setVisible(true);

        }

    }

    @FXML
    public void deleteRoute() {

    }

    @FXML
    public void addPoint() {

    }

    @FXML
    public void removePoint() {

    }
}
