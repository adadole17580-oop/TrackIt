package com.example.trackitapp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ProfileController {

    @FXML private Button btnDashboard;
    @FXML private Button btnAddExpenses;
    @FXML private Button btnViewExpenses;
    @FXML private Button btnSetBudgets;
    @FXML private Button btnReports;
    @FXML private Button btnNotifications;
    @FXML private Button btnProfile;

    @FXML private Label lblName;
    @FXML private Label lblEmail;
    @FXML private Label lblMemberDate;

    @FXML private Button btnEditProfile;
    @FXML private Button btnChangePassword;
    @FXML private Button btnLogout;
    @FXML private Button btnDeleteAccount;

    @FXML
    public void initialize() {
        lblName.setText("Anghel Dadole");
        lblEmail.setText("example@gmail.com");
        lblMemberDate.setText("Member since 2024");
    }

    @FXML private void goDashboard() { SceneNavigator.switchTo("Dashboard.fxml"); }
    @FXML private void goAddExpenses() { SceneNavigator.switchTo("AddExpenses.fxml"); }
    @FXML private void goViewExpenses() { SceneNavigator.switchTo("ViewExpenses.fxml"); }
    @FXML private void goSetBudgets() { SceneNavigator.switchTo("SetBudget.fxml"); }
    @FXML private void goReports() { SceneNavigator.switchTo("Reports.fxml"); }
    @FXML private void goNotifications() { SceneNavigator.switchTo("Notifications.fxml"); }
    @FXML private void goProfile() { SceneNavigator.switchTo("ProfilePage.fxml"); }


    @FXML
    private void editProfile() {
        SceneNavigator.switchTo("EditProfile.fxml");
    }

    @FXML
    private void changePassword() {
        SceneNavigator.switchTo("ChangePassword.fxml");
    }

    @FXML
    private void logoutAccount() {
        SceneNavigator.switchTo("LogOut.fxml");
    }

    @FXML
    private void deleteAccount() {
        SceneNavigator.switchTo("DeleteAccount.fxml");
    }

    private void info(String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText("Action");
        a.setContentText(msg);
        a.show();
    }
}
