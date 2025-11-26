package com.example.cvbuilder.database;

import com.example.cvbuilder.model.CV;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    // Make sure app.db is in the project root (or change path accordingly)
    private static final String DB_URL = "jdbc:sqlite:app.db";

    public Database() {}

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    /**
     * Primary save method.
     */
    public void saveCV(CV cv) {
        String sql = "INSERT INTO cv (fullName, email, phone, address, education, skills, experience, projects) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cv.getFullName());
            ps.setString(2, cv.getEmail());
            ps.setString(3, cv.getPhone());
            ps.setString(4, cv.getAddress());
            ps.setString(5, cv.getEducation());
            ps.setString(6, cv.getSkills());
            ps.setString(7, cv.getExperience());
            ps.setString(8, cv.getProjects());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Backwards-compatible method name used elsewhere in the project.
     * Delegates to saveCV so older calls to insertCV(...) won't break.
     */
    public void insertCV(CV cv) {
        saveCV(cv);
    }

    public List<CV> getAllCVs() {
        List<CV> list = new ArrayList<>();
        String sql = "SELECT fullName, email, phone, address, education, skills, experience, projects FROM cv";

        try (Connection conn = connect();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new CV(
                        rs.getString("fullName"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("education"),
                        rs.getString("skills"),
                        rs.getString("experience"),
                        rs.getString("projects")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
