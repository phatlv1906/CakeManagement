/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.Product;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author HP
 */
public class ProductDao {
    public static void save(Product product){
        String query = "insert into product(name, category, price) values('"+product.getName()+"','"+product.getCategory()+"', '"+product.getPrice()+"')";
        DbOperations.setDataOrDelete(query, "Product Added Successfully");
    }
    public static ArrayList<Product> getAllProduct(){
        ArrayList<Product> listProduct = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select * from product");
            while(rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getString("price"));
                listProduct.add(product);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return listProduct;
    }
    public static void update(Product product){
        String query = "update product set name = '"+product.getName()+"',category = '"+product.getCategory()+"',price = '"+product.getPrice()+"' where id = '"+product.getId()+"'  ";
        DbOperations.setDataOrDelete(query, "Update Product Successfully");
    }
    public static void delete(String id){
        String query = "delete from product where id = '"+id+"' ";
        DbOperations.setDataOrDelete(query, "Delete Product Successfully");
    }
    public static ArrayList<Product> getProductByCategory(String category){
        ArrayList<Product> listProduct = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select * from product where category = '"+category+"' ");
            while(rs.next()){
                Product product = new Product();
                product.setName(rs.getString("name"));
                listProduct.add(product);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return listProduct;
    }
    
    public static ArrayList<Product> FilterByCategory(String name, String category){
        ArrayList<Product> listProduct = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select * from product where name like '%"+name+"%' and category = '"+category+"' ");
            while(rs.next()){
                Product product = new Product();
                product.setName(rs.getString("name"));
                listProduct.add(product);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return listProduct;
    }
    
    public static Product getProductByName(String name){
        Product product = new Product();
        try{
            ResultSet rs = DbOperations.getData("select * from product where name = '"+name+"'");
            while(rs.next()){
                product.setName(rs.getString(2));
                product.setCategory(rs.getString(3));
                product.setPrice(rs.getString(4));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return product;
        
    }
    
}
