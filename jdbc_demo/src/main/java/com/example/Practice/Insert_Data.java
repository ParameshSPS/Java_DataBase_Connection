package com.example.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert_Data {
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

            System.out.println("Inserting records into the table...");

            String sql = "INSERT INTO Registration VALUES (100, 'Zara', 'Ali', 18)";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO Registration VALUES (101, 'Mahnaz', 'Fatma', 25)";
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO Registration VALUES (102, 'Zaid', 'Khan', 30)";
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO Registration VALUES(103, 'Sumit', 'Mittal', 28)";
            stmt.executeUpdate(sql);

            System.out.println("Inserted records into the table...");
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}