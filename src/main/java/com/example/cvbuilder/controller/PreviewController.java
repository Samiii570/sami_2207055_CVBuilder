package com.example.cvbuilder.controller;

import com.example.cvbuilder.database.Database;
import com.example.cvbuilder.model.CV;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PreviewController {

    @FXML private Label nameLabel;
    @FXML private Label emailLabel;
    @FXML private Label phoneLabel;
    @FXML private Label addressLabel;
    @FXML private Label educationLabel;
    @FXML private Label skillsLabel;
    @FXML private Label experienceLabel;
    @FXML private Label projectsLabel;

    // Use a simple Database instance (stateless) — feel free to change to a singleton if preferred
    private final Database db = new Database();

    /**
     * Set CV data into preview page and store into database.
     */
    public void setCV(CV cv) {
        if (cv == null) return;

        nameLabel.setText(nullSafe(cv.getFullName()));
        emailLabel.setText(nullSafe(cv.getEmail()));
        phoneLabel.setText(nullSafe(cv.getPhone()));
        addressLabel.setText(nullSafe(cv.getAddress()));
        educationLabel.setText(nullSafe(cv.getEducation()));
        skillsLabel.setText(nullSafe(cv.getSkills()));
        experienceLabel.setText(nullSafe(cv.getExperience()));
        projectsLabel.setText(nullSafe(cv.getProjects()));

        // save to database (uses saveCV which matches your DB schema)
        db.saveCV(cv);
    }

    private String nullSafe(String s) {
        return s == null ? "" : s;
    }
}
