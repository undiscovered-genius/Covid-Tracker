package com.example.coronatracker.api;

import java.util.List;

public class StateStats {
    private List<StateStats> statewise;
    private List<StateStats> tested;
    private String state;
    private String active;
    private String confirmed;
    private String deaths;
    private String recovered;
    private String deltaconfirmed;
    private String deltarecovered;
    private String deltadeaths;
    private String lastupdatedtime;
    private String updatetimestamp;
    private String totalindividualsregistered;
    private String totalindividualsvaccinated;
    private String firstdoseadministered;
    private String seconddoseadministered;
    private String frontlineworkersvaccinated1stdose;
    private String frontlineworkersvaccinated2nddose; //yha se constructor mai nhi hai
    private String healthcareworkersvaccinated1stdose;
    private String healthcareworkersvaccinated2nddose;
    private String over45years1stdose;
    private String over45years2nddose;
    private String over60years1stdose;
    private String over60years2nddose;
    private String testedasof;

    public StateStats(List<StateStats> statewise, List<StateStats> tested, String state, String active, String confirmed, String deaths, String recovered, String deltaconfirmed, String deltarecovered, String deltadeaths, String lastupdatedtime, String updatetimestamp, String totalindividualsregistered, String totalindividualsvaccinated, String firstdoseadministered, String seconddoseadministered, String frontlineworkersvaccinated1stdose){
        this.statewise = statewise;
        this.tested = tested;
        this.state = state;
        this.active = active;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
        this.deltaconfirmed = deltaconfirmed;
        this.deltarecovered = deltarecovered;
        this.deltadeaths = deltadeaths;
        this.lastupdatedtime = lastupdatedtime;
        this.updatetimestamp = updatetimestamp;
        this.totalindividualsregistered = totalindividualsregistered;
        this.totalindividualsvaccinated = totalindividualsvaccinated;
        this.firstdoseadministered = firstdoseadministered;
        this.seconddoseadministered = seconddoseadministered;
        this.frontlineworkersvaccinated1stdose = frontlineworkersvaccinated1stdose;
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

    public List<StateStats> getTested() {
        return tested;
    }

    public void setTested(List<StateStats> tested) {
        this.tested = tested;
    }

    public String getUpdatetimestamp() {
        return updatetimestamp;
    }

    public void setUpdatetimestamp(String updatetimestamp) {
        this.updatetimestamp = updatetimestamp;
    }

    public String getTotalindividualsregistered() {
        return totalindividualsregistered;
    }

    public void setTotalindividualsregistered(String totalindividualsregistered) {
        this.totalindividualsregistered = totalindividualsregistered;
    }

    public String getTotalindividualsvaccinated() {
        return totalindividualsvaccinated;
    }

    public void setTotalindividualsvaccinated(String totalindividualsvaccinated) {
        this.totalindividualsvaccinated = totalindividualsvaccinated;
    }

    public String getFirstdoseadministered() {
        return firstdoseadministered;
    }

    public void setFirstdoseadministered(String firstdoseadministered) {
        this.firstdoseadministered = firstdoseadministered;
    }

    public String getSeconddoseadministered() {
        return seconddoseadministered;
    }

    public void setSeconddoseadministered(String seconddoseadministered) {
        this.seconddoseadministered = seconddoseadministered;
    }

    public String getFrontlineworkersvaccinated1stdose() {
        return frontlineworkersvaccinated1stdose;
    }

    public void setFrontlineworkersvaccinated1stdose(String frontlineworkersvaccinated1stdose) {
        this.frontlineworkersvaccinated1stdose = frontlineworkersvaccinated1stdose;
    }

    public String getFrontlineworkersvaccinated2nddose() {
        return frontlineworkersvaccinated2nddose;
    }

    public void setFrontlineworkersvaccinated2nddose(String frontlineworkersvaccinated2nddose) {
        this.frontlineworkersvaccinated2nddose = frontlineworkersvaccinated2nddose;
    }

    public String getHealthcareworkersvaccinated1stdose() {
        return healthcareworkersvaccinated1stdose;
    }

    public void setHealthcareworkersvaccinated1stdose(String healthcareworkersvaccinated1stdose) {
        this.healthcareworkersvaccinated1stdose = healthcareworkersvaccinated1stdose;
    }

    public String getHealthcareworkersvaccinated2nddose() {
        return healthcareworkersvaccinated2nddose;
    }

    public void setHealthcareworkersvaccinated2nddose(String healthcareworkersvaccinated2nddose) {
        this.healthcareworkersvaccinated2nddose = healthcareworkersvaccinated2nddose;
    }

    public String getOver45years1stdose() {
        return over45years1stdose;
    }

    public void setOver45years1stdose(String over45years1stdose) {
        this.over45years1stdose = over45years1stdose;
    }

    public String getOver45years2nddose() {
        return over45years2nddose;
    }

    public void setOver45years2nddose(String over45years2nddose) {
        this.over45years2nddose = over45years2nddose;
    }

    public String getOver60years1stdose() {
        return over60years1stdose;
    }

    public void setOver60years1stdose(String over60years1stdose) {
        this.over60years1stdose = over60years1stdose;
    }

    public String getOver60years2nddose() {
        return over60years2nddose;
    }

    public void setOver60years2nddose(String over60years2nddose) {
        this.over60years2nddose = over60years2nddose;
    }

    public String getTestedasof() {
        return testedasof;
    }

    public void setTestedasof(String testedasof) {
        this.testedasof = testedasof;
    }
}
