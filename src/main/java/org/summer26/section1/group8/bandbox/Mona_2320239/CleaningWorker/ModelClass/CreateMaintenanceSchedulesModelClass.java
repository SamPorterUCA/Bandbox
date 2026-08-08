package org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker.ModelClass;

import java.time.LocalDate;

public class CreateMaintenanceSchedulesModelClass {
    private String ComplaintID,ResolutionType,ResolutionNote;
    private LocalDate ComplaintDate;

    public CreateMaintenanceSchedulesModelClass(LocalDate complaintDate, String complaintID, String resolutionNote, String resolutionType) {
        ComplaintDate = complaintDate;
        ComplaintID = complaintID;
        ResolutionNote = resolutionNote;
        ResolutionType = resolutionType;
    }

    public LocalDate getComplaintDate() {
        return ComplaintDate;
    }

    public void setComplaintDate(LocalDate complaintDate) {
        ComplaintDate = complaintDate;
    }

    public String getComplaintID() {
        return ComplaintID;
    }

    public void setComplaintID(String complaintID) {
        ComplaintID = complaintID;
    }

    public String getResolutionNote() {
        return ResolutionNote;
    }

    public void setResolutionNote(String resolutionNote) {
        ResolutionNote = resolutionNote;
    }

    public String getResolutionType() {
        return ResolutionType;
    }

    public void setResolutionType(String resolutionType) {
        ResolutionType = resolutionType;
    }
}
