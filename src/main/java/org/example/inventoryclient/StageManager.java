package org.example.inventoryclient;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.inventoryclient.controller.BaseController;

import java.io.IOException;
import java.util.*;

public class StageManager {

    private static final Map<String, Map.Entry<Parent, Object>> viewControllerMap = new HashMap<>();
    private static BaseController baseController;

    public static void initialize(Stage stage) {
        try {
            final var baseViewAndController = loadViewAndController("base_view.fxml").orElseThrow();
            Scene scene = new Scene(baseViewAndController.getKey());
            baseController = (BaseController) baseViewAndController.getValue();
            stage.setTitle("Inventory");
            stage.setScene(scene);
            stage.show();
        } catch (NoSuchElementException ex) {
            ex.printStackTrace(System.err);
            System.exit(1);
        }
    }

    public static void navigate(String view) {
        Platform.runLater(() -> {
            try {
                final var viewAndController = loadViewAndController(view);
                viewAndController.ifPresent(value -> baseController.setContent(value.getKey()));
            } catch (Exception ex) {
                ex.printStackTrace(System.err);
            }
        });
    }

    private static Optional<Map.Entry<Parent, Object>> loadViewAndController(String view) {
        return Optional.of(viewControllerMap.computeIfAbsent(view, viewName -> {
            try {
                return loadView(viewName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }));
    }

    private static Map.Entry<Parent, Object> loadView(String viewName) throws IOException {
        final var url = StageManager.class.getResource("/views/" + viewName);

        var loader = new FXMLLoader(url);
        var parent = (Parent) loader.load();
        var controller = loader.getController();

        return new AbstractMap.SimpleEntry<>(parent, controller);
    }

}
