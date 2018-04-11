package com.example.sumankhatiwada.firstapp.day6.problem1.domain;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sumankhatiwada on 4/10/18.
 */

public class WebDomain implements Parcelable {

    private String name;
    private String url;
    private boolean isFavouriteUrl;
   private List<WebDomain> webDomainList = new ArrayList<>();

    public WebDomain() {

    }

    protected WebDomain(Parcel in) {
        name = in.readString();
        url = in.readString();
        isFavouriteUrl = in.readByte() != 0;
        webDomainList = in.createTypedArrayList(WebDomain.CREATOR);
    }

    public static final Creator<WebDomain> CREATOR = new Creator<WebDomain>() {
        @Override
        public WebDomain createFromParcel(Parcel in) {
            return new WebDomain(in);
        }

        @Override
        public WebDomain[] newArray(int size) {
            return new WebDomain[size];
        }
    };

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setFavouriteUrl(boolean favouriteUrl) {
        isFavouriteUrl = favouriteUrl;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public boolean isFavouriteUrl() {
        return isFavouriteUrl;
    }

    public List<WebDomain> getWebDomainList() {

        return webDomainList;
    }


    public void setDefaultWebSites() {
        WebDomain webDomain0 = new WebDomain();
        webDomain0.setName("Google");
        webDomain0.setUrl("https://www.google.com");
        webDomain0.setFavouriteUrl(false);
        addWebsites(webDomain0);
        WebDomain webDomain1 = new WebDomain();
        webDomain1.setName("StackOverflow");
        webDomain1.setUrl("https://www.stackoverflow.com/");
        webDomain1.setFavouriteUrl(false);
        addWebsites(webDomain1);

        WebDomain webDomain2 = new WebDomain();
        webDomain2.setName("YouTube");
        webDomain2.setUrl("https://www.youtube.com/");
        webDomain2.setFavouriteUrl(false);
        addWebsites(webDomain2);

        WebDomain webDomain3 = new WebDomain();
        webDomain3.setName("Facebook");
        webDomain3.setUrl("https://www.facebook.com/");
        webDomain3.setFavouriteUrl(false);
        addWebsites(webDomain3);

        WebDomain webDomain4 = new WebDomain();
        webDomain4.setName("Instagram");
        webDomain4.setUrl("https://www.instagram.com/");
        webDomain4.setFavouriteUrl(false);
        addWebsites(webDomain4);

        WebDomain webDomain5 = new WebDomain();
        webDomain5.setName("GeniusKitchen");
        webDomain5.setUrl("http://www.geniuskitchen.com/");
        webDomain5.setFavouriteUrl(false);
        addWebsites(webDomain5);
    }

    public void addWebsites(WebDomain webDomain) {
        webDomainList.add(webDomain);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(url);
        parcel.writeByte((byte) (isFavouriteUrl ? 1 : 0));
        parcel.writeTypedList(webDomainList);
    }

    public void clearList() {
        webDomainList.clear();
    }
}
