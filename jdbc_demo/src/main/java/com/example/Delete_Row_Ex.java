package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Delete_Row_Ex {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test", "root", "Temp1234");

            String query = "delete from emp_details WHERE Emp_ID = 10";

            PreparedStatement ps = con.prepareStatement(query);

            ps.executeUpdate();

            System.out.println("Record deleted successfully");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
