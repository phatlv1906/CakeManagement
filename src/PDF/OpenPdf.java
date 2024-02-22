/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDF;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class OpenPdf {
    public static void openById(String id){
        try{
            if((new File("D:\\Code\\Java\\Quan Ly Cake Project\\BILL\\"+id+".pdf")).exists()){
                Process  process = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler D:\\Code\\Java\\Quan Ly Cake Project\\BILL\\"+id+".pdf");
            } else {
                JOptionPane.showMessageDialog(null, "File doesn't exists");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
