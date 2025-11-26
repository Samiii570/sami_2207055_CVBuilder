module com.example.cvbuilder {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.cvbuilder to javafx.fxml;
    opens com.example.cvbuilder.controller to javafx.fxml;
    opens com.example.cvbuilder.model to javafx.fxml;

    exports com.example.cvbuilder;
}
