package com.example.trackitapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ReportsController {

    @FXML private Button btnDashboard;
    @FXML private Button btnAddExpenses;
    @FXML private Button btnViewExpenses;
    @FXML private Button btnSetBudget;
    @FXML private Button btnReports;
    @FXML private Button btnNotifications;
    @FXML private Button btnProfile;

    @FXML private Label lblTotalSpent;
    @FXML private Label lblDailyAverage;
    @FXML private Label lblTransactionCount;
    @FXML private Label lblCategoryCount;

    @FXML private AnchorPane monthlyChartPane;
    @FXML private AnchorPane categoryBreakdownPane;

    @FXML
    public void initialize() {
        loadReportData();
        setupNavigation();
    }

    private void loadReportData() {
        lblTotalSpent.setText("₱1500");
        lblDailyAverage.setText("₱300");
        lblTransactionCount.setText("14");
        lblCategoryCount.setText("5");
    }

    private void setupNavigation() {

        btnDashboard.setOnAction(e -> SceneNavigator.switchTo("Dashboard.fxml"));
        btnAddExpenses.setOnAction(e -> SceneNavigator.switchTo("AddExpenses.fxml"));
        btnViewExpenses.setOnAction(e -> SceneNavigator.switchTo("ViewExpenses.fxml"));
        btnSetBudget.setOnAction(e -> SceneNavigator.switchTo("SetBudget.fxml"));
        btnReports.setOnAction(e -> SceneNavigator.switchTo("Reports.fxml"));
        btnNotifications.setOnAction(e -> SceneNavigator.switchTo("Notifications.fxml"));
        btnProfile.setOnAction(e -> SceneNavigator.switchTo("ProfilePage.fxml"));
    }
}
