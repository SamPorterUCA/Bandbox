package org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator.ModelClass;

import java.time.LocalDate;

public class MaintainServicePricing {
    private String serviceType, status, description, hours, perHoursRate;
    private LocalDate date;

    public MaintainServicePricing(LocalDate date, String description, String hours, String perHoursRate, String serviceType, String status) {
        this.date = date;
        this.description = description;
        this.hours = hours;
        this.perHoursRate = perHoursRate;
        this.serviceType = serviceType;
        this.status = status;
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

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getPerHoursRate() {
        return perHoursRate;
    }

    public void setPerHoursRate(String perHoursRate) {
        this.perHoursRate = perHoursRate;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
