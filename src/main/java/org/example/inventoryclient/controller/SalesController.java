package org.example.inventoryclient.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import org.example.inventoryclient.model.Item;

public class SalesController {

    @FXML
    private TableColumn<Item, String> colProduct;

    @FXML
    private TableColumn<Item, Integer> colUnitsold;

    @FXML
    private TableColumn<Item, Integer> colClient;

    @FXML
    private TableColumn<Item, Integer> colDate;

    @FXML
    private TableColumn<Item, Integer> colStatus;

}
