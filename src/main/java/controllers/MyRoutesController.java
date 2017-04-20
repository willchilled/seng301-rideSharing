package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Route;
import model.StopPoint;
import model.User;

import java.net.URL;
import java.util.Optional;
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
    private Button removeRouteButton;

    @FXML
    private TableView stopPointTable;

    @FXML
    private TableColumn stopPointsCol;

    @FXML
    private Button addPointButton;

    @FXML
    private Button removePointButton;

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
                removeRouteButton.setDisable(false);
                addPointButton.setDisable(false);
                Route thisRoute = (Route) newSelection;
                stopPointTable.getItems().setAll(thisRoute.getStopPoints());
            } else {
                removeRouteButton.setDisable(true);
                addPointButton.setDisable(true);
            }
        });

        stopPointTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                removePointButton.setDisable(false);
            } else {
                removePointButton.setDisable(true);
            }
        });
    }

    @FXML
    public void makeNewRoute() {

        TextInputDialog dialog = new TextInputDialog("My Route 1");
        dialog.setTitle("Make New Route");
        dialog.setHeaderText("Enter the identifier for this new route");
        dialog.setContentText("Route Identifier:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            String routeIdentifier = result.get();

            //Check that the route identifier doesnt already exist
            Boolean validIdentifier = true;
            for (Route route : profileController.getMainController().getUser().getUserRoutes()) {
                if(route.getIdentifier().equals(routeIdentifier)) {
                    validIdentifier = false;
                }
            }
            if (validIdentifier) {
                Route thisRoute = new Route(routeIdentifier);
                profileController.getMainController().getUser().getUserRoutes().add(thisRoute);
                routesTable.getItems().add(thisRoute);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("That Route already exists!");
                alert.setContentText("Please try again with a unique route name");

                alert.showAndWait();
            }
        }

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
        if(user.getUserRoutes().size() > 0) {
            routesTable.getSelectionModel().selectFirst();
        }
    }

    @FXML
    public void addPoint() {

        User user = profileController.getMainController().getUser();
        Route thisRoute = (Route) routesTable.getSelectionModel().getSelectedItem();
        if(thisRoute != null) {
            TextInputDialog dialog = new TextInputDialog("My Point 1");
            dialog.setTitle("Make New Stop Point");
            dialog.setHeaderText("Enter the Address for this Stop Point");
            dialog.setContentText("Address:");

            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                String address = result.get();

                //Check that the stopPoint address doesnt already exist
                thisRoute = user.getUserRoutes().get(user.getUserRoutes().indexOf(thisRoute));
                Boolean validAddress = true;
                for (StopPoint stopPoint : thisRoute.getStopPoints()) {
                    if (stopPoint.getStreetAddress().equals(address)) {
                        validAddress = false;
                    }
                }
                if (validAddress) {
                    StopPoint thisStopPoint = new StopPoint(address);
                    user.getUserRoutes().get(user.getUserRoutes().indexOf(thisRoute)).getStopPoints().add(thisStopPoint);
                    stopPointTable.getItems().add(thisStopPoint);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("That Stop Point already exists!");
                    alert.setContentText("Please try again with a unique address");

                    alert.showAndWait();
                }
            }
        }
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
