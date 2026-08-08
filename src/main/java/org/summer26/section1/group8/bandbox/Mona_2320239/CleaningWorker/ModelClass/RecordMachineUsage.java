package org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker.ModelClass;

public class RecordMachineUsage {
    private String machineID, machineType, usageDuration, remarks;

    public RecordMachineUsage(String machineID, String machineType, String remarks, String usageDuration) {
        this.machineID = machineID;
        this.machineType = machineType;
        this.remarks = remarks;
        this.usageDuration = usageDuration;
    }

    public String getMachineID() {
        return machineID;
    }

    public void setMachineID(String machineID) {
        this.machineID = machineID;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getUsageDuration() {
        return usageDuration;
    }

    public void setUsageDuration(String usageDuration) {
        this.usageDuration = usageDuration;
    }
}
