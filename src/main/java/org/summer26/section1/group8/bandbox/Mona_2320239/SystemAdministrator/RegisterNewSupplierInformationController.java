package org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator.ModelClass.RegisterNewSupplierInformationModelClass;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class RegisterNewSupplierInformationController
{
    @javafx.fxml.FXML
    private ComboBox<String> supplyTypeCombo;
    @javafx.fxml.FXML
    private ComboBox<String> categoryCombo;
    @javafx.fxml.FXML
    private TextField supplierIDText;
    @javafx.fxml.FXML
    private TextField addressText;
    @javafx.fxml.FXML
    private TextArea descriptionTextarea;
    @javafx.fxml.FXML
    private TextField phoneNumberText;
    @javafx.fxml.FXML
    private TextField supplierNameText;

    @javafx.fxml.FXML
    public void initialize() {

        supplyTypeCombo.getItems().addAll("Cleaning Chemicals","Cleaning Equipment","Packaging Materials");
        categoryCombo.getItems().addAll("Local Supplier","Wholesale Supplier","International Supplier");

    }

    @javafx.fxml.FXML
    public void registerSupplierButton(ActionEvent actionEvent) {
        if (supplierIDText.getText().isEmpty() || supplierNameText.getText().isEmpty() || addressText.getText().isEmpty() || phoneNumberText.getText().isEmpty() || descriptionTextarea.getText().isEmpty() || supplyTypeCombo.getValue() == null || categoryCombo.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Missing Information");
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        RegisterNewSupplierInformationModelClass registerNewSupplierInformationModelClass = new RegisterNewSupplierInformationModelClass(
                addressText.getText(),
                categoryCombo.getValue(),
                descriptionTextarea.getText(),
                phoneNumberText.getText(),
                supplierIDText.getText(),
                supplierNameText.getText(),
                supplyTypeCombo.getValue()
        );

        ArrayList<RegisterNewSupplierInformationModelClass> supplierList = new ArrayList<>();

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("NewSupplier.bin"))) {
            oos.writeObject(supplierList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        addressText.clear();
        categoryCombo.setValue(null);
        descriptionTextarea.clear();
        phoneNumberText.clear();
        supplierIDText.clear();
        supplierNameText.clear();
        supplyTypeCombo.setValue(null);
    }
}