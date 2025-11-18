package com.example.trackitapp;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ViewExpensesController {

    @FXML private Button dashboardBtn;
    @FXML private Button addExpensesBtn;
    @FXML private Button viewExpensesBtn;
    @FXML private Button setBudgetsBtn;
    @FXML private Button reportsBtn;
    @FXML private Button notificationsBtn;
    @FXML private Button profileBtn;
    @FXML private Button editExpensesBtn;
    @FXML private Button deleteExpensesBtn;

    @FXML private TextField searchField;
    @FXML private ComboBox<String> itemsFilter;
    @FXML private ComboBox<String> categoryFilter;

    @FXML
    private void initialize() {

        dashboardBtn.setOnAction(e -> SceneNavigator.switchTo("Dashboard.fxml"));
        addExpensesBtn.setOnAction(e -> SceneNavigator.switchTo("AddExpenses.fxml"));
        viewExpensesBtn.setOnAction(e -> SceneNavigator.switchTo("ViewExpenses.fxml"));
        setBudgetsBtn.setOnAction(e -> SceneNavigator.switchTo("SetBudget.fxml"));
        reportsBtn.setOnAction(e -> SceneNavigator.switchTo("Reports.fxml"));
        notificationsBtn.setOnAction(e -> SceneNavigator.switchTo("Notifications.fxml"));
        profileBtn.setOnAction(e -> SceneNavigator.switchTo("ProfilePage.fxml"));
        editExpensesBtn.setOnAction(e -> SceneNavigator.switchTo("EditExpenses.fxml"));
        deleteExpensesBtn.setOnAction(e -> SceneNavigator.switchTo("DeleteExpense.fxml"));

        itemsFilter.getItems().addAll("All Items", "Recent", "Oldest");
        categoryFilter.getItems().addAll("All Categories", "Food", "Bills", "Shopping", "Others");
    }
}
