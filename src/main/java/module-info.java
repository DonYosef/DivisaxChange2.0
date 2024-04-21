module com.example.divisaxchange {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.net.http;
    requires java.security.jgss;
    requires com.google.gson;

    opens com.example.divisaxchange to javafx.fxml;
    exports com.example.divisaxchange;
    exports com.example.divisaxchange.controllers;
    exports com.example.divisaxchange.models;
    opens com.example.divisaxchange.controllers to javafx.fxml;
}