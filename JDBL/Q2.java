package org.nisum;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class example {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "root@123";

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        // Insert values matching the schema: studentID (INT), name (VARCHAR), email (VARCHAR)
        statement.executeUpdate("INSERT INTO `jdbc.demo`.new_table (studentID, name, email) VALUES (1, 'Alice', 'alice@example.com')");
        statement.executeUpdate("INSERT INTO `jdbc.demo`.new_table (studentID, name, email) VALUES (2, 'Bob', 'bob@example.com')");
        statement.executeUpdate("INSERT INTO `jdbc.demo`.new_table (studentID, name, email) VALUES (3, 'Charlie', 'charlie@example.com')");
        statement.executeUpdate("INSERT INTO `jdbc.demo`.new_table (studentID, name, email) VALUES (4, 'Diana', 'diana@example.com')");
        statement.executeUpdate("INSERT INTO `jdbc.demo`.new_table (studentID, name, email) VALUES (5, 'Evan', 'evan@example.com')");

        System.out.println("Data inserted successfully!");
    }
}
