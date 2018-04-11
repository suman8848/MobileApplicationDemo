package com.example.sumankhatiwada.firstapp.day3.ui.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.example.sumankhatiwada.firstapp.R;
import com.example.sumankhatiwada.firstapp.day3.model.Users;

/**
 * Created by sumankhatiwada on 4/11/18.
 */

public class SharedPrefManager {
    private static final String EMPTY_STRING = "";

    SharedPreferences sharedPreferences;

    public void initiateSharedPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);
    }


    /**
     * Method to set string in preferences
     *
     * @param key
     * @param value
     * @return editor commit
     */
    private boolean setStringInPreferences(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    /**
     * Method to get string from preferences
     *
     * @param key
     * @return data
     */
    private String getStringFromPreferances(String key) {
        String data = sharedPreferences.getString(key, EMPTY_STRING);
        return data;
    }

    public void clearAllPreferences() {
        sharedPreferences.edit().clear().commit();
    }

    public void saveUserModel(Users userModel) {

        if (userModel == null)
            return;
        Log.e("UserModelRegister", userModel.getEmail() + SharedPreferenceKeys.USER_EMAIL.getKey());
        setStringInPreferences(SharedPreferenceKeys.USER_EMAIL.getKey(), userModel.getEmail());
        setStringInPreferences(SharedPreferenceKeys.USER_PASSWORD.getKey(), userModel.getPassword());

    }

    public Users getUserModelFromPreferences() {
        Users userModel = null;
        String userEmail = getStringFromPreferances(SharedPreferenceKeys.USER_EMAIL.getKey());
        String userPassword = getStringFromPreferances(SharedPreferenceKeys.USER_PASSWORD.getKey());

        // Log.e("USernameLogin",name);
        // Log.e("USernameLogin",uid);
        if (!TextUtils.isEmpty(userEmail) || !TextUtils.isEmpty(userPassword)) {
            userModel = new Users();
            userModel.setEmail(getStringFromPreferances(SharedPreferenceKeys.USER_EMAIL.getKey()));
            userModel.setPassword(getStringFromPreferances(SharedPreferenceKeys.USER_PASSWORD.getKey()));


        }
//        Log.e("Loaded value",userModel.uid);
        return userModel;
    }
}
