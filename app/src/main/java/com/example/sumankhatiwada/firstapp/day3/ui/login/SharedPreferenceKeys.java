package com.example.sumankhatiwada.firstapp.day3.ui.login;

/**
 * Created by sumankhatiwada on 4/11/18.
 */

public enum SharedPreferenceKeys {

    USER_PASSWORD("userPassword"),
    USER_EMAIL("userEmail");



    private String value;

    SharedPreferenceKeys(String value) {
        this.value = value;
    }

    public String getKey() {
        return value;
    }
}
