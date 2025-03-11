/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function.CheckDate;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class CheckDate {

    public boolean isAtLeast10YearsOld(String birthDateString) {
        LocalDate birthDate;
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
            birthDate = LocalDate.parse(birthDateString, dateFormatter);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Invalid date format. Please use format like 'April 15, 2005'.",
                    "Date Format Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        LocalDate currentDate = java.time.LocalDate.now();
        Period period = java.time.Period.between(birthDate, currentDate);

        return period.getYears() >= 10 && period.getYears() <= 100;
    }

}
