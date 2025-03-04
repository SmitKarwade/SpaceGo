package com.example.spacego.modal.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Agency {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("type")
    @Expose
    private AgencyType type;


    public String getAgencyName() {
        return name;
    }

    public void setAgencyName(String name) {
        this.name = name;
    }


    public AgencyType getType() {
        return type;
    }

    public void setType(AgencyType type) {
        this.type = type;
    }
}
