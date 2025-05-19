package org.nisum;

import java.sql.*;

public class DeleteData {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "root@123";

        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement ps = connection.prepareStatement("DELETE FROM newtable1 WHERE student_id = ?");

        ps.setString(1, "s002");

        ps.executeUpdate();
        System.out.println("Record deleted!");
        connection.close();
    }
}
