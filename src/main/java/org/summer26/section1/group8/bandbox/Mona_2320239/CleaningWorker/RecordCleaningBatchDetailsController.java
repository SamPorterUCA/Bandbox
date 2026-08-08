package org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker.ModelClass.RecordCleaning;

import java.util.ArrayList;

public class RecordCleaningBatchDetailsController
{
    @javafx.fxml.FXML
    private ComboBox<String> cleaningTypeCombo;
    @javafx.fxml.FXML
    private TableColumn<RecordCleaning, String> batchIDCol;
    @javafx.fxml.FXML
    private TextField searchText;
    @javafx.fxml.FXML
    private TextField batchIDText;
    @javafx.fxml.FXML
    private TextField nooftemsText;
    @javafx.fxml.FXML
    private TableColumn<RecordCleaning, String> noofItemsCol;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;
    @javafx.fxml.FXML
    private TableView<RecordCleaning> tableview;
    @javafx.fxml.FXML
    private TableColumn<RecordCleaning, String> cleaningTypeCol;
    @javafx.fxml.FXML
    private TableColumn<RecordCleaning, String> remarksCol;

    RecordCleaning recordCleaning;
    ArrayList<RecordCleaning> recordCleaningArrayList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        cleaningTypeCombo.getItems().addAll("Dry Cleaning", "Wet Cleaning", "Steam Cleaning");
        remarksCol.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        cleaningTypeCol.setCellValueFactory(new PropertyValueFactory<>("cleaningType"));
        batchIDCol.setCellValueFactory(new PropertyValueFactory<>("batchID"));
        noofItemsCol.setCellValueFactory(new PropertyValueFactory<>("noofItems"));
    }

    @javafx.fxml.FXML
    public void searchButton(ActionEvent actionEvent) {
        String searchTextValue = searchText.getText().toLowerCase();
        tableview.getItems().clear();
        for (RecordCleaning item : recordCleaningArrayList) {
            if (item.getBatchID().toLowerCase().contains(searchTextValue) ||
                    item.getCleaningType().toLowerCase().contains(searchTextValue) ||
                    item.getNoofItems().toLowerCase().contains(searchTextValue) ||
                    item.getRemarks().toLowerCase().contains(searchTextValue)) {
                tableview.getItems().add(item);
            }
        }
    }

    @javafx.fxml.FXML
    public void saveDataButton(ActionEvent actionEvent) {
        if (batchIDText.getText().isEmpty() || cleaningTypeCombo.getValue() == null || nooftemsText.getText().isEmpty() || remarksTextArea.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
            return;
        }

        recordCleaning = new RecordCleaning(batchIDText.getText(), cleaningTypeCombo.getValue(), nooftemsText.getText(), remarksTextArea.getText());
        recordCleaningArrayList.add(recordCleaning);
        tableview.getItems().addAll(recordCleaning);

        batchIDText.clear();
        cleaningTypeCombo.setValue(null);
        nooftemsText.clear();
        remarksTextArea.clear();
    }

    @javafx.fxml.FXML
    public void cleaButton(ActionEvent actionEvent) {
        tableview.getItems().clear();
        tableview.getItems().addAll(recordCleaningArrayList);
    }
}