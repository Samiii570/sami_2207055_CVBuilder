package com.example.cvbuilder.controller;

import com.example.cvbuilder.model.CV;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PreviewController {

    @FXML private VBox cvContainer;

    public void setCV(CV cv) {
        cvContainer.getChildren().addAll(
                new Label("Full Name: " + cv.fullName),
                new Label("Email: " + cv.email),
                new Label("Phone: " + cv.phone),
                new Label("Address: " + cv.address),
                new Label("Education: " + cv.education),
                new Label("Skills: " + cv.skills),
                new Label("Experience: " + cv.experience),
                new Label("Projects: " + cv.projects)
        );
    }
}
