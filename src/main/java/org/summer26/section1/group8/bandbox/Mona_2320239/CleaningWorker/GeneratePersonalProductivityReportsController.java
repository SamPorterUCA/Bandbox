package org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker.ModelClass.GenerateReport;
import org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker.ModelClass.RecordShiftAttendanceActivitiesModelClass;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class GeneratePersonalProductivityReportsController
{
    @javafx.fxml.FXML
    private TableColumn<GenerateReport, String> shiftCol;
    @javafx.fxml.FXML
    private TableColumn<GenerateReport, String> employeeNameCol;
    @javafx.fxml.FXML
    private TextField searchText;
    @javafx.fxml.FXML
    private TableColumn<GenerateReport, LocalDate> dateCol;
    @javafx.fxml.FXML
    private ComboBox<String> employeeIDCombo;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;
    @javafx.fxml.FXML
    private TableView<GenerateReport> tableview;
    @javafx.fxml.FXML
    private TableColumn<GenerateReport, String> employeeIDCol;
    @javafx.fxml.FXML
    private TableColumn<GenerateReport, String> attendanceNoteCol;
    @javafx.fxml.FXML
    private TableColumn<GenerateReport, String> remarksCol;

    GenerateReport generateReport;
    ArrayList<GenerateReport> generateReportList = new ArrayList<>();
    private String name, shift, attendanceNote;

    @javafx.fxml.FXML
    public void initialize() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("ShiftAttendance.bin"))) {
            ArrayList<RecordShiftAttendanceActivitiesModelClass> employeeList =
                    (ArrayList<RecordShiftAttendanceActivitiesModelClass>) ois.readObject();
            employeeIDCombo.getItems().clear();

            for (RecordShiftAttendanceActivitiesModelClass employee : employeeList) {
                employeeIDCombo.getItems().add(employee.getEmployeeID());
                name = employee.getEmployeeName();
                shift = employee.getShift();
                attendanceNote = employee.getAttendanceNote();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        shiftCol.setCellValueFactory(new PropertyValueFactory<>("shift"));
        employeeNameCol.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        employeeIDCol.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        remarksCol.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        attendanceNoteCol.setCellValueFactory(new PropertyValueFactory<>("attendanceNote"));
    }

    @javafx.fxml.FXML
    public void searchButton(ActionEvent actionEvent) {
        String searchTextValue = searchText.getText().toLowerCase();
        tableview.getItems().clear();
        for (GenerateReport report : generateReportList) {
            if (report.getEmployeeID().toLowerCase().contains(searchTextValue) ||
                    report.getEmployeeName().toLowerCase().contains(searchTextValue) ||
                    report.getShift().toLowerCase().contains(searchTextValue) ||
                    report.getAttendanceNote().toLowerCase().contains(searchTextValue) ||
                    report.getRemarks().toLowerCase().contains(searchTextValue)) {
                tableview.getItems().add(report);
            }
        }
    }

    @javafx.fxml.FXML
    public void clearButton(ActionEvent actionEvent) {
        tableview.getItems().clear();
        tableview.getItems().addAll(generateReportList);
    }

    @javafx.fxml.FXML
    public void generateReportButton(ActionEvent actionEvent) {
        if (employeeIDCombo.getValue() == null || remarksTextArea.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        LocalDate date = LocalDate.now();
        generateReport = new GenerateReport(attendanceNote, date, employeeIDCombo.getValue(), name, remarksTextArea.getText(), shift);
        generateReportList.add(generateReport);
        tableview.getItems().addAll(generateReportList);

        employeeIDCombo.setValue(null);
        remarksTextArea.clear();
    }
}