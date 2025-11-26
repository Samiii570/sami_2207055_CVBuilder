package com.example.cvbuilder.controller;


import com.example.cvbuilder.Main;
import com.example.cvbuilder.model.CV;
import com.example.cvbuilder.database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
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


    // Set CV data into preview page and store into database
    public void setCV(CV cv) {
        nameLabel.setText(cv.fullName);
        emailLabel.setText(cv.email);
        phoneLabel.setText(cv.phone);
        addressLabel.setText(cv.address);


        educationLabel.setText(cv.education);
        skillsLabel.setText(cv.skills);
        experienceLabel.setText(cv.experience);
        projectsLabel.setText(cv.projects);


// Save to SQLite database (app.db in working directory)
        try {
            Database.getInstance().insertCV(cv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Back button → Returns to form page
    @FXML
    public void goBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("form-view.fxml"));
            Parent root = loader.load();


            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}