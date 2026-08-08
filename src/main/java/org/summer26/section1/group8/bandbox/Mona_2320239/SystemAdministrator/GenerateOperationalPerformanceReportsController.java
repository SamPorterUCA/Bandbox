package org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator.ModelClass.GenerateOperation;
import org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator.ModelClass.ManageEmployeeRecordsModelClass;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class GenerateOperationalPerformanceReportsController
{
    @javafx.fxml.FXML
    private TableColumn<GenerateOperation, String> departmentCol;
    @javafx.fxml.FXML
    private ComboBox<String> departmentCombo;
    @javafx.fxml.FXML
    private ComboBox<String> employeeIDCombo;
    @javafx.fxml.FXML
    private TextField performancePointText;
    @javafx.fxml.FXML
    private TableColumn<GenerateOperation, String> performancePointCol;
    @javafx.fxml.FXML
    private TableView<GenerateOperation> tableview;
    @javafx.fxml.FXML
    private TableColumn<GenerateOperation, String> employeeIDCol;
    @javafx.fxml.FXML
    private DatePicker reportDatepicker;
    @javafx.fxml.FXML
    private TableColumn<GenerateOperation, LocalDate> reportPeriodCol;
    @javafx.fxml.FXML
    private TextField searchText;

    GenerateOperation generateOperation;
    ArrayList<GenerateOperation> generateOperationList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("EmployeeRecords.bin"))) {
            ArrayList<ManageEmployeeRecordsModelClass> employeeList =
                    (ArrayList<ManageEmployeeRecordsModelClass>) ois.readObject();
            employeeIDCombo.getItems().clear();
            departmentCombo.getItems().clear();

            for (ManageEmployeeRecordsModelClass employee : employeeList) {
                employeeIDCombo.getItems().add(employee.getEmployeeId());
                departmentCombo.getItems().add(employee.getDepartment());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        departmentCol.setCellValueFactory(new PropertyValueFactory<>("department"));
        performancePointCol.setCellValueFactory(new PropertyValueFactory<>("performancePoint"));
        employeeIDCol.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        reportPeriodCol.setCellValueFactory(new PropertyValueFactory<>("reportPeriod"));
    }

    @javafx.fxml.FXML
    public void clearButton(ActionEvent actionEvent) {
        tableview.getItems().clear();
        tableview.getItems().addAll(generateOperationList);
    }

    @javafx.fxml.FXML
    public void generateReportButton(ActionEvent actionEvent) {
        if (departmentCombo.getValue() == null || employeeIDCombo.getValue() == null ||
                performancePointText.getText().isEmpty() || reportDatepicker.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        generateOperation = new GenerateOperation(
                departmentCombo.getValue(),
                employeeIDCombo.getValue(),
                performancePointText.getText(),
                reportDatepicker.getValue()
        );
        generateOperationList.add(generateOperation);
        tableview.getItems().addAll(generateOperationList);

        departmentCombo.setValue(null);
        employeeIDCombo.setValue(null);
        performancePointText.clear();
        reportDatepicker.setValue(null);
    }

    @javafx.fxml.FXML
    public void searchButton(ActionEvent actionEvent) {
        String searchTextValue = searchText.getText().toLowerCase();
        tableview.getItems().clear();

        for (GenerateOperation operation : generateOperationList) {
            if (operation.getDepartment().toLowerCase().contains(searchTextValue) ||
                    operation.getEmployeeID().toLowerCase().contains(searchTextValue) ||
                    operation.getPerformancePoint().toLowerCase().contains(searchTextValue) ||
                    operation.getReportPeriod().toString().contains(searchTextValue)) {
                tableview.getItems().add(operation);
            }
        }

    }
}