package com.example.sumankhatiwada.firstapp.day3.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sumankhatiwada on 4/4/18.
 */

public class Users {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    ArrayList<Users> usersList = new ArrayList<>();

    public Users() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(ArrayList<Users> usersList) {
        this.usersList = usersList;
    }

    public void setDefaultUsers(){
        Users user0 = new Users();
        user0.setFirstName("Suman");
        user0.setLastName("Khatiwada");
        user0.setEmail("suman@gmail.com");
        user0.setPassword("123");
        addUser(user0);

        Users user1 = new Users();
        user1.setFirstName("Niwesh");
        user1.setLastName("Rai");
        user1.setEmail("niwesh@gmail.com");
        user1.setPassword("n123");
        addUser(user1);

        Users user2 = new Users();
        user2.setFirstName("Krishna");
        user2.setLastName("Kc");
        user2.setEmail("krishna@gmail.com");
        user2.setPassword("k123");
        addUser(user2);
    }

    public void addUser(Users user) {
        usersList.add(user);
        for(Users users:usersList){
            Log.e("ListSize",usersList.size()+""+users.getEmail());

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        return password != null ? password.equals(users.password) : users.password == null;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
