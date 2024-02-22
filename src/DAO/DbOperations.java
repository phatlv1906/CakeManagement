/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author HP
 */
public class DbOperations {
    public static void setDataOrDelete(String Query, String msg){
        try{
            Connection conn = ConnectionProvider.getCon();
            Statement st = conn.createStatement();
            st.executeUpdate(Query);
            if(!msg.equals("")){
                    JOptionPane.showMessageDialog(null, msg);
            }
        } 
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static ResultSet getData(String Query){
        try{
            Connection conn = ConnectionProvider.getCon();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(Query);
            return rs;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
}
