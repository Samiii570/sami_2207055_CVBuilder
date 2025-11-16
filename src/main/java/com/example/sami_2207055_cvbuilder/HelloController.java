package com.example.sami_2207055_cvbuilder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Sami 1234");
    }
}
// git add .
// git commit -m "Checking commit"
// git push origin main
