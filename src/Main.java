import Client.Client;
import Client.remise.Remise;
import Client.remise.RemiseNormal;
import Client.remise.RemiseVip;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jee";
        String username = "root";
        String password = "1234";
        try {
            Connection conn;
            conn = DriverManager.getConnection(url, username, password);
            Statement stmt;
            stmt = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM client");
            while (rs.next()) {
                try {
                    String name = rs.getString("nom");
                    int id = rs.getInt("id");
                    System.out.println(id+":  "+name);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}