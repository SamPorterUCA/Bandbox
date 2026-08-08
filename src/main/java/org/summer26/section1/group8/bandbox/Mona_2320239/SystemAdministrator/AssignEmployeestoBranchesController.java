package org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator.ModelClass.AssignEmployee;
import org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator.ModelClass.ManageEmployeeRecordsModelClass;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class AssignEmployeestoBranchesController
{
    @javafx.fxml.FXML
    private TextField searchText;
    @javafx.fxml.FXML
    private TableView<AssignEmployee> tableView;
    @javafx.fxml.FXML
    private TextField branchNameText;
    @javafx.fxml.FXML
    private ComboBox<String> employeeIdCombo;
    @javafx.fxml.FXML
    private TableColumn<AssignEmployee, String> phoneCol;
    @javafx.fxml.FXML
    private TableColumn<AssignEmployee, String> departmentCol;
    @javafx.fxml.FXML
    private TableColumn<AssignEmployee, String> branchCol;
    @javafx.fxml.FXML
    private TableColumn<AssignEmployee, String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<AssignEmployee, String> emplyeeIdCol;
    @javafx.fxml.FXML
    private TableColumn<AssignEmployee, String> namecol;
    @javafx.fxml.FXML
    private TableColumn<AssignEmployee, String> emailCol;
    @javafx.fxml.FXML
    private TableColumn<AssignEmployee, String> designationCol;

    AssignEmployee assignEmployee;
    ArrayList<AssignEmployee> assignEmployeelist=new ArrayList<>();
    private String department, designation, email, phone, status, name;

    @javafx.fxml.FXML
    public void initialize() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("EmployeeRecords.bin"))) {
            ArrayList<ManageEmployeeRecordsModelClass> employeeList =
                    (ArrayList<ManageEmployeeRecordsModelClass>) ois.readObject();
            employeeIdCombo.getItems().clear();

            for (ManageEmployeeRecordsModelClass employee : employeeList) {
                employeeIdCombo.getItems().add(employee.getEmployeeId());
                department = employee.getDepartment();
                designation = employee.getDesignation();
                email = employee.getEmail();
                name = employee.getEmployeename();
                phone = employee.getPhone();
                status = employee.getStatus();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        departmentCol.setCellValueFactory(new PropertyValueFactory<>("department"));
        designationCol.setCellValueFactory(new PropertyValueFactory<>("designation"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        emplyeeIdCol.setCellValueFactory(new PropertyValueFactory<>("EmployeeId"));
        namecol.setCellValueFactory(new PropertyValueFactory<>("Employeename"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        branchCol.setCellValueFactory(new PropertyValueFactory<>("branchName"));
    }

    @javafx.fxml.FXML
    public void searchButton(ActionEvent actionEvent) {
        String searchValue = searchText.getText().toLowerCase();
        tableView.getItems().clear();

        for (AssignEmployee employee : assignEmployeelist) {
            if (employee.getEmployeeId().toLowerCase().contains(searchValue) ||
                    employee.getEmployeename().toLowerCase().contains(searchValue) ||
                    employee.getEmail().toLowerCase().contains(searchValue) ||
                    employee.getPhone().toLowerCase().contains(searchValue) ||
                    employee.getDesignation().toLowerCase().contains(searchValue) ||
                    employee.getStatus().toLowerCase().contains(searchValue) ||
                    employee.getDepartment().toLowerCase().contains(searchValue) ||
                    employee.getBranchName().toLowerCase().contains(searchValue)) {
                tableView.getItems().add(employee);
            }
        }
    }

    @javafx.fxml.FXML
    public void updateButton(ActionEvent actionEvent) {
        if (branchNameText.getText().isEmpty() || employeeIdCombo.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
            return;
        }

        assignEmployee = new AssignEmployee(branchNameText.getText(), department, designation, email, employeeIdCombo.getValue(), name, phone, status);
        assignEmployeelist.add(assignEmployee);
        tableView.getItems().addAll(assignEmployeelist);

        employeeIdCombo.getItems().clear();
        branchNameText.clear();
    }

    @javafx.fxml.FXML
    public void resetButton(ActionEvent actionEvent) {
        tableView.getItems().clear();
        tableView.getItems().addAll(assignEmployeelist);
    }
}