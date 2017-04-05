package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import model.Vehicle;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by wmu16 on 5/04/17.
 */
public class EditVehiclesController implements Initializable {

    //TABLE

    @FXML
    private TableView vehicleTable;

    @FXML
    private TableColumn licenseCol;

    @FXML
    private TableColumn typeCol;

    @FXML
    private TableColumn numSeatsCol;

    @FXML
    private TableColumn yearCol;


    //ADD VEHICLE

    @FXML
    private TextField licenseNumberField;

    @FXML
    private ComboBox typeComboBox;

    @FXML
    private TextField modelField;

    @FXML
    private TextField yearField;

    @FXML
    private TextField colourField;

    @FXML
    private TextField numOfSeatsField;


    //VEHICLE INFO

    @FXML
    private Text licenseInfoText;

    @FXML
    private Text typeInfoText;

    @FXML
    private Text modelInfoText;

    @FXML
    private Text yearInfoText;

    @FXML
    private Text colourInfoText;

    @FXML
    private Text seatInfoText;

    private ProfileController profileController;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initComboBox();
        initTable();
    }


    private void initComboBox() {
        List<Vehicle.Type> list = new ArrayList<>();
        list.add(Vehicle.Type.CAR);
        list.add(Vehicle.Type.VAN);
        ObservableList obList = FXCollections.observableList(list);
        typeComboBox.getItems().clear();
        typeComboBox.setItems(obList);
        typeComboBox.getSelectionModel().selectFirst();
    }


    private void initTable() {
        licenseCol.setCellValueFactory(new PropertyValueFactory<Vehicle,String>("licensePlate"));
        typeCol.setCellValueFactory(new PropertyValueFactory<Vehicle, Vehicle.Type>("type"));
        numSeatsCol.setCellValueFactory(new PropertyValueFactory<Vehicle, Integer>("numPhysicalSeats"));;
        yearCol.setCellValueFactory(new PropertyValueFactory<Vehicle, Integer>("year"));

        vehicleTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                Vehicle thisVehicle = (Vehicle) newSelection;
                licenseInfoText.setText(thisVehicle.getLicensePlate());
                typeInfoText.setText(thisVehicle.getType().toString());
                modelInfoText.setText(thisVehicle.getModel());
                yearInfoText.setText(thisVehicle.getYear().toString());
                colourInfoText.setText(thisVehicle.getColour());
                seatInfoText.setText(thisVehicle.getNumPhysicalSeats().toString());
            } else {
                licenseInfoText.setText("--");
                typeInfoText.setText("--");
                modelInfoText.setText("--");
                yearInfoText.setText("--");
                colourInfoText.setText("--");
                seatInfoText.setText("--");
            }
        });

        vehicleTable.setPlaceholder(new Label("No Vehicles added"));
    }

    public void setup(ProfileController profileController) {
        this.profileController = profileController;
    }


    @FXML
    public void editVehicle() {

    }

    @FXML
    public void removeVehicle() {
        vehicleTable.getItems().remove(vehicleTable.getSelectionModel().getSelectedItem());
    }

    @FXML
    public void addVehicle() {

        Vehicle vehicle;

        try {
            // TODO: 5/04/17 Need more error checking for alphanumeric
            String licenseNum = licenseNumberField.getText();
            Vehicle.Type type = (Vehicle.Type) typeComboBox.getSelectionModel().getSelectedItem();
            Integer numSeats = Integer.parseInt(numOfSeatsField.getText());
            vehicle = new Vehicle(licenseNum, type, numSeats);
        } catch (NumberFormatException e) {
            System.out.println("That is not a valid number of seats");
            return;
        }

        vehicle.setModel(modelField.getText());
        try {
            vehicle.setYear(Integer.parseInt(yearField.getText()));
        } catch (NumberFormatException e) {
            System.out.println("That is not a valid year!");
        }
        vehicle.setColour(colourField.getText());

        vehicleTable.getItems().add(vehicle);




    }

}
