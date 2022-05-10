package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class App {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test", "root", "Temp1234");

            String query = "select * from emp_details";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            System.out.println("List of Names: ");

            while (rs.next()) {
                System.out.println(rs.getString("Emp_ID"));
                System.out.println(rs.getString("Name"));
                System.out.println(rs.getString("Phone_No"));
                System.out.println(rs.getString("Role"));
                System.out.println(rs.getString("Branch"));
            }

            con.close();

        } catch (SQLException | ClassNotFoundException se) {
            System.out.println(se.getMessage());
        }
    }
}