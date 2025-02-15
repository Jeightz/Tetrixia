package Model.UserData;

import UserInterface.Admin.AdminFrame;
import UserInterface.Login.SignIn;
import UserInterface.User.UserFrame;
import java.awt.event.KeyEvent;
import java.io.File;
import java.security.MessageDigest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UserData {

    //map is a interface
    //hashmap as an implementation of the map
    private Map<String, Integer> userKeyBinds = new HashMap<>();//store the keyBind of the user
    private String Username;
    private String Password;
    private String FirstName;
    private String LastName;
    private File profile = null;
    private int playerScore;
    private String gender;
    private String BOD;
    private ArrayList<LocalDateTime> loginHistory = new ArrayList<>();
    private ArrayList<LocalDateTime> logoutHistory = new ArrayList<>();

    //default keyBinds 
    private static final String MOVE_LEFT = "Move Left";
    private static final String MOVE_RIGHT = "Move Right";
    private static final String MOVE_DOWN = "Move Down";
    private static final String ROTATE = "Rotate";
    private static final String HARD_DROP = "Hard Drop";
    private LocalDateTime banExpr;
    private String userType;

    public ArrayList<LocalDateTime> getLoginHistory() {
        return loginHistory;
    }

    public void setLoginHistory(ArrayList<LocalDateTime> loginHistory) {
        this.loginHistory = loginHistory;
    }

    public ArrayList<LocalDateTime> getLogoutHistory() {
        return logoutHistory;
    }

    public void setLogoutHistory(ArrayList<LocalDateTime> logoutHistory) {
        this.logoutHistory = logoutHistory;
    }

    public LocalDateTime getBanExpr() {
        return banExpr;
    }

    public void setBanExpr(LocalDateTime banExpr) {
        this.banExpr = banExpr;
    }

    public void setBanForDays(int days) {
        this.setBanExpr(LocalDateTime.now().plusDays(days));
    }

    public void setBanForHours(int hours) {
        this.setBanExpr(LocalDateTime.now().plusHours(hours));
    }

    public Map<String, Integer> getUserKeyBinds() {
        return userKeyBinds;
    }

    public void updateUserKeyBinds() {
        this.userKeyBinds = userKeyBinds;
    }

    public String getBOD() {
        return BOD;
    }

    public void setBOD(String BOD) {
        this.BOD = BOD;
    }

    public String getGender() {
        return gender;
    }

    private void newAddUSerKeyBinds() {
        this.getUserKeyBinds().put(MOVE_LEFT, KeyEvent.VK_LEFT);
        this.getUserKeyBinds().put(MOVE_RIGHT, KeyEvent.VK_RIGHT);
        this.getUserKeyBinds().put(MOVE_DOWN, KeyEvent.VK_DOWN);
        this.getUserKeyBinds().put(ROTATE, KeyEvent.VK_UP);
        this.getUserKeyBinds().put(HARD_DROP, KeyEvent.VK_SPACE);
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public File getProfile() {
        return profile;
    }

    public void setProfile(File profile) {
        this.profile = profile;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public UserData() {

    }

    public UserData(ArrayList<UserData> data, String Username, String Password, String FirstName, String LastName,
           String gender, File profile, String BOD) {
        if (this.isUsernameDuplication(data, Username)) {
            JOptionPane.showMessageDialog(null, "THE USERNAME YOU INPUT IS ALREADY EXCIST PLEASE ENTER AGAIN", "USERNAME DUPLICATION", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        this.Username = Username;
        this.Password = userPasswordHash(Password);
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.profile = profile;
        this.gender =gender;
        this.BOD = BOD;
        this.playerScore = 0;
        this.newAddUSerKeyBinds();
        this.userType = "User";
    }

    public String userPasswordHash(String password) {
        byte[] hashBytes = new byte[0];
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            hashBytes = digest.digest(password.getBytes("UTF-8"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Base64.getEncoder().encodeToString(hashBytes);
    }

    public int userLogin(ArrayList<UserData> data, String username, String password) {

        for (int i = 0; i <=  data.size(); i++) {
            UserData user = data.get(i);
            System.out.println(i);
            if (user.getUsername().equals(username) && user.getPassword().equals(userPasswordHash(password))) {

                if (banExpr != null && LocalDateTime.now().isBefore(banExpr)) {
                    JOptionPane.showMessageDialog(null,
                            "Your account is banned until: " + banExpr,
                            "Account Banned",
                            JOptionPane.ERROR_MESSAGE);
                    return -1 ;
                }
                if (user.userType == "Admin") {
                    new AdminFrame().setVisible(true);
                }
                user.loginHistory.add(LocalDateTime.now());
                new UserFrame(data,i).setVisible(true);
               System.out.println(user.getPassword());
               return i;
            }

        }
        return -1;
    }
    
    public void userLogout(ArrayList<UserData> data,int userindex){
        UserData us = data.get(userindex);
        us.logoutHistory.add(LocalDateTime.now());
        
    }

    public boolean isUsernameDuplication(ArrayList<UserData> data, String username) {
        for (UserData userData : data) {
            if (userData.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void deleteData(ArrayList<UserData> data, int index) {
        if (index >= 0 && index < data.size()) {
            data.remove(index);

        } else {

        }
    }

    public void updatePersonData(ArrayList<UserData> data, int index, String firstName, String lastName, String gender, String bod) {
        if (index >= 0 && index < data.size()) {
            UserData us = data.get(index);
            us.setFirstName(firstName);
            us.setLastName(lastName);
            us.setGender(gender);
            us.setBOD(bod);

        }
    }

    public void updateUsername(ArrayList<UserData> data, int index, String user) {
        if (index >= 0 && index < data.size() && !isUsernameDuplication(data, user)) {
            UserData us = data.get(index);
            us.setUsername(user);
        }
    }

    public void updatePassword(ArrayList<UserData> data, int index, String pass) {
        if (index >= 0 && index < data.size()) {
            UserData us = data.get(index);
            us.setPassword(userPasswordHash(pass));
        }
    }

    public void updateProfile(ArrayList<UserData> data, int index, File pro) {
        if (index >= 0 && index < data.size()) {
            UserData us = data.get(index);
            us.setProfile(pro);
        }
    }

    public void addDataAccountTable(ArrayList<UserData> data, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        int count = model.getRowCount() + 1;

        for (UserData da : data) {
            int score = da.getPlayerScore();
            if (score == -1) {
                score = 0;
            }
            if (da.userType.equals("User")) {
                model.addRow(new Object[]{count++, da.getUsername(), da.FirstName + " " + da.LastName, score});
            }

        }
    }

    public void addDataLeaderBoardTables(ArrayList<UserData> data, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        int cout = model.getRowCount() + 1;
        for (UserData da : data) {
            model.addRow(new Object[]{cout++, da.getUsername(), da.getPlayerScore()});
        }
    }
//sorting for the leaderBoards

    public void mergeSort(ArrayList<UserData> data) {
        int arryleght = data.size();

        //check the arryLenght if the lenght is less that 2
        if (arryleght < 2) {

            return;
        }
        //cut the lenght to 2 parts
        int middle = arryleght / 2;

        //sublist is a method that return a view portion  of the original list without copying the original
        //get the data of arraylist  to 0 index to the value of middle
        ArrayList<UserData> leftData = new ArrayList<>(data.subList(0, middle));
        //same but different part of the arraylist
        ArrayList<UserData> rightData = new ArrayList<>(data.subList(middle, arryleght));

        mergeSort(leftData);
        mergeSort(rightData);

        merge(data, leftData, rightData);
    }

    private void merge(ArrayList<UserData> data, ArrayList<UserData> left, ArrayList<UserData> right) {
        int index = 0, RIndex = 0, LIndex = 0;

        while (RIndex < right.size() && LIndex < left.size()) {
            if (left.get(LIndex).getPlayerScore() >= right.get(RIndex).getPlayerScore()) {
                data.set(index, left.get(LIndex));
                index++;
                LIndex++;
            } else {
                data.set(index, right.get(RIndex));
                index++;
                RIndex++;
            }
            index++;
        }

        while (LIndex < left.size()) {
            data.set(index, left.get(LIndex));
            index++;
            LIndex++;
        }
        while (RIndex < right.size()) {
            data.set(index, right.get(RIndex));
            index++;
            RIndex++;
        }
    }

    private void banDaysUsername(ArrayList<UserData> data, String user, int days) {
        for (UserData us : data) {
            if (us.getUsername().equals(user)) {
                us.setBanForDays(days);

            }
        }
    }

    public void banHoursUsername(ArrayList<UserData> data, String user, int hours) {
        for (UserData us : data) {
            if (us.getUsername().equals(user)) {
                us.setBanForHours(hours);
            }
        }

    }

    public int findUserIndex(ArrayList<UserData> data, String username) {
        for (int i = 0; i < data.size(); i++) {
            UserData us = data.get(i);
            if (us.getUsername().equals(username)) {
                return i;
            }
        }
        return - 1;
    }
}
