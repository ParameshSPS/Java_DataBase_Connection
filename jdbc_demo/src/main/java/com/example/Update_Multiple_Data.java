package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// Insert Multiple Data
public class Update_Multiple_Data {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test", "root", "Temp1234");

            String query = "UPDATE emp_details " + "SET Phone_No = ? " + "WHERE emp_id = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setLong(1, 887645423);
            ps.setInt(2, 2);

            ps.addBatch();

            ps.setInt(1, 0000000);
            ps.setInt(2, 3);

            ps.addBatch();

            ps.setInt(1, 6500000);
            ps.setInt(2, 4);

            ps.addBatch();

            // int[] executeBatch = ps.executeBatch();
            // for (int i : executeBatch) {
            //     System.out.println(i);
            // }

            ps.executeBatch();
            con.close();

        } catch (Exception e) { 
            e.printStackTrace();
        }

        System.out.println("Macha Update Successfull");
    }
}