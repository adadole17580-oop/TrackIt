package com.example.trackitapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DashboardController {

    @FXML private Button addExpensesBtn;
    @FXML private Button viewExpensesBtn;
    @FXML private Button setBudgetsBtn;
    @FXML private Button reportsBtn;
    @FXML private Button notificationsBtn;
    @FXML private Button profileBtn;

    @FXML
    private void initialize() {

        addExpensesBtn.setOnAction(e ->
                SceneNavigator.switchTo("AddExpenses.fxml")
        );

        viewExpensesBtn.setOnAction(e ->
                SceneNavigator.switchTo("ViewExpenses.fxml")
        );

        setBudgetsBtn.setOnAction(e ->
                SceneNavigator.switchTo("SetBudget.fxml")
        );

        reportsBtn.setOnAction(e ->
                SceneNavigator.switchTo("Reports.fxml")
        );

        notificationsBtn.setOnAction(e ->
                SceneNavigator.switchTo("Notifications.fxml")
        );

        profileBtn.setOnAction(e ->
                SceneNavigator.switchTo("ProfilePage.fxml")
        );
    }
}
