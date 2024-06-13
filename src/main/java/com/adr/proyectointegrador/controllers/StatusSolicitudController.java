package com.adr.proyectointegrador.controllers;

import com.adr.proyectointegrador.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class StatusSolicitudController implements Initializable {

    private String[] estado = {"Resuelto", "No resuelto"};


    @FXML
    private Button cancelButton;

    @FXML
    private TextField idTextField;

    @FXML
    private Button saveButton;

    @FXML
    private ChoiceBox<String> statusCoice;

    @FXML
    void onMouseClickedCancel(MouseEvent event) {
        App.getStageView().close();
    }

    @FXML
    void onMouseClickedSave(MouseEvent event) {
        if (idTextField.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("Complete los campos.");
            alert.showAndWait();
        }else {
                int id = Integer.parseInt(idTextField.getText());
                String status = statusCoice.getValue();

                if (status.trim().isEmpty()){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setContentText("Complete los campos.");
                    alert.showAndWait();
                }else {
                    if (App.getAplication().changeStatusSolicitud(id, status)){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Notificación");
                        alert.setContentText("Estado cambiado correctamente.");
                        alert.showAndWait();
                    }else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Error");
                        alert.setContentText("No se ha podido modificar el estado.");
                        alert.showAndWait();
                    }
                }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.statusCoice.getItems().addAll(estado);
    }
}
