package org.example.inventoryclient;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Properties;

public class InventoryApplication extends Application {
    @Override
    public void init() throws Exception {
        try (var stream = InventoryApplication.class.getResourceAsStream("/.env.properties")) {
            final var properties = new Properties();
            final var systemProperties = System.getProperties();
            properties.load(stream);
            systemProperties.putAll(properties);
            System.setProperties(systemProperties);
        }
    }

    @Override
    public void start(Stage stage) {
        StageManager.initialize(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}