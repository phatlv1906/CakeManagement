/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.Bill;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author HP
 */
public class BillDao {
    public static String getId(){
        int id = 1;
        try{
            ResultSet rs = DbOperations.getData("select max(id) from bill");
            if(rs.next()){
                id = rs.getInt(1);
                id = id + 1;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }
    public static void save(Bill bill){
        String query = "insert into bill values ('"+bill.getId()+"', '"+bill.getName()+"', '"+bill.getPhoneNumber()+"', '"+bill.getEmail()+"', '"+bill.getDate()+"', '"+bill.getCost()+"', '"+bill.getCreatedBy()+"')";
        DbOperations.setDataOrDelete(query, "Bill Details Added Successfully");
    }
    public static ArrayList<Bill> getAllBillByInc(String date){
        ArrayList<Bill> listBill = new ArrayList<>();
        try{
            ResultSet rs =DbOperations.getData("select * from bill where date like '%"+date+"%'");
            while(rs.next()){
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setName(rs.getString("name"));
                bill.setPhoneNumber(rs.getString("phoneNumber"));
                bill.setEmail(rs.getString("email"));
                bill.setDate(rs.getString("date"));
                bill.setCost(rs.getString("total"));
                bill.setCreatedBy(rs.getString("createBy"));
                listBill.add(bill);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return listBill;
    }
    
}
