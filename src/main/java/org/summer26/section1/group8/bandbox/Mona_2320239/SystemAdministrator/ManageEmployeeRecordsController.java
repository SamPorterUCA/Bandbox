package org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator.ModelClass.ManageEmployeeRecordsModelClass;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ManageEmployeeRecordsController
{
    @javafx.fxml.FXML
    private TableColumn<ManageEmployeeRecordsModelClass, String> phoneCol;
    @javafx.fxml.FXML
    private TextField designationText;
    @javafx.fxml.FXML
    private TableColumn<ManageEmployeeRecordsModelClass, String> departmentCol;
    @javafx.fxml.FXML
    private TextField employeeIDText;
    @javafx.fxml.FXML
    private ComboBox<String> statusCombo;
    @javafx.fxml.FXML
    private ComboBox<String> departmentCombo;
    @javafx.fxml.FXML
    private TextField employeeNameText;
    @javafx.fxml.FXML
    private TextField emailText;
    @javafx.fxml.FXML
    private TableColumn<ManageEmployeeRecordsModelClass, String> designationCol;
    @javafx.fxml.FXML
    private TextField phoneText;
    @javafx.fxml.FXML
    private TextField searchText;
    @javafx.fxml.FXML
    private TableColumn<ManageEmployeeRecordsModelClass, String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<ManageEmployeeRecordsModelClass, String> nameCol;
    @javafx.fxml.FXML
    private TableColumn<ManageEmployeeRecordsModelClass, String> emailCol;
    @javafx.fxml.FXML
    private TableView<ManageEmployeeRecordsModelClass> tableview;
    @javafx.fxml.FXML
    private TableColumn<ManageEmployeeRecordsModelClass, String> employeeIDCol;

    ManageEmployeeRecordsModelClass manageEmployeeRecords;
    ArrayList<ManageEmployeeRecordsModelClass> manageEmployeelist=new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {

        statusCombo.getItems().addAll("Active","Inactive");
        departmentCombo.getItems().addAll("HR Dept","IT Dept","Finance Dept");

        employeeIDCol.setCellValueFactory(new PropertyValueFactory<>("EmployeeId"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Employeename"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        designationCol.setCellValueFactory(new PropertyValueFactory<>("designation"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        departmentCol.setCellValueFactory(new PropertyValueFactory<>("department"));
    }

    @javafx.fxml.FXML
    public void searchButton(ActionEvent actionEvent) {

        String searchValue = searchText.getText().toLowerCase();
        tableview.getItems().clear();

        for (ManageEmployeeRecordsModelClass employee : manageEmployeelist) {
            if (employee.getEmployeeId().toLowerCase().contains(searchValue) ||
                    employee.getEmployeename().toLowerCase().contains(searchValue) ||
                    employee.getEmail().toLowerCase().contains(searchValue) ||
                    employee.getPhone().toLowerCase().contains(searchValue) ||
                    employee.getDesignation().toLowerCase().contains(searchValue) ||
                    employee.getStatus().toLowerCase().contains(searchValue) ||
                    employee.getDepartment().toLowerCase().contains(searchValue)) {
                tableview.getItems().add(employee);
            }
        }
    }


    @javafx.fxml.FXML
    public void addEmployeeButton(ActionEvent actionEvent) {
        if (departmentCombo.getValue() == null || designationText.getText().isEmpty() || emailText.getText().isEmpty() || employeeIDText.getText().isEmpty() || employeeNameText.getText().isEmpty() || phoneText.getText().isEmpty() || statusCombo.getValue() == null) {
            // Show an error message if any field is empty
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields before adding an employee.");
            alert.showAndWait();
            return;
        }

        manageEmployeeRecords = new ManageEmployeeRecordsModelClass(departmentCombo.getValue(),designationText.getText(),emailText.getText(),
                employeeIDText.getText(), employeeNameText.getText(),phoneText.getText(),statusCombo.getValue());

        manageEmployeelist.add(manageEmployeeRecords);
        tableview.getItems().addAll(manageEmployeelist);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("EmployeeRecords.bin"))) {
            oos.writeObject(manageEmployeelist);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        departmentCombo.setValue(null);
        designationText.clear();
        emailText.clear();
        employeeIDText.clear();
        employeeNameText.clear();
        phoneText.clear();
        statusCombo.setValue(null);
    }

    @javafx.fxml.FXML
    public void clearButton(ActionEvent actionEvent) {
        tableview.getItems().clear();
        tableview.getItems().addAll(manageEmployeelist);
    }
}