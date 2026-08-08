package org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator.ModelClass.ManageBranchInformationModelClass;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ManageBranchInformationController
{
    @javafx.fxml.FXML
    private TextField branchIDText;
    @javafx.fxml.FXML
    private TableColumn<ManageBranchInformationModelClass, String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<ManageBranchInformationModelClass, String> branchNameCol;
    @javafx.fxml.FXML
    private TableColumn<ManageBranchInformationModelClass, String> branchIDCol;
    @javafx.fxml.FXML
    private TableView<ManageBranchInformationModelClass> tableview;
    @javafx.fxml.FXML
    private TextField branchManagerText;
    @javafx.fxml.FXML
    private TableColumn<ManageBranchInformationModelClass, String> branchManagerCol;
    @javafx.fxml.FXML
    private TextField branchNameText;
    @javafx.fxml.FXML
    private TableColumn<ManageBranchInformationModelClass, String> branchLocationCol;
    @javafx.fxml.FXML
    private TextField branchLocationText;
    @javafx.fxml.FXML
    private ComboBox<String> statusCombo;

    ManageBranchInformationModelClass manageBranchInformation;
    ArrayList<ManageBranchInformationModelClass> manageBranchInformationlist = new ArrayList<>();
    @FXML
    private TextField searchText;

    @javafx.fxml.FXML
    public void initialize() {
        statusCombo.getItems().addAll("Active","Inactive");

        branchIDCol.setCellValueFactory(new PropertyValueFactory<>("BranchID"));
        branchNameCol.setCellValueFactory(new PropertyValueFactory<>("BranchName"));
        branchLocationCol.setCellValueFactory(new PropertyValueFactory<>("BranchLocation"));
        branchManagerCol.setCellValueFactory(new PropertyValueFactory<>("BranchManager"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("Status"));
    }

    @javafx.fxml.FXML
    public void updateStatusButton(ActionEvent actionEvent) {
    }

    @FXML
    public void addnewbranchButton(ActionEvent actionEvent) {
        if (branchIDText.getText().isEmpty() || branchLocationText.getText().isEmpty() || branchManagerText.getText().isEmpty() || branchNameText.getText().isEmpty() || statusCombo.getValue()==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
            return;
        }

        manageBranchInformation =new ManageBranchInformationModelClass(branchIDText.getText(),branchLocationText.getText(),branchManagerText.getText(),branchNameText.getText(),statusCombo.getValue());
        manageBranchInformationlist.add(manageBranchInformation);
        tableview.getItems().addAll(manageBranchInformationlist);

        try (ObjectOutputStream write= new ObjectOutputStream(new FileOutputStream("BranchInformation.bin"))){
            write.writeObject(manageBranchInformation.getBranchID()+","+manageBranchInformation.getBranchLocation()+","+manageBranchInformation.getBranchManager()+","+manageBranchInformation.getBranchName()+","+manageBranchInformation.getStatus()+","+"\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        branchIDText.clear();
        branchLocationText.clear();
        branchManagerText.clear();
        branchNameText.clear();
        statusCombo.setValue(null);
    }

    @FXML
    public void searchButton(ActionEvent actionEvent) {
        tableview.getItems().clear();
        for (ManageBranchInformationModelClass i:manageBranchInformationlist){
            if (i.getStatus().equals(searchText.getText()) || i.getBranchName().equals(searchText.getText()) || i.getBranchManager().equals(searchText.getText()) || i.getBranchLocation().equals(searchText.getText()) || i.getBranchID().equals(searchText.getText())){
                tableview.getItems().add(i);
            }
        }

    }

    @FXML
    public void clearButton(ActionEvent actionEvent) {
        tableview.getItems().clear();
        tableview.getItems().addAll(manageBranchInformationlist);
    }
}