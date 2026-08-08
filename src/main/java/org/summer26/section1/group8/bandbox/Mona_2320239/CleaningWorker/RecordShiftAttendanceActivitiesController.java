package org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker.ModelClass.RecordShiftAttendanceActivitiesModelClass;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class RecordShiftAttendanceActivitiesController
{
    @javafx.fxml.FXML
    private TextArea attendanceNoteTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> shiftCombo;
    @javafx.fxml.FXML
    private TextField employeeIDText;
    @javafx.fxml.FXML
    private TextField employeeNameText;

    RecordShiftAttendanceActivitiesModelClass recordShiftAttendanceActivitiesModelClass;
    ArrayList<RecordShiftAttendanceActivitiesModelClass> recordShiftAttendanceActivitiesModelClassArrayList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        shiftCombo.getItems().addAll("Morning", "Afternoon", "Evening", "Night");
    }

    @javafx.fxml.FXML
    public void saveRecordButton(ActionEvent actionEvent) {
        if (attendanceNoteTextArea.getText().isEmpty() || employeeIDText.getText().isEmpty() || employeeNameText.getText().isEmpty() || shiftCombo.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Missing Information");
            alert.setContentText("Please fill in all fields before saving the record.");
            alert.showAndWait();
            return;
        }
        recordShiftAttendanceActivitiesModelClass = new RecordShiftAttendanceActivitiesModelClass(
                attendanceNoteTextArea.getText(),
                employeeIDText.getText(),
                employeeNameText.getText(),
                shiftCombo.getValue()
        );
        recordShiftAttendanceActivitiesModelClassArrayList.add(recordShiftAttendanceActivitiesModelClass);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ShiftAttendance.bin", true))) {
            oos.writeObject(recordShiftAttendanceActivitiesModelClassArrayList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        attendanceNoteTextArea.clear();
        employeeIDText.clear();
        employeeNameText.clear();
        shiftCombo.setValue(null);
    }
}