package org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator.ModelClass.MaintainServicePricing;

public class MaintainServicePricingRulesController
{
    @javafx.fxml.FXML
    private TextField hoursText;
    @javafx.fxml.FXML
    private ComboBox<String> statusCombo;
    @javafx.fxml.FXML
    private DatePicker datePicker;
    @javafx.fxml.FXML
    private TextArea descriptionTextArea;
    @javafx.fxml.FXML
    private TextField perHoursRateText;
    @javafx.fxml.FXML
    private ComboBox<String> serviceTypeCombo;

    @javafx.fxml.FXML
    public void initialize() {
        statusCombo.getItems().addAll("Active", "Inactive");
        serviceTypeCombo.getItems().addAll("Standard Cleaning", "Deep Cleaning", "Move-In/Move-Out Cleaning", "Post-Construction Cleaning");
    }

    @javafx.fxml.FXML
    public void updateServiceButtn(ActionEvent actionEvent) {
        if (hoursText.getText().isEmpty() || perHoursRateText.getText().isEmpty() || descriptionTextArea.getText().isEmpty() || statusCombo.getValue() == null || serviceTypeCombo.getValue() == null || datePicker.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Missing Information");
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        MaintainServicePricing servicePricing = new MaintainServicePricing(datePicker.getValue(), descriptionTextArea.getText(),hoursText.getText(), perHoursRateText.getText(), serviceTypeCombo.getValue(), statusCombo.getValue());

        datePicker.setValue(null);
        descriptionTextArea.clear();
        hoursText.clear();
        perHoursRateText.clear();
        statusCombo.setValue(null);
    }
}