package com.mycompany.main1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repo {
    private final String url = "jdbc:sqlite:C:/Users/james paul/Documents/Student.db";

    // Requirement: Store data using Student Objects
    public void addStudent(Student s) {
        String sql = "INSERT INTO tbl_students (studentID, FirstName, LastName, Age, Gender, Yearlvl, Course, Bloodtype, Address, Contact) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, s.getID());
            pstmt.setString(2, s.getFirstName());
            pstmt.setString(3, s.getLastName());
            pstmt.setInt(4, s.getAge());
            pstmt.setString(5, s.getGender());
            pstmt.setInt(6, s.getYearLvl());
            pstmt.setString(7, s.getCourse());
            pstmt.setString(8, s.getBloodtype());
            pstmt.setString(9, s.getAddress());
            pstmt.setString(10, s.getContact());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Save error: " + e.getMessage());
        }
    }

    // Requirement: Retrieve data using Student Objects
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM tbl_students";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Student(
                    rs.getInt("studentID"), rs.getString("FirstName"), rs.getString("LastName"),
                    rs.getString("Age"), rs.getString("Gender"), rs.getInt("Yearlvl"),
                    rs.getString("Course"), rs.getString("Bloodtype"), rs.getString("Address"),
                    rs.getInt("Contact")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
        return list;
    }
}
