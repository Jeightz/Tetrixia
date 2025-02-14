/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function.file;

import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class file {
    
    
    
    
    
    
    public File FileCheckGender(File f,JComboBox j,JLabel label){
        if(f == null ){
        String defaultImageFileName = j.getSelectedItem().equals("Female") ? "girlprofile.jpg" : "boyprofile.jpg";
        f = new File(System.getProperty("user.dir") + "\\src\\image\\" + defaultImageFileName);
        new Function.Image.FitImage().risizelabel(f, label);
        return f;
        }
        
        return null;
        
    }
    
    public File FilePictureFilter(File f){
          JFileChooser filechoose = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("studentpicture",ImageIO.getReaderFileSuffixes());
        filechoose.setFileFilter(filter);
        filechoose.showOpenDialog(null);
      return f = filechoose.getSelectedFile();
    }
}
