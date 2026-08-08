package org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker.ModelClass;

import java.io.Serializable;

public class ReportDamagedorProblematicItemsModelClass implements Serializable {
    private String OrderID,GarmentType,DamageType,SecurityLevel,Description;

    public ReportDamagedorProblematicItemsModelClass(String damageType, String description, String garmentType, String orderID, String securityLevel) {
        DamageType = damageType;
        Description = description;
        GarmentType = garmentType;
        OrderID = orderID;
        SecurityLevel = securityLevel;
    }

    public String getDamageType() {
        return DamageType;
    }

    public void setDamageType(String damageType) {
        DamageType = damageType;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getGarmentType() {
        return GarmentType;
    }

    public void setGarmentType(String garmentType) {
        GarmentType = garmentType;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getSecurityLevel() {
        return SecurityLevel;
    }

    public void setSecurityLevel(String securityLevel) {
        SecurityLevel = securityLevel;
    }
}
