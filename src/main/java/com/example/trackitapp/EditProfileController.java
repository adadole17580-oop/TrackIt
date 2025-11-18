package com.example.trackitapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class EditProfileController {
    @FXML private Button updateProfileBtn;

    @FXML
    private void initialize() {
        updateProfileBtn.setOnAction(e -> SceneNavigator.switchTo("ProfilePage.fxml"));
    }
}
