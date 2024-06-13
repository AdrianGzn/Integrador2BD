package com.adr.proyectointegrador.controllers;

import com.adr.proyectointegrador.App;
import com.adr.proyectointegrador.models.Usuario;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class LoginController {

    @FXML
    private Button cerrarButton;

    @FXML
    private TextField contraseñaTextField;

    @FXML
    private Button ingresarButton;

    @FXML
    private TextField matriculaTextField;

    @FXML
    void onMouseClickedCerrar(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void onMouseClickedIngresar(MouseEvent event) {
        if (matriculaTextField.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("Complete los campos.");
            alert.showAndWait();
        } else {
            int matricula = Integer.parseInt(matriculaTextField.getText());

            String tipo = App.getAplication().tipoUsuario(matricula);
            System.out.println(tipo);

            if (tipo.equals("admin")) {
                App.newStage("admin-view", "Vista administrador");
            } else if (tipo.equals("alumno")) {
                App.newStage("alumno-view", "Vista alumno");
            } else if (tipo.equals("null")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Tipo no encontrado.");
                alert.showAndWait();
            }
        }
    }
}