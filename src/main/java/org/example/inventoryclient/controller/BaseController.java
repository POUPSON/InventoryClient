package org.example.inventoryclient.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class BaseController {

    @FXML
    private BorderPane root;

    public void setContent(Node content) {
        root.setCenter(content);
    }
}
