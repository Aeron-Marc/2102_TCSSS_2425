/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author leand
 */
public class dbcon {
    public static Connection dbconnect() {
    String url = "jdbc:mysql://localhost:3306/tcsss_oop";
    String user = "root";
    String password = "";

    try {
        return DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error connecting to the database: " + e.getMessage());
        return null;
    }
} 
}
