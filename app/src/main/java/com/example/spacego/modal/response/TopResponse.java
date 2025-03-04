package com.example.spacego.modal.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;


public class TopResponse {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private ImageResponse image;
    @SerializedName("info_url")
    @Expose
    private String infoUrl;
    @SerializedName("wiki_url")
    @Expose
    private String wikiUrl;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("agencies")
    @Expose
    private List<Agency> agencies;
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("end_date")
    @Expose
    private String endDate;
    @SerializedName("type")
    @Expose
    private TypeRes type;


    public Integer getResId() {
        return id;
    }

    public String getMsnName() {
        return name;
    }

    public void setMsnName(String name) {
        this.name = name;
    }

    public ImageResponse getImage() {
        return image;
    }

    public void setImage(ImageResponse image) {
        this.image = image;
    }


    public String getInfoUrl() {
        return infoUrl;
    }

    public void setInfoUrl(String infoUrl) {
        this.infoUrl = infoUrl;
    }

    public String getWikiUrl() {
        return wikiUrl;
    }

    public void setWikiUrl(String wikiUrl) {
        this.wikiUrl = wikiUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Agency> getAgencies() {
        return agencies;
    }

    public void setAgencies(List<Agency> agencies) {
        this.agencies = agencies;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public TypeRes getType() {
        return type;
    }

    public void setType(TypeRes type) {
        this.type = type;
    }
}
