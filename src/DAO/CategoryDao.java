/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.Category;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author HP
 */
public class CategoryDao {
    public static void save(Category category){
        String query = "insert into category(name) values('"+category.getName()+"')";
        DbOperations.setDataOrDelete(query, "Category Add Successfully");
    }
    public static ArrayList<Category> getAllCategory(){
        ArrayList<Category> listCategory = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select * from category");
            while(rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                listCategory.add(category);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return listCategory;
    }
    public static void delete(String id){
        String query = "delete from category where id='"+id+"'  ";
        DbOperations.setDataOrDelete(query, "Category Deleted Successfully");
    }
}
