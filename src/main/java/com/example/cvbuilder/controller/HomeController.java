package com.example.cvbuilder.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.cvbuilder.Main;

import java.io.IOException;

public class HomeController {

    @FXML
    private void goToForm(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("form-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
