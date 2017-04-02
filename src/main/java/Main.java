import controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Main class for application launching
 * Created by William Muir on 7/03/17.
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("UC RideShare");

        stage.setScene(
                createScene(
                        loadMainPane()
                )
        );

        stage.show();
    }

    /**
     * Loads the main fxml layout.
     * Sets up the vista switching VistaNavigator.
     * Loads the first vista into the fxml layout.
     *
     * @return the loaded pane.
     * @throws IOException if the pane could not be loaded.
     */
    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getClassLoader().getResource(
                RideShareNavigator.MAIN));

        Pane mainPane = loader.load();

        MainController mainController = loader.getController();
        RideShareNavigator.setMainController(mainController);
        RideShareNavigator.loadVista(RideShareNavigator.LOGIN);

        return mainPane;
    }

    /**
     * Creates the main application scene.
     *
     * @param mainPane the main application layout.
     *
     * @return the created scene.
     */
    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(
                mainPane
        );

        // TODO: 2/04/17 Set style sheets here for later
//        scene.getStylesheets().setAll(
//                getClass().getResource("vista.css").toExternalForm()
//        );

        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}