package com.example.trackitapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ChangePasswordController {
    @FXML private Button changePasswordBtn;

    @FXML
    private void initialize() {
        changePasswordBtn.setOnAction(e -> SceneNavigator.switchTo("ProfilePage.fxml"));
    }
}
