package org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator.ModelClass.MaintanenceEquipmentModelClass;

import java.util.ArrayList;

public class MaintainEquipmentLifecycleRecordsController
{
    @javafx.fxml.FXML
    private ComboBox<String> equipmentStatusCombo;
    @javafx.fxml.FXML
    private TextField equipmentIDText;
    @javafx.fxml.FXML
    private TextField searchText;
    @javafx.fxml.FXML
    private DatePicker lastmaintainanceDatepicker;
    @javafx.fxml.FXML
    private TableColumn<MaintanenceEquipmentModelClass,String> equipmentIDCol;
    @javafx.fxml.FXML
    private TableColumn<MaintanenceEquipmentModelClass,String> equipmentStatusCol;
    @javafx.fxml.FXML
    private ComboBox<String> equipmentTypeCombo;
    @javafx.fxml.FXML
    private TableColumn<MaintanenceEquipmentModelClass,String> equipmentNameCol;
    @javafx.fxml.FXML
    private TableColumn<MaintanenceEquipmentModelClass,String> lastmaintainanceDateCol;
    @javafx.fxml.FXML
    private TextField equipmentName;
    @javafx.fxml.FXML
    private TableColumn<MaintanenceEquipmentModelClass,String> equipmentTypeCol;
    @javafx.fxml.FXML
    private TableView<MaintanenceEquipmentModelClass> tableview;

    MaintanenceEquipmentModelClass maintanenceEquipmentModelClass;
    ArrayList<MaintanenceEquipmentModelClass> maintanenceEquipmentModelClassArrayList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        equipmentStatusCombo.getItems().addAll("Active","Inactive","Under Maintanace");
        equipmentTypeCombo.getItems().addAll("Hardware","Software");

        equipmentIDCol.setCellValueFactory(new PropertyValueFactory<>("EquipmentId"));
        equipmentStatusCol.setCellValueFactory(new PropertyValueFactory<>("EquipmentStatus"));
        equipmentNameCol.setCellValueFactory(new PropertyValueFactory<>("EquipmentName"));
        lastmaintainanceDateCol.setCellValueFactory(new PropertyValueFactory<>("LastmaintananceDate"));
        equipmentTypeCol.setCellValueFactory(new PropertyValueFactory<>("EquipmentType"));

    }

    @javafx.fxml.FXML
    public void updateRecordButton(ActionEvent actionEvent) {
        if (equipmentIDText.getText().isEmpty() || equipmentName.getText().isEmpty() || equipmentStatusCombo.getValue() == null || equipmentTypeCombo.getValue() == null || lastmaintainanceDatepicker.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please fill all the fields");
            alert.showAndWait();
            return;
        }

        maintanenceEquipmentModelClass = new MaintanenceEquipmentModelClass(equipmentIDText.getText(),equipmentName.getText(),equipmentStatusCombo.getValue(),equipmentTypeCombo.getValue(), lastmaintainanceDatepicker.getValue());
        maintanenceEquipmentModelClassArrayList.add(maintanenceEquipmentModelClass);
        tableview.getItems().addAll(maintanenceEquipmentModelClassArrayList);

        equipmentName.clear();
        equipmentIDText.clear();
        equipmentStatusCombo.setValue(null);
        equipmentTypeCombo.setValue(null);
        lastmaintainanceDatepicker.setValue(null);
    }

    @javafx.fxml.FXML
    public void searchButton(ActionEvent actionEvent) {
        String searchValue = searchText.getText().toLowerCase();
        tableview.getItems().clear();
        for (MaintanenceEquipmentModelClass equipment : maintanenceEquipmentModelClassArrayList) {
            if (equipment.getEquipmentId().toLowerCase().contains(searchValue) ||
                    equipment.getEquipmentName().toLowerCase().contains(searchValue) ||
                    equipment.getEquipmentStatus().toLowerCase().contains(searchValue) ||
                    equipment.getEquipmentType().toLowerCase().contains(searchValue) ||
                    equipment.getLastmaintananceDate().toString().toLowerCase().contains(searchValue)) {
                tableview.getItems().add(equipment);
            }
        }
    }

    @javafx.fxml.FXML
    public void resetButton(ActionEvent actionEvent) {
        tableview.getItems().clear();
        tableview.getItems().addAll(maintanenceEquipmentModelClassArrayList);
    }
}