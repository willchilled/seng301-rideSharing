package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Route;
import model.StopPoint;
import model.User;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Class for controlling the routes editing screen
 * Created by William Muir on 4/19/2017.
 */
public class MyRoutesController implements Initializable {

    @FXML
    private TableView routesTable;

    @FXML
    private TableColumn routesCol;

    @FXML
    private TableView stopPointTable;

    @FXML
    private TableColumn stopPointsCol;

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

        routesCol.setCellValueFactory(new PropertyValueFactory<Route,String>("identifier"));
        stopPointsCol.setCellValueFactory(new PropertyValueFactory<StopPoint, String>("streetAddress"));

        routesTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                Route thisRoute = (Route) newSelection;
                if (!thisRoute.getStopPoints().isEmpty()) {
                    stopPointTable.getItems().setAll(thisRoute.getStopPoints());
                }
            }
        });

        Route testRoute = new Route("Test Route 1");
        StopPoint testPoint1 = new StopPoint("7 Glenfell Place");
        StopPoint testPoint2 = new StopPoint("6 Colligan Street");
        ArrayList<StopPoint> testPoints = new ArrayList<>();
        testPoints.add(testPoint1);
        testPoints.add(testPoint2);
        testRoute.setStopPoints(testPoints);

        routesTable.getItems().add(testRoute);

        Route testRoute2 = new Route("Test Route 12");
        StopPoint testPoint21 = new StopPoint("71 Glenfell Place");
        StopPoint testPoint22 = new StopPoint("16 Colligan Street");
        ArrayList<StopPoint> testPoints2 = new ArrayList<>();
        testPoints2.add(testPoint21);
        testPoints2.add(testPoint22);
        testRoute2.setStopPoints(testPoints2);

        routesTable.getItems().add(testRoute2);
    }

    @FXML
    public void makeNewRoute() {

    }

    @FXML
    public void deleteRoute() {
        User user = profileController.getMainController().getUser();
        Route thisRoute = (Route) routesTable.getSelectionModel().getSelectedItem();
        //Remove visual element
        routesTable.getItems().remove(thisRoute);
        stopPointTable.getItems().removeAll(stopPointTable.getItems());
        //Remove from model
        user.getUserRoutes().remove(thisRoute);
    }

    @FXML
    public void addPoint() {

    }

    @FXML
    public void removePoint() {
        User user = profileController.getMainController().getUser();
        StopPoint thisStopPoint = (StopPoint) stopPointTable.getSelectionModel().getSelectedItem();
        Route thisRoute = (Route) routesTable.getSelectionModel().getSelectedItem();
        //Remove visual element
        stopPointTable.getItems().remove(thisStopPoint);
        //Remove from model
        user.getUserRoutes().get(user.getUserRoutes().indexOf(thisRoute)).getStopPoints().remove(thisStopPoint);

    }

}
