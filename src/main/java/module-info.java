module org.example.inventoryclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires lombok;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;

    opens org.example.inventoryclient.controller to javafx.fxml;
    exports org.example.inventoryclient;
}