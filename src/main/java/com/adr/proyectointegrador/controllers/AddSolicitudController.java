package com.adr.proyectointegrador.controllers;

import com.adr.proyectointegrador.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddSolicitudController implements Initializable {

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

    @FXML
    void onMouseClickedCancelar(MouseEvent event) {
        App.getStageView().close();
    }

    @FXML
    void onMouseClickedGenerar(MouseEvent event) {
        if (descripciónTextField.getText().trim().isEmpty() || tipoChoice.getValue().isEmpty() || descripciónTextField.getText().trim().isEmpty() || colorChoice.getValue().isEmpty() || aulaChoice.getValue().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("Complete los campos.");
            alert.showAndWait();
        }else {
            try {
                String tipo = tipoChoice.getValue();
                String descripcion = descripciónTextField.getText();
                String color = colorChoice.getValue();
                LocalDate fecha = fechaPicker.getValue();
                String aula = aulaChoice.getValue();

                if (App.getAplication().newSolicitud(tipo, descripcion, color, fecha, aula)){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Notificación");
                    alert.setContentText("se ha agregado correctamente.");
                    alert.showAndWait();
                    App.getStageView().close();
                }else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setContentText("No se ha podido agregar.");
                    alert.showAndWait();
                }

            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Error de semántica.");
                alert.showAndWait();
            }
        }

    }

    private String[] aula = {"UD1 - 10", "UD1 - 11", "UD1 - 2", "UD1 - 13", "UD1 - 14", "UD1 - 15", "UD1 - 16", "UD1 - 17", "UD1 - 18", "UD1 - 19", "UD1 - 20", "UD3 - 18", "UD3 - 21"};
    private String[] color = {"Rojo", "Azul", "Amarillo", "Verde", "Morado", "Naranja", "Café", "Negro", "Blanco", "Gris"};
    private String[] tipo = {"Celular", "Cartera", "Reloj", "Ropa", "Accesorios", "Libreta", "Computadora", "Mochila"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        aulaChoice.getItems().addAll(aula);
        colorChoice.getItems().addAll(color);
        tipoChoice.getItems().addAll(tipo);
    }
}