package com.example.cvbuilder.controller;

import com.example.cvbuilder.database.Database;
import com.example.cvbuilder.model.CV;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class HistoryController {

    @FXML
    private ListView<String> historyList;

    private final Database db = new Database();

    @FXML
    public void initialize() {
        loadData();
    }

    private void loadData() {
        historyList.getItems().clear();
        List<CV> cvs = db.getAllCVs();
        for (CV cv : cvs) {
            // Use getFullName() (model uses that name) — don't call getName()
            String display = cv.getFullName() + " | " + cv.getEmail() + " | " + cv.getPhone();
            historyList.getItems().add(display);
        }
    }
}
