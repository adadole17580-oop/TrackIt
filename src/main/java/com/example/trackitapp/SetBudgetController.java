package com.example.trackitapp;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SetBudgetController {

    @FXML private Button btnDashboard;
    @FXML private Button btnAddExpenses;
    @FXML private Button btnViewExpenses;
    @FXML private Button btnSetBudgets;
    @FXML private Button btnReports;
    @FXML private Button btnNotifications;
    @FXML private Button btnProfile;

    @FXML private TextField txtTotalBudget;
    @FXML private DatePicker dateBudgetPeriod;
    @FXML private ChoiceBox<String> choiceCategory;

    @FXML private Button btnCancel;
    @FXML private Button btnUpdateBudget;

    @FXML
    public void initialize() {
        choiceCategory.getItems().addAll(
                "Food", "Transportation", "Bills", "Shopping", "Others"
        );
    }

    @FXML
    private void goDashboard() {
        showInfo("Navigate", "Go to Dashboard");
        SceneNavigator.switchTo("Dashboard.fxml");
    }

    @FXML
    private void goAddExpenses() {
        showInfo("Navigate", "Go to Add Expenses");
        SceneNavigator.switchTo("AddExpenses.fxml");
    }

    @FXML
    private void goViewExpenses() {
        showInfo("Navigate", "Go to View Expenses");
        SceneNavigator.switchTo("ViewExpenses.fxml");
    }

    @FXML
    private void goSetBudgets() {
        showInfo("Navigate", "Already in Set Budgets");
        SceneNavigator.switchTo("SetBudget.fxml");
    }

    @FXML
    private void goReports() {
        showInfo("Navigate", "Go to Reports");
        SceneNavigator.switchTo("Reports.fxml");
    }

    @FXML
    private void goNotifications() {
        showInfo("Navigate", "Go to Notifications");
        SceneNavigator.switchTo("Notifications.fxml");
    }

    @FXML
    private void goProfile() {
        showInfo("Navigate", "Go to Profile");
        SceneNavigator.switchTo("ProfilePage.fxml");
    }


    @FXML
    private void cancelBudget() {
        txtTotalBudget.clear();
        dateBudgetPeriod.setValue(null);
        choiceCategory.setValue(null);

        showInfo("Canceled", "Budget reset.");
    }

    @FXML
    private void updateBudget() {

        String totalBudget = txtTotalBudget.getText();
        var period = dateBudgetPeriod.getValue();
        String category = choiceCategory.getValue();

        if (totalBudget.isEmpty() || period == null) {
            showError("Missing Fields", "Please complete the required fields.");
            return;
        }

        showInfo("Budget Updated",
                "Total Budget: " + totalBudget +
                        "\nMonth: " + period +
                        "\nCategory: " + (category == null ? "None" : category)
        );
    }

    private void showInfo(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.show();
    }

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.show();
    }
}
