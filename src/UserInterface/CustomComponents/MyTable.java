/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserInterface.CustomComponents;

import java.awt.Color;
import java.awt.Font;

import java.util.Arrays;



import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Admin
 */


public class MyTable extends JTable{
    private JTableHeader header = this.getTableHeader();
     private DefaultTableModel dm ;
    
   public  MyTable(){
       
       
       
     
     
      
        header.setFont(new Font("Arial",Font.BOLD,12)); 
        header.setOpaque(false);
        header.setFocusable(false);
        header.setBackground(new Color(39,159,217));
        header.setForeground(Color.BLACK);
        setRowHeight(25);
        header.setFocusable(false);
        setShowHorizontalLines(true);
        header.setReorderingAllowed(false);
        header.setFocusable(false);
      
       
    
    }
   
   //multifilter the data in the table
   
   public void searchTableFilter(JTable table, String query) {
    try {
        TableRowSorter<DefaultTableModel> myTableShoter = new TableRowSorter<>(dm);
        myTableShoter.setRowFilter(RowFilter.regexFilter("(?i)" + query));
        table.setRowSorter(myTableShoter);
    } catch (Exception e) {
        System.err.println("Error occurred during filtering: " + e.getMessage());
    }
}

    public void twoTablefilter(JTable table, String query1, int columnfilter1, String query2, int columnfilter2) {
        TableRowSorter<DefaultTableModel> myTableShorter = new TableRowSorter<>(dm);
        RowFilter<DefaultTableModel, Object> filter1 = RowFilter.regexFilter("(?i)" + query1, columnfilter1);
        RowFilter<DefaultTableModel, Object> filter2 = RowFilter.regexFilter("(?i)" + query2, columnfilter2);

        if (query1 != null && query2 != null) {
            myTableShorter.setRowFilter(RowFilter.andFilter(Arrays.asList(filter1, filter2)));
        } else if (query1 != null) {
            myTableShorter.setRowFilter(filter1);
        } else if (query2 != null) {
            myTableShorter.setRowFilter(filter2);
        }
        table.setRowSorter(myTableShorter);
    }
}
