package com.example.spacego.modal.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TypeRes {
    @SerializedName("name")
    @Expose
    private String name;


    public String getMsnType() {
        return name;
    }

    public void setMsnType(String name) {
        this.name = name;
    }
}
