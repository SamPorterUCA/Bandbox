package org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator.ModelClass;

import java.io.Serializable;

public class RegisterNewSupplierInformationModelClass implements Serializable {
    private String SupplierID, SupplierName, PhoneNumber,Address,Description,SupplyType,Category;

    public RegisterNewSupplierInformationModelClass(String address, String category, String description, String phoneNumber, String supplierID, String supplierName, String supplyType) {
        Address = address;
        Category = category;
        Description = description;
        PhoneNumber = phoneNumber;
        SupplierID = supplierID;
        SupplierName = supplierName;
        SupplyType = supplyType;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(String supplierID) {
        SupplierID = supplierID;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String supplierName) {
        SupplierName = supplierName;
    }

    public String getSupplyType() {
        return SupplyType;
    }

    public void setSupplyType(String supplyType) {
        SupplyType = supplyType;
    }
}
