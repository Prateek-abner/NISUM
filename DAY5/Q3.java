package org.nisum;

import java.sql.*;

public class ReadData {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root@123";

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + " " +
                               resultSet.getString("name") + " " +
                               resultSet.getInt("age"));
        }

        connection.close();
    }
}
