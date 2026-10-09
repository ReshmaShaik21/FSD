package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateStudent {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String password = "reshma@21";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(url, user, password);

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter new course: ");
            String course = sc.nextLine();

            String sql =
                    "UPDATE students SET course = ? WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, course);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student course updated successfully.");
            } else {
                System.out.println("Student ID not found.");
            }

            ps.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

