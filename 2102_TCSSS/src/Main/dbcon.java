package Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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
