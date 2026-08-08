package org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker.ModelClass;

public class AssignCleaningMethodtoEachOrderModelClass {
    private String OrderID,CustomerName,CleaningMethod,Status;

    public AssignCleaningMethodtoEachOrderModelClass(String cleaningMethod, String customerName, String orderID, String status) {
        CleaningMethod = cleaningMethod;
        CustomerName = customerName;
        OrderID = orderID;
        Status = status;
    }

    public String getCleaningMethod() {
        return CleaningMethod;
    }

    public void setCleaningMethod(String cleaningMethod) {
        CleaningMethod = cleaningMethod;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
