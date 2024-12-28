package com.example.spacego.databaseaccess;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Space_Data implements Parcelable {

    private Integer id;
    private String missionName;
    private String organization;
    private String summary;private String description;
    private String launchDate;
    private String vehicle;
    private String launchSite;
    private Integer massKg;
    private String fundingAgency;
    private String time;
    private String publicAvailability;

    public Space_Data(String missionName, String organization, String summary, String description, String launchDate, String vehicle, String launchSite, Integer massKg, String fundingAgency, String time, String publicAvailability) {
        this.missionName = missionName;
        this.organization = organization;
        this.summary = summary;
        this.description = description;
        this.launchDate = launchDate;
        this.vehicle = vehicle;
        this.launchSite = launchSite;
        this.massKg = massKg;
        this.fundingAgency = fundingAgency;
        this.time = time;
        this.publicAvailability = publicAvailability;
    }

    public Space_Data() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getLaunchSite() {
        return launchSite;
    }

    public void setLaunchSite(String launchSite) {
        this.launchSite = launchSite;
    }

    public Integer getMassKg() {
        return massKg;
    }

    public void setMassKg(Integer massKg) {
        this.massKg = massKg;
    }

    public String getFundingAgency() {
        return fundingAgency;
    }

    public void setFundingAgency(String fundingAgency) {
        this.fundingAgency = fundingAgency;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPublicAvailability() {
        return publicAvailability;
    }

    public void setPublicAvailability(String publicAvailability) {
        this.publicAvailability = publicAvailability;
    }

    protected Space_Data(Parcel in) {
        // Read id
        if (in.readInt() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        missionName = in.readString();
        organization = in.readString();
        summary = in.readString();
        description = in.readString();
        launchDate = in.readString();
        vehicle = in.readString();
        launchSite = in.readString();
        // Read massKg
        if (in.readInt() == 0) {
            massKg = null;
        } else {
            massKg = in.readInt();
        }
        fundingAgency = in.readString();
        publicAvailability = in.readString();
        time = in.readString();
    }

    public static final Creator<Space_Data> CREATOR = new Creator<Space_Data>() {
        @Override
        public Space_Data createFromParcel(Parcel source) {
            return new Space_Data(source);
        }

        @Override
        public Space_Data[] newArray(int size) {
            return new Space_Data[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {// Write id
        if (id == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(id);
        }
        dest.writeString(missionName);
        dest.writeString(organization);
        dest.writeString(summary);
        dest.writeString(description);
        dest.writeString(launchDate);
        dest.writeString(vehicle);
        dest.writeString(launchSite);
        // Write massKg
        if (massKg == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(massKg);
        }
        dest.writeString(fundingAgency);
        dest.writeString(publicAvailability);
        dest.writeString(time);
    }
}