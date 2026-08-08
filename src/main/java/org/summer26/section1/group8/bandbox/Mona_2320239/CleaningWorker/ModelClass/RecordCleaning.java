package org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker.ModelClass;

public class RecordCleaning {
    private String batchID, cleaningType, remarks, noofItems;

    public RecordCleaning(String batchID, String cleaningType, String noofItems, String remarks) {
        this.batchID = batchID;
        this.cleaningType = cleaningType;
        this.noofItems = noofItems;
        this.remarks = remarks;
    }

    public String getBatchID() {
        return batchID;
    }

    public void setBatchID(String batchID) {
        this.batchID = batchID;
    }

    public String getCleaningType() {
        return cleaningType;
    }

    public void setCleaningType(String cleaningType) {
        this.cleaningType = cleaningType;
    }

    public String getNoofItems() {
        return noofItems;
    }

    public void setNoofItems(String noofItems) {
        this.noofItems = noofItems;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
