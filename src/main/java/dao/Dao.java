/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Vhc
 */
public class Dao {
    protected Connection connection;
    
    public Dao() {
        String URL = "jdbc:mysql://localhost:3306/mydatabase";
        String USER = "";
        String PASSWORD = "";
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } 
    }
    
    public void closeConnection() {
        if (this.connection != null) {
            try {
                
                this.connection.close();
                System.out.println("Kết nối đã đóng!");
                
            } catch (SQLException e) {
                
                e.printStackTrace();
                
            }
        }
    } 
}
