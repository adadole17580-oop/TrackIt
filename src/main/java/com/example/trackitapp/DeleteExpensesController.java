package com.example.trackitapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DeleteExpensesController {
    @FXML private Button yesBtn;
    @FXML private Button noBtn;

    @FXML
    private void initialize() {
        yesBtn.setOnAction(e -> SceneNavigator.switchTo("ViewExpenses.fxml"));
        noBtn.setOnAction(e -> SceneNavigator.switchTo("ViewExpenses.fxml"));
    }
}
