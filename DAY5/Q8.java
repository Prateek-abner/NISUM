package org.nisum;

import java.sql.*;

public class TransactionExample {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "root@123";

        Connection con = DriverManager.getConnection(url, username, password);
        con.setAutoCommit(false);

        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO jdbc.newtable1 VALUES('s006', 'c106', 1)");
            stmt.executeUpdate("INSERT INTO jdbc.newtable1 VALUES('s007', 'c107', 2)");

            con.commit();
            System.out.println("Transaction committed!");
        } catch (SQLException e) {
            con.rollback();
            System.out.println("Transaction failed and rolled back.");
            e.printStackTrace();
        }

        con.close();
    }
}
