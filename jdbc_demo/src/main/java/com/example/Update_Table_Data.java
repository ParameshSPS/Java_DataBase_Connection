package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Update_Table_Data {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test", "root", "Temp1234");

            String query = "UPDATE emp_details SET Name = ?, Branch = ? WHERE Emp_ID = ?";

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter new Name:: ");
            String name = br.readLine();

            System.out.println("Enter the new Branch:: ");
            String branch = br.readLine();

            System.out.println("Enter the Emp_ID:: ");
            int id = Integer.parseInt(br.readLine());

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, branch);

            ps.setInt(3, id);

            ps.executeUpdate();

            System.out.println("Update Successfull");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
