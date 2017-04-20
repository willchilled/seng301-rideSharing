package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Route;

/**
 * Controller class for popup for adding routes
 * Created by William Muir on 4/20/2017.
 */
public class RouteCreatorPopUpController {

    //Popup FXML stuff
    @FXML
    private TextField routeIdentifierTextField;

    @FXML
    private Text warningText;

    private MyRoutesController myRoutesController;

    public RouteCreatorPopUpController(MyRoutesController myRoutesController) {
        this.myRoutesController = myRoutesController;

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

}
