package Model.UserData;

import Function.CheckDate.CheckDate;
import UserInterface.Admin.AdminFrame;
import UserInterface.User.UserFrame;
import java.awt.event.KeyEvent;
import java.io.File;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.mindrot.jbcrypt.BCrypt;

public class UserData {

    //map is a interface
    //hashmap as an implementation of the map
    private HashMap<String, Integer> userKeyBinds = new HashMap<>();//store the keyBind of the user
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
    private static final String MOVE_LEFT = "MOVE_LEFT";
    private static final String MOVE_RIGHT = "MOVE_RIGHT";
    private static final String MOVE_DOWN = "MOVE_DOWN";
    private static final String ROTATE = "ROTATE";
    private static final String HARD_DROP = "HARD_DROP";
    private static final String HOLD = "HOLD";
    private LocalDateTime banExpr;
    private String userType;
    private boolean isMusicOn;

    //password hashing
    private static String pepper = null;
    private static final int randomGenNum = 10;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public boolean isIsMusicOn() {
        return isMusicOn;
    }

    public void setIsMusicOn(boolean isMusicOn) {
        this.isMusicOn = isMusicOn;
    }

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

    public int getUserKeyBinds(String key) {

        if (!userKeyBinds.containsKey(key)) {
            return -1;
        }
        return userKeyBinds.get(key);
    }

    public String getStringUserKeyBinds(String key) {

        if (!userKeyBinds.containsKey(key)) {
            return null;
        }
        return KeyEvent.getKeyText(userKeyBinds.get(key));
    }

    public void updateUserKeyBinds(String key, int updateVkValue) {
        if (userKeyBinds.containsKey(key)) {
            userKeyBinds.put(key, updateVkValue);
        }
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
        userKeyBinds.put(MOVE_LEFT, KeyEvent.VK_LEFT);
        userKeyBinds.put(MOVE_RIGHT, KeyEvent.VK_RIGHT);
        userKeyBinds.put(MOVE_DOWN, KeyEvent.VK_DOWN);
        userKeyBinds.put(ROTATE, KeyEvent.VK_UP);
        userKeyBinds.put(HARD_DROP, KeyEvent.VK_SPACE);
        userKeyBinds.put(HOLD, KeyEvent.VK_SHIFT);
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

    
    
     public String userPasswordHash(String password) {
        /*
        byte[] hashBytes = new byte[0];
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            hashBytes = digest.digest(password.getBytes("UTF-8"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Base64.getEncoder().encodeToString(hashBytes);
         */
        try {
            generatePepper();
            String pepperedPassword = password + pepper;
            String salt = BCrypt.gensalt(randomGenNum);
            String hashedPassword = BCrypt.hashpw(pepperedPassword, salt);

            return hashedPassword;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
     }
     
     
    public UserData(ArrayList<UserData> data, String Username, String Password, String FirstName, String LastName,
            String gender, File profile, String BOD) {

        this.Username = Username;
        this.Password = userPasswordHash(Password);
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.profile = profile;
        this.gender = gender;
        this.BOD = BOD;
        this.playerScore = 0;
        this.newAddUSerKeyBinds();
        this.userType = "User";
        this.isMusicOn = true;
    }

    public int userLogin(ArrayList<UserData> data, String username, String password) {
        for (int i = 0; i < data.size(); i++) {
            UserData user = data.get(i);
            if (user.getUsername().equals(username) &&  user.verifyPassword(password, this.Password)) {
                if (user.getBanExpr() != null && LocalDateTime.now().isBefore(user.getBanExpr())) {
                    JOptionPane.showMessageDialog(null,
                            "Your account is banned until: " + user.getBanExpr(),
                            "Account Banned",
                            JOptionPane.ERROR_MESSAGE);
                    return -1;
                }
                if ("Admin".equals(user.userType)) {
                    user.loginHistory.add(LocalDateTime.now());
                    new AdminFrame(i).setVisible(true);
                    return i;
                }
                user.loginHistory.add(LocalDateTime.now());
                new UserFrame(i).setVisible(true);
                return i;
            }
        }
        return -1;
    }

    public void userLoginAndOutHistory(JTable table, ArrayList<UserData> data, int userIndex) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        UserData user = data.get(userIndex);
        ArrayList<LocalDateTime> logins = user.getLoginHistory();
        ArrayList<LocalDateTime> logouts = user.getLogoutHistory();

        int maxSize = Math.max(logins.size(), logouts.size());
        for (int i = 0; i < maxSize; i++) {
            String loginTime = (i < logins.size()) ? logins.get(i).toString() : "";
            String logoutTime = (i < logouts.size()) ? logouts.get(i).toString() : "";
            model.addRow(new Object[]{
                i + 1,
                loginTime,
                logoutTime
            });
        }

    }

    public void filterLoginLogoutHistoryByDate(JTable table, ArrayList<UserData> data, int userIndex, String dateString) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        UserData user = data.get(userIndex);
        ArrayList<LocalDateTime> logins = user.getLoginHistory();
        ArrayList<LocalDateTime> logouts = user.getLogoutHistory();
        java.time.LocalDate inputDate;
        try {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
            inputDate = java.time.LocalDate.parse(dateString, inputFormatter);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Invalid date format. Please use format like 'March 10 2024'.",
                    "Date Format Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        int rowCount = 1;

        for (int i = 0; i < logins.size(); i++) {
            LocalDateTime loginDateTime = logins.get(i);
            LocalDate loginDate = loginDateTime.toLocalDate();
            if (loginDate.equals(inputDate)) {
                String logoutTime = "";
                if (i < logouts.size()) {
                    LocalDateTime logoutDateTime = logouts.get(i);
                    logoutTime = logoutDateTime.toString();
                }
                model.addRow(new Object[]{
                    rowCount++,
                    loginDateTime.toString(),
                    logoutTime
                });
            }
        }

    }

    public void userLogout(ArrayList<UserData> data, int userindex) {
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
        if (!new CheckDate().isAtLeast10YearsOld(bod)) {
            JOptionPane.showMessageDialog(null, "The BOD is not applicable cause it is lower than 10 years old age or too high than 100", "NOT APPLICABLE BOD", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

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
        mergeSort(data);
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

    public void banUserUntilDateTimeByIndex(ArrayList<UserData> data, int userIndex, String dateString, String timeString) {
        if (userIndex < 0 || userIndex >= data.size()) {
            JOptionPane.showMessageDialog(null, "Invalid UserIndex.", "Invalid Index", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        UserData user = data.get(userIndex);
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
            LocalDate banDate = LocalDate.parse(dateString, dateFormatter);
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mma", Locale.ENGLISH);
            LocalTime banTime = LocalTime.parse(timeString.toUpperCase(), timeFormatter);
            LocalDateTime banDateTime = LocalDateTime.of(banDate, banTime);
            if (banDateTime.isBefore(LocalDateTime.now())) {
                JOptionPane.showMessageDialog(null, "Ban date and time cannot be in the past.", "PAST SET", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            user.setBanExpr(banDateTime);
            DateTimeFormatter displayFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy 'at' h:mma").withLocale(Locale.ENGLISH);
            JOptionPane.showMessageDialog(null, "User '" + user.getUsername() + "' has been banned until " + banDateTime.format(displayFormatter), "BAN TIME", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void filterAccount(ArrayList<UserData> data, JTable table, String search) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        int cout = model.getRowCount() + 1;
        for (UserData da : data) {
            if (da.getUsername().contains(search) || da.getFirstName().contains(search) || da.getLastName().contains(search)) {
                if (da.getUserType().equals("User")) {
                    model.addRow(new Object[]{cout++, da.getUsername(), da.getFirstName() + " " + da.getLastName(), da.getPlayerScore()});
                }
            }
        }

        if (model.getRowCount() == 0 && !search.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No results found for: " + search);
        }
    }

    private void generatePepper() {
       if(pepper == null){
            SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[randomGenNum];
        random.nextBytes(bytes);
        pepper = Base64.getEncoder().encodeToString(bytes);
       }
        System.out.println(pepper);
        System.out.println(Password);
    }

    public boolean verifyPassword(String plainPassword, String hashedPassword) {
        try {
            generatePepper();

            String pepperedPassword = plainPassword + pepper;
            return BCrypt.checkpw(pepperedPassword, hashedPassword);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



}
