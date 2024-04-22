package org.example.inventoryclient.controller;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.controlsfx.control.action.Action;
import org.example.inventoryclient.model.Item;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

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


    }
}