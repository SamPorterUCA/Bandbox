package org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker.ModelClass.CreateMaintenanceSchedulesModelClass;

import java.time.LocalDate;
import java.util.ArrayList;

public class CreateCustomerComplaintResolutionRecordsController
{
    @javafx.fxml.FXML
    private TextField complaintIDText;
    @javafx.fxml.FXML
    private TableColumn<CreateMaintenanceSchedulesModelClass,String> complainIDCol;
    @javafx.fxml.FXML
    private TableColumn<CreateMaintenanceSchedulesModelClass,String> resolutionNoteCol;
    @javafx.fxml.FXML
    private TableColumn<CreateMaintenanceSchedulesModelClass, LocalDate> complainDateCol;
    @javafx.fxml.FXML
    private DatePicker complaintDatePicker;
    @javafx.fxml.FXML
    private TableColumn<CreateMaintenanceSchedulesModelClass,String> resolutionTypeCol;
    @javafx.fxml.FXML
    private TableView<CreateMaintenanceSchedulesModelClass> tableview;
    @javafx.fxml.FXML
    private TextArea resolutionNoteTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> resolutionTypeCombo;
    @javafx.fxml.FXML
    private TextField searchText;

    CreateMaintenanceSchedulesModelClass createMaintanenceModelCalss;
    ArrayList<CreateMaintenanceSchedulesModelClass> createMaintenanceScheduleList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        resolutionTypeCombo.getItems().addAll("Resolved","Unresolved");

        resolutionNoteCol.setCellValueFactory(new PropertyValueFactory<>("ResolutionNote"));
        complainIDCol.setCellValueFactory(new PropertyValueFactory<>("ComplaintID"));
        complainDateCol.setCellValueFactory(new PropertyValueFactory<>("ComplaintDate"));
        resolutionTypeCol.setCellValueFactory(new PropertyValueFactory<>("ResolutionType"));
    }

    @javafx.fxml.FXML
    public void sendComplainButton(ActionEvent actionEvent) {
        if (complaintDatePicker.getValue() == null || complaintIDText.getText().isEmpty() || resolutionNoteTextArea.getText().isEmpty() || resolutionTypeCombo.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the fields.");
            alert.showAndWait();
            return;
        }

        createMaintanenceModelCalss = new CreateMaintenanceSchedulesModelClass(complaintDatePicker.getValue(), complaintIDText.getText(), resolutionNoteTextArea.getText(), resolutionTypeCombo.getValue());
        createMaintenanceScheduleList.add(createMaintanenceModelCalss);
        tableview.getItems().addAll(createMaintenanceScheduleList);

        complaintDatePicker.setValue(null);
        complaintIDText.clear();
        resolutionNoteTextArea.clear();
        resolutionTypeCombo.setValue(null);
    }

    @javafx.fxml.FXML
    public void searchButton(ActionEvent actionEvent) {
        String searchTextValue = searchText.getText().toLowerCase();
        tableview.getItems().clear();
        for (CreateMaintenanceSchedulesModelClass record : createMaintenanceScheduleList) {
            if (record.getComplaintID().toLowerCase().contains(searchTextValue) ||
                record.getResolutionNote().toLowerCase().contains(searchTextValue) ||
                record.getResolutionType().toLowerCase().contains(searchTextValue) ||
                record.getComplaintDate().toString().contains(searchTextValue)) {
                tableview.getItems().add(record);
            }
        }
    }

    @javafx.fxml.FXML
    public void clearButton(ActionEvent actionEvent) {
        tableview.getItems().clear();
        tableview.getItems().addAll(createMaintenanceScheduleList);
    }
}