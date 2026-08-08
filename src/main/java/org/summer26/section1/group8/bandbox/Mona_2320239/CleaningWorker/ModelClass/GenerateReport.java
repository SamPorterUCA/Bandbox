package org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker.ModelClass;

import java.time.LocalDate;

public class GenerateReport {
    private String employeeID, remarks, attendanceNote, shift, employeeName;
    private LocalDate date;

    public GenerateReport(String attendanceNote, LocalDate date, String employeeID, String employeeName, String remarks, String shift) {
        this.attendanceNote = attendanceNote;
        this.date = date;
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.remarks = remarks;
        this.shift = shift;
    }

    public String getAttendanceNote() {
        return attendanceNote;
    }

    public void setAttendanceNote(String attendanceNote) {
        this.attendanceNote = attendanceNote;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
}
