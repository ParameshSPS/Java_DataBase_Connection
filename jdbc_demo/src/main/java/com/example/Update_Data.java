package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Insert Data
public class Update_Data {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test", "root", "Temp1234");

            String query = "UPDATE emp_details " + "SET Phone_No = ? " + "WHERE Name = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, 1000000000);
            ps.setString(2, "Padma");

            ps.executeUpdate();
            con.close();

        } catch (SQLException | ClassNotFoundException se) {
            System.out.println(se.getMessage());
        }
        System.out.println("Update Successfull");
    }
}