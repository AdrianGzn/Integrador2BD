module com.adr.proyectointegrador {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.adr.proyectointegrador to javafx.fxml;
    exports com.adr.proyectointegrador;
    exports com.adr.proyectointegrador.controllers;
    exports com.adr.proyectointegrador.models;
    opens com.adr.proyectointegrador.controllers to javafx.fxml;
}