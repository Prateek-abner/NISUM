package org.nisum;

import java.sql.*;

public class CallProcedure {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "root@123";

        Connection con = DriverManager.getConnection(url, username, password);
        CallableStatement cs = con.prepareCall("{CALL getStudentById(?)}");

        cs.setString(1, "s001");

        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("student_id") + " " +
                               rs.getString("course_code") + " " +
                               rs.getInt("semester"));
        }

        con.close();
    }
}
