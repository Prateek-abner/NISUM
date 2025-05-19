package org.nisum;

import java.sql.*;

public class UpdateData {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root@123";

        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement ps = connection.prepareStatement("UPDATE students SET name = ? WHERE id = ?");

        ps.setString(1, "Rahul");
        ps.setInt(2, 1);

        ps.executeUpdate();

        System.out.println("Record updated!");
        connection.close();
    }
}
