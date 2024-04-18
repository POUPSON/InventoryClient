package org.example.inventoryclient;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.inventoryclient.controller.BaseController;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class StageManager {


    private static Stage stage;

    private static final Map<String, Map.Entry<Parent, Object>> viewControllerMap = new HashMap<>();
    private static BaseController baseController;

    public static void initialize(Stage stage) throws IOException {
        StageManager.stage = stage;

        final var baseViewAndController = loadViewAndController("base_view.fxml");
        Scene scene = new Scene(baseViewAndController.getKey());
        baseController = (BaseController) baseViewAndController.getValue();
        stage.setTitle("Inventory");
        stage.setScene(scene);
        stage.show();
    }
//Fonction qui permet de naviguer de page en page kan on clique sur le bouton
    public static void navigate(String view) {
        final var viewAndController = loadViewAndController(view);
        baseController.setContent(viewAndController.getKey());
    }

    private static Map.Entry<Parent, Object> loadViewAndController(String view) {
        return viewControllerMap.computeIfAbsent(view, s -> {
            try {
                var loader = new FXMLLoader(StageManager.class.getResource("/views/" + s));
                var parent = (Parent) loader.load();
                var c = loader.getController();

                return new AbstractMap.SimpleEntry<Parent, Object>(parent, c);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

}
