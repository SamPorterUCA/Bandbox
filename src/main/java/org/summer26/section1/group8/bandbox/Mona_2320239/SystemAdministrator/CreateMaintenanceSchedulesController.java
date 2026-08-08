package org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator.ModelClass.CreateMaintanenceModelCalss;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CreateMaintenanceSchedulesController
{
    @javafx.fxml.FXML
    private TextField equipmentNameText;
    @javafx.fxml.FXML
    private ComboBox<String> maintanencepriorityCombobox;
    @javafx.fxml.FXML
    private DatePicker maintanenceDateDatepicker;
    @javafx.fxml.FXML
    private TextField maintanencetypeText;
    @javafx.fxml.FXML
    private TextArea descriptionTextArea;

    CreateMaintanenceModelCalss createMaintanenceModelCalss;
    ArrayList<CreateMaintanenceModelCalss> createMaintanenceModelCalssesList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        maintanencepriorityCombobox.getItems().addAll("High", "Medium", "Low");
    }

    @javafx.fxml.FXML
    public void makeScheduleButton(ActionEvent actionEvent) {
        if (maintanenceDateDatepicker.getValue() == null || descriptionTextArea.getText().isEmpty() || equipmentNameText.getText().isEmpty() || maintanencepriorityCombobox.getValue() == null || maintanencetypeText.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields before making a schedule.");
            alert.showAndWait();
            return;
        }

        createMaintanenceModelCalss = new CreateMaintanenceModelCalss(
                maintanenceDateDatepicker.getValue(),
                descriptionTextArea.getText(),
                equipmentNameText.getText(),
                maintanencepriorityCombobox.getValue(),
                maintanencetypeText.getText()
        );
        createMaintanenceModelCalssesList.add(createMaintanenceModelCalss);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("CreateSchedules.bin"))) {
            oos.writeObject(createMaintanenceModelCalssesList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        maintanencepriorityCombobox.setValue(null);
        maintanenceDateDatepicker.setValue(null);
        descriptionTextArea.clear();
        equipmentNameText.clear();
        maintanencetypeText.clear();
    }
}