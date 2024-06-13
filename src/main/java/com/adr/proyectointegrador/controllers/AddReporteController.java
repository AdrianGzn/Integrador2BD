package com.adr.proyectointegrador.controllers;

import com.adr.proyectointegrador.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddReporteController implements Initializable {

    @FXML
    private ChoiceBox<String> aulaChoice;

    @FXML
    private Button cancelarButton;

    @FXML
    private ChoiceBox<String> colorChoice;

    @FXML
    private TextField descripciónTextField;

    @FXML
    private DatePicker fechaPicker;

    @FXML
    private Button generarButton;

    @FXML
    private ChoiceBox<String> tipoChoice;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/incidencias";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "123456";

    public AddReporteController() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            if (connection != null) {
                System.out.println("Conexión establecida");
            }
        } catch (SQLException e) {
            System.out.println("Algo falló: " + e.getMessage());
        }
    }

    @FXML
    void onMouseClickedCancelar(MouseEvent event) {
        App.getStageView().close();
    }

    @FXML
    void onMouseClickedGenerar(MouseEvent event) {
        if (descripciónTextField.getText().trim().isEmpty() || tipoChoice.getValue().isEmpty() ||
                colorChoice.getValue().isEmpty() || aulaChoice.getValue().isEmpty() || fechaPicker.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("Complete los campos.");
            alert.showAndWait();
        } else {
            String tipo = tipoChoice.getValue();
            String descripcion = descripciónTextField.getText();
            String color = colorChoice.getValue();
            LocalDate fecha = fechaPicker.getValue();
            String aula = aulaChoice.getValue();

            String sql = "INSERT INTO reportess (tipo, status, color, fecha, aula) VALUES (?, ?, ?, ?, ?)";

            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, tipo);
                preparedStatement.setString(2, descripcion);
                preparedStatement.setString(3, color);
                preparedStatement.setDate(4, java.sql.Date.valueOf(fecha));
                preparedStatement.setString(5, aula);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Notificación");
                    alert.setContentText("Se ha agregado correctamente.");
                    alert.showAndWait();
                    App.getStageView().close();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setContentText("No se ha podido agregar.");
                    alert.showAndWait();
                }
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Error de base de datos: " + e.getMessage());
                alert.showAndWait();
            }
        }
    }

    private final String[] aula = {"UD1 - 10", "UD1 - 11", "UD1 - 2", "UD1 - 13", "UD1 - 14", "UD1 - 15", "UD1 - 16", "UD1 - 17", "UD1 - 18", "UD1 - 19", "UD1 - 20", "UD3 - 18", "UD3 - 21"};
    private final String[] color = {"Rojo", "Azul", "Amarillo", "Verde", "Morado", "Naranja", "Café", "Negro", "Blanco", "Gris"};
    private final String[] tipo = {"Celular", "Cartera", "Reloj", "Ropa", "Accesorios", "Libreta", "Computadora", "Mochila"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        aulaChoice.getItems().addAll(aula);
        colorChoice.getItems().addAll(color);
        tipoChoice.getItems().addAll(tipo);
    }
}
