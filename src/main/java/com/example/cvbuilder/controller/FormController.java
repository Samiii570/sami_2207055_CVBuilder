package com.example.cvbuilder.controller;

import com.example.cvbuilder.Main;
import com.example.cvbuilder.model.CV;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FormController {

    @FXML private TextField fullNameField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;
    @FXML private TextField addressField;

    @FXML private TextArea educationField;
    @FXML private TextArea skillsField;
    @FXML private TextArea experienceField;
    @FXML private TextArea projectsField;

    @FXML private Label submissionMessage;

    @FXML
    public void generateCV(ActionEvent event) {
        try {
            CV cv = new CV();
            cv.fullName = fullNameField.getText();
            cv.email = emailField.getText();
            cv.phone = phoneField.getText();
            cv.address = addressField.getText();
            cv.education = educationField.getText();
            cv.skills = skillsField.getText();
            cv.experience = experienceField.getText();
            cv.projects = projectsField.getText();

            submissionMessage.setText("Thank you for your submission!");
            submissionMessage.setVisible(true);

            PauseTransition delay = new PauseTransition(Duration.seconds(1.5));
            delay.setOnFinished(e -> {
                try {
                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("preview-view.fxml"));
                    Parent root = loader.load();

                    PreviewController controller = loader.getController();
                    controller.setCV(cv);

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.show();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });

            delay.play();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
