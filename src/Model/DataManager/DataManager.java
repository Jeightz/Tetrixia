/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DataManager;

import Model.UserData.UserData;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class DataManager {
     private static DataManager instance = null; 

    private final ArrayList<UserData> data;
    private final ArrayList<UserData> deletedAccounts;

    private DataManager() { 
        this.data = new ArrayList<>();
        this.deletedAccounts = new ArrayList<>();
    }

    
    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public ArrayList<UserData> getData() {
        return data;
    }

    public ArrayList<UserData> getDeletedAccounts() {
        return deletedAccounts;
    }

    public void addUser(UserData user) {
        data.add(user);
    }

    public void deleteUser(UserData user) {
        data.remove(user);
        deletedAccounts.add(user);
    }
}
