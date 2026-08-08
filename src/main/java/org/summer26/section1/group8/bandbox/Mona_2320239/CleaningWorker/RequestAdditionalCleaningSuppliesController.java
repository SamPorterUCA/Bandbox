package org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker.ModelClass.RequestAdditionalCleaningSuppliesModelClass;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class RequestAdditionalCleaningSuppliesController
{
    @javafx.fxml.FXML
    private TextField supplyItemText;
    @javafx.fxml.FXML
    private TextField orderIDText;
    @javafx.fxml.FXML
    private ComboBox<String> quantityCombo;
    @javafx.fxml.FXML
    private TextArea descriptionTextArea;

    RequestAdditionalCleaningSuppliesModelClass requestAdditionalCleaningSuppliesModelClass;
    ArrayList<RequestAdditionalCleaningSuppliesModelClass> requestAdditionalCleaningSuppliesModelClassArrayList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        quantityCombo.getItems().addAll("1", "2", "3", "4", "5", "10", "15", "20");
    }

    @javafx.fxml.FXML
    public void submitRequestButton(ActionEvent actionEvent) {
        if (supplyItemText.getText().isEmpty() || orderIDText.getText().isEmpty() || quantityCombo.getValue() == null || descriptionTextArea.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Missing Information");
            alert.setContentText("Please fill in all fields before submitting the request.");
            alert.showAndWait();
            return;
        }

        requestAdditionalCleaningSuppliesModelClass = new RequestAdditionalCleaningSuppliesModelClass(
                descriptionTextArea.getText(),
                orderIDText.getText(),
                quantityCombo.getValue(),
                supplyItemText.getText()
        );
        requestAdditionalCleaningSuppliesModelClassArrayList.add(requestAdditionalCleaningSuppliesModelClass);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("CleaningSupplies.bin",true))) {
            oos.writeObject(requestAdditionalCleaningSuppliesModelClassArrayList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        descriptionTextArea.clear();
        orderIDText.clear();
        quantityCombo.setValue(null);
        supplyItemText.clear();
    }
}