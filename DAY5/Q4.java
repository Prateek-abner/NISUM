package org.nisum;

import java.sql.*;

public class InsertPrepared {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root@123";

        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement ps = connection.prepareStatement("INSERT INTO students VALUES (?, ?, ?)");

        ps.setInt(1, 2);
        ps.setString(2, "Amit");
        ps.setInt(3, 21);

        ps.executeUpdate();

        System.out.println("Data inserted using PreparedStatement!");
        connection.close();
    }
}
