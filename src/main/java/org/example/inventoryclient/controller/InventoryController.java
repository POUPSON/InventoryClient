package org.example.inventoryclient.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.example.inventoryclient.model.Item;
import org.example.inventoryclient.service.InventoryService;

public class InventoryController {

    @FXML
    private TableView<Item> Component;

    @FXML
    private TableColumn<Item, Node> collactions;

    @FXML
    private TableColumn<Item, String> collproduct;

    @FXML
    private TableColumn<Item, Integer> collquantity;

    @FXML
    private TableColumn<Item, Integer> collvalue;

    @FXML
    private void initialize() {
        collproduct.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getName()));
        collquantity.setCellValueFactory(param -> new SimpleIntegerProperty(param.getValue().getQuantityInStock()).asObject());
        collvalue.setCellValueFactory(param -> new SimpleIntegerProperty(param.getValue().getValueInStock()).asObject());

        new Thread(() -> {
            try {
                final var result = InventoryService.getItems();
                System.out.println(result);
            } catch (Throwable e) {
                e.printStackTrace(System.err);
            }
        }).start();
    }
}