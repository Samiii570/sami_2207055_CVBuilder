module sami_2207055_CVBuilder {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.cvbuilder to javafx.fxml;
    opens com.example.cvbuilder.controller to javafx.fxml;
    opens com.example.cvbuilder.model to javafx.fxml;

    exports com.example.cvbuilder;
    exports com.example.cvbuilder.controller;
}
