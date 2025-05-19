package org.nisum;

import java.sql.*;

public class InsertData {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "root@123";

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        statement.executeUpdate("INSERT INTO newtable1 VALUES('s001', 'c101', 1)");
        statement.executeUpdate("INSERT INTO newtable1 VALUES('s002', 'c102', 2)");

        System.out.println("Data inserted using Statement!");
        connection.close();
    }
}
