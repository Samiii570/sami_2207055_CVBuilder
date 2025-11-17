package com.example.cvbuilder.controller;

import com.example.cvbuilder.model.CV;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PreviewController {

    @FXML
    private VBox cvContainer;

    public void setCV(CV cv) {

        cvContainer.getChildren().clear();

        cvContainer.getChildren().add(new Label("Full Name: " + cv.fullName));
        cvContainer.getChildren().add(new Label("Email: " + cv.email));
        cvContainer.getChildren().add(new Label("Phone: " + cv.phone));
        cvContainer.getChildren().add(new Label("Address: " + cv.address));
        cvContainer.getChildren().add(new Label("Education: " + cv.education));
        cvContainer.getChildren().add(new Label("Skills: " + cv.skills));
        cvContainer.getChildren().add(new Label("Experience: " + cv.experience));
        cvContainer.getChildren().add(new Label("Projects: " + cv.projects));
    }
}
