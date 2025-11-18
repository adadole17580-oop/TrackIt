package com.example.trackitapp;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class AddExpensesController {

    @FXML private TextField amountField;
    @FXML private ChoiceBox<String> categoryChoice;
    @FXML private DatePicker datePicker;
    @FXML private TextField notesField;

    @FXML private Button cancelBtn;
    @FXML private Button saveBtn;

    @FXML private Label messageLabel;

    @FXML private Button addExpensesBtn;
    @FXML private Button viewExpensesBtn;
    @FXML private Button setBudgetsBtn;
    @FXML private Button reportsBtn;
    @FXML private Button notificationsBtn;
    @FXML private Button profileBtn;

    @FXML
    public void initialize() {

        categoryChoice.getItems().addAll(
                "Food", "Transportation", "Bills", "Shopping", "Others"
        );

        cancelBtn.setOnAction(this::cancelAction);
        saveBtn.setOnAction(this::saveAction);
    }

    private void cancelAction(ActionEvent e) {
        SceneNavigator.switchTo("Dashboard.fxml");
    }

    private void saveAction(ActionEvent e) {
        String amount = amountField.getText().trim();

        if (amount.isEmpty()) {
            messageLabel.setText("Amount is required.");
            return;
        }

        if (categoryChoice.getValue() == null) {
            messageLabel.setText("Please select a category.");
            return;
        }

        if (datePicker.getValue() == null) {
            messageLabel.setText("Pick a date.");
            return;
        }

        messageLabel.setText("Saved successfully!");
        amountField.clear();
        notesField.clear();

        addExpensesBtn.setOnAction(ActionEvent ->
                SceneNavigator.switchTo("AddExpenses.fxml")
        );

        viewExpensesBtn.setOnAction(ActionEvent ->
                SceneNavigator.switchTo("ViewExpenses.fxml")
        );

        setBudgetsBtn.setOnAction(ActionEvent ->
                SceneNavigator.switchTo("SetBudget.fxml")
        );

        reportsBtn.setOnAction(ActionEvent ->
                SceneNavigator.switchTo("Reports.fxml")
        );

        notificationsBtn.setOnAction(ActionEvent ->
                SceneNavigator.switchTo("Notifications.fxml")
        );

        profileBtn.setOnAction(ActionEvent ->
                SceneNavigator.switchTo("ProfilePage.fxml")
        );
    }
}
