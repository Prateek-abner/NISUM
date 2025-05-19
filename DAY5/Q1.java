package org.nisum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root@123";

        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connected successfully!");
        connection.close();
    }
}
