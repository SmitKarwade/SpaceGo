package com.example.spacego.databaseaccess;


public class Cart {

    private Integer cartId;
    private Integer missionId;
    private String missionName;
    private String missionOrg;
    private String missionSummary;
    private Float amountRS;

    public Cart(Integer missionId, String missionName, String missionOrg, String missionSummary, Float amountRS) {
        this.missionId = missionId;
        this.missionName = missionName;
        this.missionOrg = missionOrg;
        this.missionSummary = missionSummary;
        this.amountRS = amountRS;
    }

    public Cart() {
    }

    public Integer getCartId() {
        return cartId;
    }

    public Integer getMissionId() {
        return missionId;
    }

    public void setMissionId(Integer missionId) {
        this.missionId = missionId;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getMissionOrg() {
        return missionOrg;
    }

    public void setMissionOrg(String missionOrg) {
        this.missionOrg = missionOrg;
    }

    public String getMissionSummary() {
        return missionSummary;
    }

    public void setMissionSummary(String missionSummary) {
        this.missionSummary = missionSummary;
    }

    public Float getAmountRS() {
        return amountRS;
    }

    public void setAmountRS(Float amountRS) {
        this.amountRS = amountRS;
    }
}

