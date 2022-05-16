package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Delete_Row {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test", "root", "Temp1234");

            String query = "delete from emp_details WHERE Emp_ID = 7";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                // Display values
                System.out.print("ID: " + rs.getInt("emp_id"));
                System.out.print(", name: " + rs.getInt("name"));
                System.out.print(", phone_no: " + rs.getString("phone_no"));
                System.out.println(", role: " + rs.getString("role"));
                System.out.println(", branch: " + rs.getString("branch"));
                System.out.println(", signature: " + rs.getString("signature"));
            }

            ps.executeUpdate();
            System.out.println("Record deleted successfully");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}