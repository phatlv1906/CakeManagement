/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import MODEL.User;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class UserDao {
    public static void save(User user){
        String query = "insert into user(name, email, phoneNumber, address, password, passwordReset , status) values('"+user.getName()+"','"+user.getEmail()+"' , '"+user.getPhoneNumber()+"', '"+user.getAddress()+"' , '"+user.getPassword()+"' ,'"+user.getPasswordReset()+"' ,'false')";
        DbOperations.setDataOrDelete(query, "Register Successfully! Please for admin approval");
    }
    public static User login(String email, String password){
        User user = null;
        try{
            ResultSet rs = DbOperations.getData("select * from user where email ='"+email+"' and password ='"+password+"' ");
            while(rs.next()){
                user = new User();
                user.setStatus(rs.getString("status"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }   
    public static User getPassword2(String email){
        User user = null;
        try{
           ResultSet rs = DbOperations.getData("select * from user where email='"+email+"' ");
           while(rs.next()){
               user = new User();
               user.setPasswordReset(rs.getString("passwordReset"));
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
    public static void update(String email, String newPassword){
        String query = "update user set password = '"+newPassword+"' where email = '"+email+"' ";
        DbOperations.setDataOrDelete(query, "Password changed successfully");
    }
    public static void updatePassreset(String email, String newPassword){
        String query = "update user set passwordReset = '"+newPassword+"' where email = '"+email+"' ";
        DbOperations.setDataOrDelete(query, "Password Level 2 changed successfully");
    }
    
    public static ArrayList<User> getAllUser(String email){
        ArrayList<User> listUser = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select * from user where email like '%"+email+"%' ");
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setAddress(rs.getString("address"));
                user.setPassword(rs.getString("password"));
                user.setPasswordReset(rs.getString("passwordReset"));
                user.setStatus(rs.getString("status"));             
                listUser.add(user);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return listUser;
    }
    public static void updateStatus(String email, String status){
        String query = "update user set status = '"+status+"' where email = '"+email+"' ";
        DbOperations.setDataOrDelete(query, "Status changed successfully");
    }
    public static void changePassword(String email, String oldPassword, String newPassword){
        try{
           ResultSet rs = DbOperations.getData("select * from user where email='"+email+"' and password = '"+oldPassword+"' ");
           if(rs.next()){
               update(email, newPassword);
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public static void changePassReset(String email, String password ,String newPasswordLv2){
        try{
            ResultSet rs = DbOperations.getData("select * from user where email='"+email+"' and password = '"+password+"' ");
            if(rs.next()){
                updatePassreset(email, newPasswordLv2);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public static User getName(String email){
        User user = null;
        try{
           ResultSet rs = DbOperations.getData("select * from user where email='"+email+"' ");
           while(rs.next()){
               user = new User();
               user.setName(rs.getString("name"));
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
}
