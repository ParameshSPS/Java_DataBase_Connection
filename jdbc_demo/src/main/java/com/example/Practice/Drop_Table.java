package com.example.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Drop_Table {
    static final String DB_URL = "jdbc:mysql://localhost:3306/Students";
    static final String USER = "root";
    static final String PASS = "Temp1234";

    public static void main(String[] args) throws ClassNotFoundException {
        // Open a connection
        try {
            // Registering the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Getting the connection
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

            Statement stmt = con.createStatement();

            String sql = "DROP TABLE REGISTRATION";
            stmt.executeUpdate(sql);
            System.out.println("Table deleted in given database...");
            con.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}