package com.example.trackitapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class EditExpensesController {
    @FXML private Button cancelBtn;
    @FXML private Button updateExpenseBtn;

    @FXML
    private void initialize() {

        cancelBtn.setOnAction(e -> SceneNavigator.switchTo("ViewExpenses.fxml"));
        updateExpenseBtn.setOnAction(e -> SceneNavigator.switchTo("ViewExpenses.fxml"));
    }
}
