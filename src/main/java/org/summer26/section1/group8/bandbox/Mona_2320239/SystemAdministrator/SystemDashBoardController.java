package org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import org.summer26.section1.group8.bandbox.HelloApplication;

import java.io.IOException;

public class SystemDashBoardController
{
    @javafx.fxml.FXML
    private BorderPane borderPane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void AssignBranch(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/summer26/section1/group8/bandbox/Mona_2320239_FXML/SystemAdministrator/AssignEmployeestoBranches.fxml"));
            borderPane.setCenter(fxmlLoader.load());
        } catch (IOException e) {}
    }

    @javafx.fxml.FXML
    public void MaintenanceSchedules(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/summer26/section1/group8/bandbox/Mona_2320239_FXML/SystemAdministrator/CreateMaintenanceSchedules.fxml"));
            borderPane.setCenter(fxmlLoader.load());
        } catch (IOException e) {}
    }

    @javafx.fxml.FXML
    public void SupplierInformation(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/summer26/section1/group8/bandbox/Mona_2320239_FXML/SystemAdministrator/RegisterNewSupplierInformation.fxml"));
            borderPane.setCenter(fxmlLoader.load());
        } catch (IOException e) {}
    }

    @javafx.fxml.FXML
    public void GenerateReports(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/summer26/section1/group8/bandbox/Mona_2320239_FXML/SystemAdministrator/GenerateOperationalPerformanceReports.fxml"));
            borderPane.setCenter(fxmlLoader.load());
        } catch (IOException e) {}
    }

    @javafx.fxml.FXML
    public void EmployeeRecords(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/summer26/section1/group8/bandbox/Mona_2320239_FXML/SystemAdministrator/ManageEmployeeRecords.fxml"));
            borderPane.setCenter(fxmlLoader.load());
        } catch (IOException e) {}
    }

    @javafx.fxml.FXML
    public void BranchInformation(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/summer26/section1/group8/bandbox/Mona_2320239_FXML/SystemAdministrator/ManageBranchInformation.fxml"));
            borderPane.setCenter(fxmlLoader.load());
        } catch (IOException e) {}
    }

    @javafx.fxml.FXML
    public void ServicePricing(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/summer26/section1/group8/bandbox/Mona_2320239_FXML/SystemAdministrator/MaintainServicePricingRules.fxml"));
            borderPane.setCenter(fxmlLoader.load());
        } catch (IOException e) {}
    }

    @javafx.fxml.FXML
    public void MaintainEquipment(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/summer26/section1/group8/bandbox/Mona_2320239_FXML/SystemAdministrator/MaintainEquipmentLifecycleRecords.fxml"));
            borderPane.setCenter(fxmlLoader.load());
        } catch (IOException e) {}
    }
}