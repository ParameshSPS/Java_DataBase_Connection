package com.example.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Select_Data {
    static final String DB_URL = "jdbc:mysql://localhost:3306/Students";
    static final String USER = "root";
    static final String PASS = "Temp1234";
    static final String QUERY = "SELECT * FROM Registration";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

            PreparedStatement ps = con.prepareStatement(QUERY);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // Display values
                System.out.println("ID : " + rs.getInt("ID"));
                System.out.println("FirstName : " + rs.getString("FirstName"));
                System.out.println("LastName : " + rs.getString("LastName"));
                System.out.println("Age : " + rs.getInt("Age"));
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}