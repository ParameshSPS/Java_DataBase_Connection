package com.example.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Create_DataBase {
    public static void main(String[] args) {
        try {
            // Registering the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Getting the connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/", "root", "Temp1234");            
            System.out.println("Connection established......");

            // Creating the Statement
            Statement stmt = con.createStatement();

            // Query to create a database
            String query = "CREATE database Students";

            // Executing the query
            stmt.execute(query);
            System.out.println("Database created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}