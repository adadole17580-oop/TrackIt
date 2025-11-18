package com.example.trackitapp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class NotificationsController {

    @FXML private Button btnDashboard;
    @FXML private Button btnAddExpenses;
    @FXML private Button btnViewExpenses;
    @FXML private Button btnSetBudgets;
    @FXML private Button btnReports;
    @FXML private Button btnNotifications;
    @FXML private Button btnProfile;

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

    private void showInfo(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(title);
        alert.setContentText(content);
        alert.show();
    }
}
