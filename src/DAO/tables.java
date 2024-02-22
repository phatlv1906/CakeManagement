/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class tables {
    public static void main(String[] args) {
        try{
            String userTable = "create table user(id int AUTO_INCREMENT primary key, name varchar(200), email varchar(200), phoneNumber varchar(200), address varchar(200), password varchar(200), passwordReset varchar(200), status varchar(20), UNIQUE (email))";
            String adminDetail = "insert into user(name, email, phoneNumber, address, password, passwordReset, status) values('Admin', 'admin@gmail.com', '0764484234', 'HCM', 'admin', '19062002', 'true')";
            String productTable = "create table product(id int AUTO_INCREMENT primary key, name varchar(200), category varchar(200), price varchar(200))";
            String categoryTable = "create table category(id int AUTO_INCREMENT primary key, name varchar(200))";
            String billTable = "create table bill(id int AUTO_INCREMENT primary key, name varchar(200), phoneNumber varchar(200), email varchar(200), date varchar(50), total varchar(200), createBy varchar(200))";
//            DbOperations.setDataOrDelete(userTable, "User Table Created Successfully");
           DbOperations.setDataOrDelete(adminDetail, "Admin Details Added Successfully");

            //DbOperations.setDataOrDelete(categoryTable, "Category table create Successfully");
//                DbOperations.setDataOrDelete(productTable, "Product table create Successfully");
//             DbOperations.setDataOrDelete(billTable, "Bill table create Successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
