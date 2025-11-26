package com.example.cvbuilder.controller;

import com.example.cvbuilder.model.CV;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FormController {

    @FXML private TextField fullNameField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;
    @FXML private TextField addressField;

    @FXML private TextArea educationField;
    @FXML private TextArea skillsField;
    @FXML private TextArea experienceField;
    @FXML private TextArea projectsField;

    @FXML
    public void generateCV(ActionEvent event) {
        try {
            String fullName = fullNameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String address = addressField.getText();
            String education = educationField.getText();
            String skills = skillsField.getText();
            String experience = experienceField.getText();
            String projects = projectsField.getText();

            // Create CV object
            CV cv = new CV(
                    fullName, email, phone, address,
                    education, skills, experience, projects
            );

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/preview-view.fxml"));
            Parent root = loader.load();

            PreviewController controller = loader.getController();
            controller.setCV(cv);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
