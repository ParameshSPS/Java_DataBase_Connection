package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Delete_Column {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test", "root", "Temp1234");

            String query = "ALTER TABLE emp_details Drop signature";

            PreparedStatement ps = con.prepareStatement(query);

            int result = ps.executeUpdate();

            if (result > 0)
                System.out.println(
                        "A column from the table is deleted.");
            else
                System.out.println("unsuccessful deletion ");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}