package org.nisum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root@123";

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS students (id INT, name VARCHAR(50), age INT)");
        statement.executeUpdate("INSERT INTO students VALUES(1, 'Ravi', 20)");

        System.out.println("Data inserted using Statement!");
        connection.close();
    }
}
