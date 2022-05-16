package com.example.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Update_Data {
    static final String DB_URL = "jdbc:mysql://localhost:3306/Students";
    static final String USER = "root";
    static final String PASS = "Temp1234";
    static final String QUERY = "SELECT * FROM Registration";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "UPDATE Registration " + "SET age = 30 WHERE id in (100, 101)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate(sql);

            ResultSet rs = ps.executeQuery(QUERY);
            while (rs.next()) {
                // Display values
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Age: " + rs.getInt("age"));
                System.out.print(", First: " + rs.getString("firstname"));
                System.out.println(", Last: " + rs.getString("lastname"));
            }
            rs.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}