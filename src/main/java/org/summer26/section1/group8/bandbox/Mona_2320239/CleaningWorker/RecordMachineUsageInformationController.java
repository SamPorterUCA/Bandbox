package org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker.ModelClass.RecordMachineUsage;

import java.util.ArrayList;

public class RecordMachineUsageInformationController
{
    @javafx.fxml.FXML
    private TextField searchText;
    @javafx.fxml.FXML
    private TableColumn<RecordMachineUsage, String> machineTypeCol;
    @javafx.fxml.FXML
    private TextField usageDurationtext;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;
    @javafx.fxml.FXML
    private TableView<RecordMachineUsage> tableview;
    @javafx.fxml.FXML
    private TableColumn<RecordMachineUsage, String> machineIDCol;
    @javafx.fxml.FXML
    private TableColumn<RecordMachineUsage, String> durationCol;
    @javafx.fxml.FXML
    private ComboBox<String> machineTypeCombo;
    @javafx.fxml.FXML
    private TextField machineIDText;
    @javafx.fxml.FXML
    private TableColumn<RecordMachineUsage, String> remarksCol;

    RecordMachineUsage recordCleaning;
    ArrayList<RecordMachineUsage> recordCleaningList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        machineTypeCombo.getItems().addAll("Vacuum Cleaner", "Floor Polisher", "Carpet Cleaner", "Pressure Washer");
        remarksCol.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        machineIDCol.setCellValueFactory(new PropertyValueFactory<>("machineID"));
        machineTypeCol.setCellValueFactory(new PropertyValueFactory<>("machineType"));
        durationCol.setCellValueFactory(new PropertyValueFactory<>("usageDuration"));
    }

    @javafx.fxml.FXML
    public void searchButton(ActionEvent actionEvent) {
        String searchTextValue = searchText.getText().toLowerCase();
        tableview.getItems().clear();
        for (RecordMachineUsage item : recordCleaningList) {
            if (item.getMachineID().toLowerCase().contains(searchTextValue) ||
                    item.getMachineType().toLowerCase().contains(searchTextValue) ||
                    item.getUsageDuration().toLowerCase().contains(searchTextValue) ||
                    item.getRemarks().toLowerCase().contains(searchTextValue)) {
                tableview.getItems().add(item);
            }
        }
    }

    @javafx.fxml.FXML
    public void clearButton(ActionEvent actionEvent) {
        tableview.getItems().clear();
        tableview.getItems().addAll(recordCleaningList);
    }

    @javafx.fxml.FXML
    public void saveDataButton(ActionEvent actionEvent) {
        if (machineIDText.getText().isEmpty() || machineTypeCombo.getValue() == null || remarksTextArea.getText().isEmpty() || usageDurationtext.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        recordCleaning = new RecordMachineUsage(machineIDText.getText(), machineTypeCombo.getValue(), remarksTextArea.getText(), usageDurationtext.getText());
        recordCleaningList.add(recordCleaning);
        tableview.getItems().addAll(recordCleaningList);

        machineIDText.clear();
        machineTypeCombo.setValue(null);
        remarksTextArea.clear();
        usageDurationtext.clear();
    }
}