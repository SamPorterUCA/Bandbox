package org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator.ModelClass;


import java.io.Serializable;

public class ManageBranchInformationModelClass implements Serializable {
    private String BranchID,BranchName,BranchLocation,BranchManager,Status;

    public ManageBranchInformationModelClass(String branchID, String branchLocation, String branchManager, String branchName, String status) {
        BranchID = branchID;
        BranchLocation = branchLocation;
        BranchManager = branchManager;
        BranchName = branchName;
        Status = status;
    }

    public String getBranchID() {
        return BranchID;
    }

    public void setBranchID(String branchID) {
        BranchID = branchID;
    }

    public String getBranchLocation() {
        return BranchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        BranchLocation = branchLocation;
    }

    public String getBranchManager() {
        return BranchManager;
    }

    public void setBranchManager(String branchManager) {
        BranchManager = branchManager;
    }

    public String getBranchName() {
        return BranchName;
    }

    public void setBranchName(String branchName) {
        BranchName = branchName;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
