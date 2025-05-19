package org.nisum;

import java.sql.*;

public class SearchStudents {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "root@123";

        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM jdbc.newtable1 WHERE student_id LIKE ?");

        ps.setString(1, "s00%");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("student_id") + " " +
                               rs.getString("course_code") + " " +
                               rs.getInt("semester"));
        }

        connection.close();
    }
}
