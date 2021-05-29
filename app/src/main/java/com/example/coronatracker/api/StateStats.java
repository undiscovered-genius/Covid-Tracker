package com.example.coronatracker.api;

import java.util.List;
import java.util.Map;

public class StateStats {
    private List<StateStats> statewise;
    private String state;
    private String active;
    private String confirmed;
    private String deaths;
    private String recovered;
    private String deltaconfirmed;
    private String deltarecovered;
    private String deltadeaths;
    private String lastupdatedtime;

    public StateStats(List<StateStats> statewise, String state, String active, String confirmed, String deaths, String recovered, String deltaconfirmed, String deltarecovered, String deltadeaths, String lastupdatedtime){
        this.statewise = statewise;
        this.state = state;
        this.active = active;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
        this.deltaconfirmed = deltaconfirmed;
        this.deltarecovered = deltarecovered;
        this.deltadeaths = deltadeaths;
        this.lastupdatedtime = lastupdatedtime;
    }

    public List<StateStats> getStatewise() {
        return statewise;
    }

    public void setStatewise(List<StateStats> statewise) {
        this.statewise = statewise;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getDeltaconfirmed() {
        return deltaconfirmed;
    }

    public void setDeltaconfirmed(String deltaconfirmed) {
        this.deltaconfirmed = deltaconfirmed;
    }

    public String getDeltarecovered() {
        return deltarecovered;
    }

    public void setDeltarecovered(String deltarecovered) {
        this.deltarecovered = deltarecovered;
    }

    public String getDeltadeaths() {
        return deltadeaths;
    }

    public void setDeltadeaths(String deltadeaths) {
        this.deltadeaths = deltadeaths;
    }

    public String getLastupdatedtime() {
        return lastupdatedtime;
    }

    public void setLastupdatedtime(String lastupdatedtime) {
        this.lastupdatedtime = lastupdatedtime;
    }
}
