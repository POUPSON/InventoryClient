package org.example.inventoryclient.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.example.inventoryclient.model.Item;
import org.example.inventoryclient.service.InventoryService;

public class InventoryController {

    @FXML
    private TableView<Item> component;

    @FXML
    private TableColumn<Item, Node> collactions;

    @FXML
    private TableColumn<Item, String> collproduct;

    @FXML
    private TableColumn<Item, Integer> collquantity;

    @FXML
    private TableColumn<Item, Integer> collvalue;
    private final ObservableList<Item> items = FXCollections.observableArrayList();
    @FXML
    private void initialize() {
        component.setItems(items);
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