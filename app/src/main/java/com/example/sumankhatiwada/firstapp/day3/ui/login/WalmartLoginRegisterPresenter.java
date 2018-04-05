package com.example.sumankhatiwada.firstapp.day3.ui.login;

import android.util.Log;

import com.example.sumankhatiwada.firstapp.day3.model.Users;

import java.util.List;

/**
 * Created by sumankhatiwada on 4/4/18.
 */

public class WalmartLoginRegisterPresenter {

    Users users = new Users();

    public boolean doLoginCheck(String userName, String password){
        List<Users> domainUsername = users.getUsersList();
        for(int i = 0; i<domainUsername.size();i++){
            if(domainUsername.get(i).getEmail().equals(userName) && domainUsername.get(i).getPassword().equals(password)){
                Log.e("Sucess","Login Successful");
                return true;

            }else {
                Log.e("fail","Login Invalid");
            }
        }
        return false;

    }

    public void doRegistration(String firstName, String lastName, String userName, String password) {
        Users user = new Users();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(userName);
        user.setPassword(password);
        users.addUser(user);
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
