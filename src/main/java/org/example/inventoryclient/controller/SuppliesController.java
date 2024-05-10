package org.example.inventoryclient.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import org.example.inventoryclient.model.Item;

public class SuppliesController {

    @FXML
    private TableColumn<Item, Integer> colNames;

    @FXML
    private TableColumn<Item, Integer> colDate;

    @FXML
    private TableColumn<Item, Integer> colContacts;

}
