package org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker.ModelClass.ReportDamagedorProblematicItemsModelClass;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ReportDamagedorProblematicItemsController
{
    @javafx.fxml.FXML
    private RadioButton lowRadio;
    @javafx.fxml.FXML
    private ComboBox<String> garmenttypeCombo;
    @javafx.fxml.FXML
    private ComboBox<String> damageTypeCombo;
    @javafx.fxml.FXML
    private TextField orderIDText;
    @javafx.fxml.FXML
    private RadioButton highRadio;
    @javafx.fxml.FXML
    private TextArea descriptionText;
    @javafx.fxml.FXML
    private RadioButton mdeiumRadio;
    @javafx.fxml.FXML
    private ToggleGroup radio;

    ReportDamagedorProblematicItemsModelClass reportDamagedorProblematicItemsModelClass;
    ArrayList<ReportDamagedorProblematicItemsModelClass> reportDamagedorProblematicItemsModelClassArrayList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        garmenttypeCombo.getItems().addAll("Shirt", "Pants", "Jacket", "Suit");
        damageTypeCombo.getItems().addAll("Missing Button", "Broken Zipper");
    }

    @javafx.fxml.FXML
    public void saveDataButton(ActionEvent actionEvent) {
        if (orderIDText.getText().isEmpty() || descriptionText.getText().isEmpty() || garmenttypeCombo.getValue() == null || damageTypeCombo.getValue() == null || radio.getSelectedToggle() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        String radioValue = ((RadioButton) radio.getSelectedToggle()).getText();
        reportDamagedorProblematicItemsModelClass = new ReportDamagedorProblematicItemsModelClass(damageTypeCombo.getValue(), descriptionText.getText(), garmenttypeCombo.getValue(), orderIDText.getText(), radioValue);
        reportDamagedorProblematicItemsModelClassArrayList.add(reportDamagedorProblematicItemsModelClass);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ReportDamage.bin",true))) {
            oos.writeObject(reportDamagedorProblematicItemsModelClassArrayList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        damageTypeCombo.setValue(null);
        descriptionText.clear();
        garmenttypeCombo.setValue(null);
        orderIDText.clear();
        radio.getToggles().clear();
    }
}