package com.example.sumankhatiwada.firstapp.day3.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sumankhatiwada on 4/7/18.
 */

public class ElectronicItem implements Parcelable{

    private String electronicItemName;
    private String electronicItemDetails;
    private int electronicItemPhoto;

    public ElectronicItem(String electronicItemName, String electronicItemDetails, int electronicItemPhoto) {
        this.electronicItemName = electronicItemName;
        this.electronicItemDetails = electronicItemDetails;
        this.electronicItemPhoto = electronicItemPhoto;
    }

    protected ElectronicItem(Parcel in) {
        electronicItemName = in.readString();
        electronicItemDetails = in.readString();
        electronicItemPhoto = in.readInt();
    }

    public static final Creator<ElectronicItem> CREATOR = new Creator<ElectronicItem>() {
        @Override
        public ElectronicItem createFromParcel(Parcel in) {
            return new ElectronicItem(in);
        }

        @Override
        public ElectronicItem[] newArray(int size) {
            return new ElectronicItem[size];
        }
    };

    public String getElectronicItemName() {
        return electronicItemName;
    }

    public void setElectronicItemName(String electronicItemName) {
        this.electronicItemName = electronicItemName;
    }

    public String getElectronicItemDetails() {
        return electronicItemDetails;
    }

    public void setElectronicItemDetails(String electronicItemDetails) {
        this.electronicItemDetails = electronicItemDetails;
    }

    public int getElectronicItemPhoto() {
        return electronicItemPhoto;
    }

    public void setElectronicItemPhoto(int electronicItemPhoto) {
        this.electronicItemPhoto = electronicItemPhoto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(electronicItemName);
        parcel.writeString(electronicItemDetails);
        parcel.writeInt(electronicItemPhoto);
    }
}
