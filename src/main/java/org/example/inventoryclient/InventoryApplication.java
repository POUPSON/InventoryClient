package org.example.inventoryclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InventoryApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
       StageManager.initialize(stage );
    }

    public static void main(String[] args) {
        launch();
    }
}