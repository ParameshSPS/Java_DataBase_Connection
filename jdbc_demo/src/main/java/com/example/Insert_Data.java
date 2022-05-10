package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert_Data {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test", "root", "Temp1234");

            String query = "insert into emp_details values(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, 10);
            ps.setString(2, "Bow - Alekhya");
            ps.setInt(3, 1234567890);
            ps.setString(4, "MSC-Statics");
            ps.setString(5, "SBC");
            ps.setString(6, "Akki");

            ps.execute();
            con.close();

        } catch (SQLException | ClassNotFoundException se) {
            System.out.println(se.getMessage());
        }
    }
}