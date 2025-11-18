package com.example.trackitapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML private TextField fullNameField;
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;

    @FXML private Button goToSignInBtn;
    @FXML private Button signUpTabBtn;

    @FXML private Button createAccountBtn;

    @FXML
    private void initialize() {

        if (goToSignInBtn != null) {
            goToSignInBtn.setOnAction(e ->
                    SceneNavigator.switchTo("SignIn.fxml")
            );
        }

        if (signUpTabBtn != null) {
            signUpTabBtn.setOnAction(e ->
                    SceneNavigator.switchTo("SignUp.fxml")
            );
        }

        createAccountBtn.setOnAction(e -> {
            SceneNavigator.switchTo("Dashboard.fxml");
        });
    }
}
