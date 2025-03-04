package com.example.spacego.modal.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AgencyType {
    @SerializedName("name")
    @Expose
    private String name;

    public String getAgencyTypeName() {
        return name;
    }

    public void setAgencyTypeName(String name) {
        this.name = name;
    }
}
