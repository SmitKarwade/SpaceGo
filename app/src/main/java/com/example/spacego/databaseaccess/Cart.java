package com.example.spacego.databaseaccess;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Cart implements Parcelable {

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

    protected Cart(Parcel in) {
        if (in.readInt() == 0) {
            cartId = null;
        } else {
            cartId = in.readInt();
        }
        if (in.readByte() == 0) {
            missionId = null;
        } else {
            missionId = in.readInt();
        }
        missionName = in.readString();
        missionOrg = in.readString();
        missionSummary = in.readString();
        if (in.readByte() == 0) {
            amountRS = null;
        } else {
            amountRS = in.readFloat();
        }
    }

    public static final Creator<Cart> CREATOR = new Creator<Cart>() {
        @Override
        public Cart createFromParcel(Parcel in) {
            return new Cart(in);
        }

        @Override
        public Cart[] newArray(int size) {
            return new Cart[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        if (cartId == null) {
            dest.writeInt(0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(cartId);
        }
        if (missionId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(missionId);
        }
        dest.writeString(missionName);
        dest.writeString(missionOrg);
        dest.writeString(missionSummary);
        if (amountRS == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(amountRS);
        }
    }
}

