package org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker.ModelClass;

import java.io.Serializable;

public class RecordShiftAttendanceActivitiesModelClass implements Serializable {
    private String EmployeeID,EmployeeName,Shift,AttendanceNote;

    public RecordShiftAttendanceActivitiesModelClass(String attendanceNote, String employeeID, String employeeName, String shift) {
        AttendanceNote = attendanceNote;
        EmployeeID = employeeID;
        EmployeeName = employeeName;
        Shift = shift;
    }

    public String getAttendanceNote() {
        return AttendanceNote;
    }

    public void setAttendanceNote(String attendanceNote) {
        AttendanceNote = attendanceNote;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getShift() {
        return Shift;
    }

    public void setShift(String shift) {
        Shift = shift;
    }
}
