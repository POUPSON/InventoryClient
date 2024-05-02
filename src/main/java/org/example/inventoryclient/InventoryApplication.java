package org.example.inventoryclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Properties;

public class InventoryApplication extends Application {
    @Override
    public void init() throws Exception {
        try(var stream = InventoryApplication.class.getResourceAsStream("/.env.properties")){
            final var properties = new Properties();
            properties.load(stream);
            System.setProperties(properties);
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
       StageManager.initialize(stage );
    }

    public static void main(String[] args) {
        launch();
    }
}