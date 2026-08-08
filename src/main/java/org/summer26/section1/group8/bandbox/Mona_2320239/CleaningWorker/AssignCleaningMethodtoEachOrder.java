package org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker.ModelClass.AssignCleaningMethodtoEachOrderModelClass;

import java.util.ArrayList;

public class AssignCleaningMethodtoEachOrder
{
    @javafx.fxml.FXML
    private TextField searchText;
    @javafx.fxml.FXML
    private TableColumn<AssignCleaningMethodtoEachOrderModelClass,String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<AssignCleaningMethodtoEachOrderModelClass,String> customerNameCol;
    @javafx.fxml.FXML
    private TextField cleaningMethodText;
    @javafx.fxml.FXML
    private TextField orderIDText;
    @javafx.fxml.FXML
    private ComboBox<String> statusCombo;
    @javafx.fxml.FXML
    private TableView<AssignCleaningMethodtoEachOrderModelClass> tableview;
    @javafx.fxml.FXML
    private TextField customerNameText;
    @javafx.fxml.FXML
    private TableColumn<AssignCleaningMethodtoEachOrderModelClass,String> orderIDCol;
    @javafx.fxml.FXML
    private TableColumn<AssignCleaningMethodtoEachOrderModelClass,String>cleaningMethodCol;

    AssignCleaningMethodtoEachOrderModelClass assignCleaningMethodtoEachOrderModelClass;
    ArrayList<AssignCleaningMethodtoEachOrderModelClass> assignCleaningMethodtoEachOrderModelClassArrayList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {

        statusCombo.getItems().addAll("Unassigned", "Assigned", "Processing", "Done");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("Status"));
        customerNameCol.setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
        orderIDCol.setCellValueFactory(new PropertyValueFactory<>("OrderID"));
        cleaningMethodCol.setCellValueFactory(new PropertyValueFactory<>("Status"));
    }

    @javafx.fxml.FXML
    public void searchButton(ActionEvent actionEvent) {
        String searchTextValue = searchText.getText().toLowerCase();
        tableview.getItems().clear();
        for (AssignCleaningMethodtoEachOrderModelClass item : assignCleaningMethodtoEachOrderModelClassArrayList) {
            if (item.getCustomerName().toLowerCase().contains(searchTextValue) ||
                    item.getOrderID().toLowerCase().contains(searchTextValue) ||
                    item.getCleaningMethod().toLowerCase().contains(searchTextValue) ||
                    item.getStatus().toLowerCase().contains(searchTextValue)) {
                tableview.getItems().add(item);
            }
        }
    }

    @javafx.fxml.FXML
    public void clearButton(ActionEvent actionEvent) {
        tableview.getItems().clear();
        tableview.getItems().addAll(assignCleaningMethodtoEachOrderModelClassArrayList);
    }

    @javafx.fxml.FXML
    public void SaveDataButton(ActionEvent actionEvent) {
        if (cleaningMethodText.getText().isEmpty() || customerNameText.getText().isEmpty() || orderIDText.getText().isEmpty() || statusCombo.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Missing Information");
            alert.setContentText("Please fill in all fields before saving.");
            alert.showAndWait();
            return;
        }

        assignCleaningMethodtoEachOrderModelClass = new AssignCleaningMethodtoEachOrderModelClass(
                cleaningMethodText.getText(),
                customerNameText.getText(),
                orderIDText.getText(),
                statusCombo.getValue()
        );
        assignCleaningMethodtoEachOrderModelClassArrayList.add(assignCleaningMethodtoEachOrderModelClass);
        tableview.getItems().addAll(assignCleaningMethodtoEachOrderModelClassArrayList);

        cleaningMethodText.clear();
        customerNameText.clear();
        orderIDText.clear();
        statusCombo.setValue(null);
    }
}