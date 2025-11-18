package com.example.trackitapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignInController {

    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;

    @FXML private Button signInBtn;
    @FXML private Button goToSignUpBtn;

    @FXML private Button submitSignInBtn;

    @FXML
    private void initialize() {

        signInBtn.setOnAction(e ->
                SceneNavigator.switchTo("SignIn.fxml")
        );

        goToSignUpBtn.setOnAction(e ->
                SceneNavigator.switchTo("SignUp.fxml")
        );

        submitSignInBtn.setOnAction(e -> handleSubmitSignIn());
    }

    private void handleSubmitSignIn() {
        String email = emailField.getText().trim();
        String pass  = passwordField.getText().trim();

        if (email.isEmpty() || pass.isEmpty()) {
            System.out.println("Please fill all fields.");
            return;
        }

        SceneNavigator.switchTo("Dashboard.fxml");
    }
}
