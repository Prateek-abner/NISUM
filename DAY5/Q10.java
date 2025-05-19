package org.nisum;

import java.sql.*;

public class SafeInsert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "root@123";

        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = con.prepareStatement("INSERT INTO jdbc.newtable1 VALUES (?, ?, ?)")) {

            ps.setString(1, "s999");
            ps.setString(2, "c999");
            ps.setInt(3, 3);

            ps.executeUpdate();
            System.out.println("Data inserted safely.");

        } catch (SQLException e) {
            System.out.println("Error inserting:");
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
            System.out.println("Message: " + e.getMessage());
        }
    }
}
