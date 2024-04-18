package org.example.inventoryclient.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.example.inventoryclient.StageManager;

import java.io.IOException;
import java.util.concurrent.AbstractExecutorService;

public class BaseController {



    @FXML
    private BorderPane root;

    @FXML
    private Button btnInventory;

    @FXML
    private Button  btnSupplies;

    //Asigner a chaque fxid de chaque bouton la fonction navigate ayant en parametre le
    // fichier.xml kils pourront ouvrir
    @FXML
    private void initialize() {
        btnInventory.setOnAction(event -> {
            StageManager.navigate("inventory.fxml");
        });
        btnSupplies.setOnAction(event -> {
                StageManager.navigate("supply.fxml");
    });

    }


    public void setContent(Node content) {
        root.setCenter(content);
    }
}
