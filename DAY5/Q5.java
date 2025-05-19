package org.nisum;

import java.sql.*;

public class UpdateData {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "root@123";

        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement ps = connection.prepareStatement(
            "UPDATE jdbc.newtable1 SET course_code = ? WHERE student_id = ?");

        ps.setString(1, "c999");
        ps.setString(2, "s001");

        ps.executeUpdate();
        System.out.println("Record updated!");
        connection.close();
    }
}
