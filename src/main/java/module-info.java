module org.example.inventoryclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    requires javafx.web;
    requires lombok;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;

    opens org.example.inventoryclient.controller to javafx.fxml;
    opens org.example.inventoryclient.dto to com.fasterxml.jackson.databind;
    opens org.example.inventoryclient.model to com.fasterxml.jackson.databind;
    exports org.example.inventoryclient;
}