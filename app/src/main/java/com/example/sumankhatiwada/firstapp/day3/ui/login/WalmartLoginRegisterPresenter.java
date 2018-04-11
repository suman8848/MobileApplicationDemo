package com.example.sumankhatiwada.firstapp.day3.ui.login;

import android.content.Context;
import android.util.Log;

import com.example.sumankhatiwada.firstapp.day3.model.Users;

import java.util.List;

/**
 * Created by sumankhatiwada on 4/4/18.
 */

public class WalmartLoginRegisterPresenter {

    Users users = new Users();
    SharedPrefManager msharedPreferenceManager = new SharedPrefManager();

    public boolean doLoginCheck(String userName, String password){
        List<Users> domainUsername = users.getUsersList();
        for(int i = 0; i<domainUsername.size();i++){
            if(domainUsername.get(i).getEmail().equals(userName) && domainUsername.get(i).getPassword().equals(password)){
                Log.e("Sucess","Login Successful");
                users.setEmail(domainUsername.get(i).getEmail());
                users.setPassword(domainUsername.get(i).getPassword());
                return true;

            }else {
                Log.e("fail","Login Invalid");
            }
        }
        return false;

    }
    public void saveUserModelSession(Context mContext) {
        msharedPreferenceManager.initiateSharedPreferences(mContext);
        msharedPreferenceManager.saveUserModel(users);
    }

    public void doRegistration(String firstName, String lastName, String userName, String password) {
        Users user = new Users();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(userName);
        user.setPassword(password);
        users.addUser(user);
    }

    public Users getUserModelSession(Context mContext) {
        msharedPreferenceManager.initiateSharedPreferences(mContext);
        Users userModel = msharedPreferenceManager.getUserModelFromPreferences();
        return userModel;
    }
    public void clearSession(){
        msharedPreferenceManager.clearAllPreferences();
    }

    public void setDefaultUsers() {
        users.setDefaultUsers();
    }


    private static WalmartLoginRegisterPresenter singletonWalmartLoginRegisterPresenter = new WalmartLoginRegisterPresenter( );

    private WalmartLoginRegisterPresenter() {

    }

    public static WalmartLoginRegisterPresenter getInstance( ) {
        return singletonWalmartLoginRegisterPresenter;
    }
}
