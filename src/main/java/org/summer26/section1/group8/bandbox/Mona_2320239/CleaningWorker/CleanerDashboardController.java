package org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import org.summer26.section1.group8.bandbox.HelloApplication;

import java.io.IOException;

public class CleanerDashboardController
{
    @javafx.fxml.FXML
    private BorderPane borderPane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void ReportDamaged(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/summer26/section1/group8/bandbox/Mona_2320239_FXML/CleaningWorker/ReportDamagedorProblematicItems.fxml"));
            borderPane.setCenter(fxmlLoader.load());
        } catch (IOException e) {}
    }

    @javafx.fxml.FXML
    public void MachineInformation(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/summer26/section1/group8/bandbox/Mona_2320239_FXML/CleaningWorker/RecordMachineUsageInformation.fxml"));
            borderPane.setCenter(fxmlLoader.load());
        } catch (IOException e) {}
    }

    @javafx.fxml.FXML
    public void GenerateReports(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/summer26/section1/group8/bandbox/Mona_2320239_FXML/CleaningWorker/GeneratePersonalProductivityReports.fxml"));
            borderPane.setCenter(fxmlLoader.load());
        } catch (IOException e) {}
    }

    @javafx.fxml.FXML
    public void RecordCleaning(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/summer26/section1/group8/bandbox/Mona_2320239_FXML/CleaningWorker/RecordCleaningBatchDetails.fxml"));
            borderPane.setCenter(fxmlLoader.load());
        } catch (IOException e) {}
    }

    @javafx.fxml.FXML
    public void AssignCleaning(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/summer26/section1/group8/bandbox/Mona_2320239_FXML/CleaningWorker/AssignCleaningMethodtoEachOrder.fxml"));
            borderPane.setCenter(fxmlLoader.load());
        } catch (IOException e) {}
    }

    @javafx.fxml.FXML
    public void ShiftAttendance(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/summer26/section1/group8/bandbox/Mona_2320239_FXML/CleaningWorker/RecordShiftAttendanceActivities.fxml"));
            borderPane.setCenter(fxmlLoader.load());
        } catch (IOException e) {}
    }

    @javafx.fxml.FXML
    public void RequestCleaningSupplies(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/summer26/section1/group8/bandbox/Mona_2320239_FXML/CleaningWorker/RequestAdditionalCleaningSupplies.fxml"));
            borderPane.setCenter(fxmlLoader.load());
        } catch (IOException e) {}
    }

    @javafx.fxml.FXML
    public void CustomerComplaint(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/summer26/section1/group8/bandbox/Mona_2320239_FXML/CleaningWorker/CreateCustomerComplaintResolutionRecords.fxml"));
            borderPane.setCenter(fxmlLoader.load());
        } catch (IOException e) {}
    }
}