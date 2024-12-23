package com.example.spacego.modal;

import com.example.spacego.databaseaccess.Space_Data;

import java.util.ArrayList;
import java.util.List;

public class OrgWise {
    private String org;
    private ArrayList<Space_Data> listMisssion;

    public OrgWise(String org, ArrayList<Space_Data> listMisssion) {
        this.org = org;
        this.listMisssion = listMisssion;
    }

    public OrgWise() {
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public List<Space_Data> getListMisssion() {
        return listMisssion;
    }

    public void setListMisssion(ArrayList<Space_Data> listMisssion) {
        this.listMisssion = listMisssion;
    }
}
