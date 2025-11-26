package com.example.cvbuilder.database;

import com.example.cvbuilder.model.CV;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private static Database instance;
    private Connection conn;
    private static final String DB_URL = "jdbc:sqlite:app.db";

    private Database() {
        init();
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    private void init() {
        try {
            conn = DriverManager.getConnection(DB_URL);

            String sql = """
                    CREATE TABLE IF NOT EXISTS cvs(
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        fullName TEXT,
                        email TEXT,
                        phone TEXT,
                        address TEXT,
                        education TEXT,
                        skills TEXT,
                        experience TEXT,
                        projects TEXT
                    );
                    """;

            Statement st = conn.createStatement();
            st.execute(sql);
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCV(CV cv) {
        String sql = "INSERT INTO cvs(fullName,email,phone,address,education,skills,experience,projects) VALUES(?,?,?,?,?,?,?,?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cv.fullName);
            ps.setString(2, cv.email);
            ps.setString(3, cv.phone);
            ps.setString(4, cv.address);
            ps.setString(5, cv.education);
            ps.setString(6, cv.skills);
            ps.setString(7, cv.experience);
            ps.setString(8, cv.projects);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CV> getAllCVs() {
        List<CV> list = new ArrayList<>();
        String sql = "SELECT * FROM cvs ORDER BY id DESC";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                CV cv = new CV();
                cv.fullName = rs.getString("fullName");
                cv.email = rs.getString("email");
                cv.phone = rs.getString("phone");
                cv.address = rs.getString("address");
                cv.education = rs.getString("education");
                cv.skills = rs.getString("skills");
                cv.experience = rs.getString("experience");
                cv.projects = rs.getString("projects");

                list.add(cv);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
