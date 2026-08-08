package org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator.ModelClass;

import java.time.LocalDate;
import java.util.Date;

public class MaintanenceEquipmentModelClass {
    private String EquipmentId, EquipmentName, EquipmentType, EquipmentStatus;
    private LocalDate LastmaintananceDate;

    public MaintanenceEquipmentModelClass(String equipmentId, String equipmentName, String equipmentStatus, String equipmentType, LocalDate lastmaintananceDate) {
        EquipmentId = equipmentId;
        EquipmentName = equipmentName;
        EquipmentStatus = equipmentStatus;
        EquipmentType = equipmentType;
        LastmaintananceDate = lastmaintananceDate;
    }

    public String getEquipmentId() {
        return EquipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        EquipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return EquipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        EquipmentName = equipmentName;
    }

    public String getEquipmentStatus() {
        return EquipmentStatus;
    }

    public void setEquipmentStatus(String equipmentStatus) {
        EquipmentStatus = equipmentStatus;
    }

    public String getEquipmentType() {
        return EquipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        EquipmentType = equipmentType;
    }

    public LocalDate getLastmaintananceDate() {
        return LastmaintananceDate;
    }

    public void setLastmaintananceDate(LocalDate lastmaintananceDate) {
        LastmaintananceDate = lastmaintananceDate;
    }
}



