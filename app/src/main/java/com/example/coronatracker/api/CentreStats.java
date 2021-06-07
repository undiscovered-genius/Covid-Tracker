package com.example.coronatracker.api;

import java.util.List;

public class CentreStats {
    private List<CentreStats> sessions;
    private String name;
    private String date;
    private String fee;
    private String from;
    private String to;
    private String available_capacity;
    private String available_capacity_dose1;
    private String available_capacity_dose2;
    private String vaccine;
    private String min_age_limit;
//    private List<CentreStats> slots;
    private String[] slots;

    public CentreStats(List<CentreStats> sessions, String name, String date, String fee, String from, String to, String available_capacity, String available_capacity_dose1, String available_capacity_dose2, String vaccine, String min_age_limit, String[] slots) {
        this.sessions = sessions;
        this.name = name;
        this.date = date;
        this.fee = fee;
        this.from = from;
        this.to = to;
        this.available_capacity = available_capacity;
        this.available_capacity_dose1 = available_capacity_dose1;
        this.available_capacity_dose2 = available_capacity_dose2;
        this.vaccine = vaccine;
        this.min_age_limit = min_age_limit;
        this.slots = slots;
    }

    public List<CentreStats> getSessions() {
        return sessions;
    }

    public void setSessions(List<CentreStats> sessions) {
        this.sessions = sessions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getAvailable_capacity() {
        return available_capacity;
    }

    public void setAvailable_capacity(String available_capacity) {
        this.available_capacity = available_capacity;
    }

    public String getAvailable_capacity_dose1() {
        return available_capacity_dose1;
    }

    public void setAvailable_capacity_dose1(String available_capacity_dose1) {
        this.available_capacity_dose1 = available_capacity_dose1;
    }

    public String getAvailable_capacity_dose2() {
        return available_capacity_dose2;
    }

    public void setAvailable_capacity_dose2(String available_capacity_dose2) {
        this.available_capacity_dose2 = available_capacity_dose2;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getMin_age_limit() {
        return min_age_limit;
    }

    public void setMin_age_limit(String min_age_limit) {
        this.min_age_limit = min_age_limit;
    }

    public String[] getSlots() {
        return slots;
    }

    public void setSlots(String[] slots) {
        this.slots = slots;
    }

//    public List<CentreStats> getSlots() {
//        return slots;
//    }
//
//    public void setSlots(List<CentreStats> slots) {
//        this.slots = slots;
//    }
}
