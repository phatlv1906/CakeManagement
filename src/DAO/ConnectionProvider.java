/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;

/**
 *
 * @author HP
 */
public class ConnectionProvider {
    public static Connection getCon(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms?useSSL=false","root","19062002Lvp");
            return conn;
        }catch(Exception e){
            return null;
        }
    }
    public static void closeCon(Connection con){
        try{
            if(con != null){
                con.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
