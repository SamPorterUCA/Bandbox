package org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker.ModelClass;

import java.io.Serializable;

public class RequestAdditionalCleaningSuppliesModelClass implements Serializable {
    private String OrderID,SupplyItem,Quantity,Description;

    public RequestAdditionalCleaningSuppliesModelClass(String description, String orderID, String quantity, String supplyItem) {
        Description = description;
        OrderID = orderID;
        Quantity = quantity;
        SupplyItem = supplyItem;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getSupplyItem() {
        return SupplyItem;
    }

    public void setSupplyItem(String supplyItem) {
        SupplyItem = supplyItem;
    }
}
