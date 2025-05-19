package org.nisum;

import java.sql.*;

public class ReadData {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "root@123";

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM jdbc.newtable1");

        while (rs.next()) {
            System.out.println(rs.getString("student_id") + " " +
                               rs.getString("course_code") + " " +
                               rs.getInt("semester"));
        }

        connection.close();
    }
}
