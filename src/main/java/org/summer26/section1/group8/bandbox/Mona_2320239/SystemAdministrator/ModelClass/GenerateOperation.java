package org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator.ModelClass;

import java.time.LocalDate;

public class GenerateOperation {
    private String employeeID, department,performancePoint;
    private LocalDate reportPeriod;

    public GenerateOperation(String department, String employeeID, String performancePoint, LocalDate reportPeriod) {
        this.department = department;
        this.employeeID = employeeID;
        this.performancePoint = performancePoint;
        this.reportPeriod = reportPeriod;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getPerformancePoint() {
        return performancePoint;
    }

    public void setPerformancePoint(String performancePoint) {
        this.performancePoint = performancePoint;
    }

    public LocalDate getReportPeriod() {
        return reportPeriod;
    }

    public void setReportPeriod(LocalDate reportPeriod) {
        this.reportPeriod = reportPeriod;
    }
}
