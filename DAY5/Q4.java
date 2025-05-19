package org.nisum;

import java.sql.*;

public class InsertPrepared {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "root@123";

        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement ps = connection.prepareStatement("INSERT INTO jdbc.newtable1 VALUES (?, ?, ?)");

        ps.setString(1, "s003");
        ps.setString(2, "c103");
        ps.setInt(3, 1);

        ps.executeUpdate();
        System.out.println("Data inserted using PreparedStatement!");
        connection.close();
    }
}
