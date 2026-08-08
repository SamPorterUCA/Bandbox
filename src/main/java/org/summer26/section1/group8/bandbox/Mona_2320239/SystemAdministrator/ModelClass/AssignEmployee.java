package org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator.ModelClass;

public class AssignEmployee {
    private String EmployeeId,Employeename,department, designation, status, email,phone,branchName;

    public AssignEmployee(String branchName, String department, String designation, String email, String employeeId, String employeename, String phone, String status) {
        this.branchName = branchName;
        this.department = department;
        this.designation = designation;
        this.email = email;
        EmployeeId = employeeId;
        Employeename = employeename;
        this.phone = phone;
        this.status = status;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(String employeeId) {
        EmployeeId = employeeId;
    }

    public String getEmployeename() {
        return Employeename;
    }

    public void setEmployeename(String employeename) {
        Employeename = employeename;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
