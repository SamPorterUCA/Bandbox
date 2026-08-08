package org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator.ModelClass;

import java.io.Serializable;
import java.time.LocalDate;

public class CreateMaintanenceModelCalss implements Serializable {
    private String equipmentName;
    private String maintanenceType;
    private String maintanencePriority;
    private LocalDate date;
    private String description;

    public CreateMaintanenceModelCalss(LocalDate date, String description, String equipmentName, String maintanencePriority, String maintanenceType) {
        this.date = date;
        this.description = description;
        this.equipmentName = equipmentName;
        this.maintanencePriority = maintanencePriority;
        this.maintanenceType = maintanenceType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getMaintanencePriority() {
        return maintanencePriority;
    }

    public void setMaintanencePriority(String maintanencePriority) {
        this.maintanencePriority = maintanencePriority;
    }

    public String getMaintanenceType() {
        return maintanenceType;
    }

    public void setMaintanenceType(String maintanenceType) {
        this.maintanenceType = maintanenceType;
    }
}
