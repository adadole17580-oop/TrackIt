package com.example.trackitapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LogoutController {
    @FXML private Button yesBtn;
    @FXML private Button noBtn;

    @FXML
    private void initialize() {
        yesBtn.setOnAction(e -> SceneNavigator.switchTo("SignIn.fxml"));
        noBtn.setOnAction(e -> SceneNavigator.switchTo("ProfilePage.fxml"));
    }
}
