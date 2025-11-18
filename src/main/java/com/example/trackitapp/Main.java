package com.example.trackitapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        SceneNavigator.setStage(primaryStage);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignIn.fxml"));
        Scene scene = new Scene(loader.load());

        primaryStage.setTitle("Expense Tracker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
