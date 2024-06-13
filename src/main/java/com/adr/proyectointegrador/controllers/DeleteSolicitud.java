package com.adr.proyectointegrador.controllers;

import com.adr.proyectointegrador.App;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class DeleteSolicitud {

    @FXML
    private Button cancelarButton;

    @FXML
    private Button eliminarButton;

    @FXML
    private TextField idTextField;

    @FXML
    void onMouseClickedCancelar(MouseEvent event) {
        App.getStageView().close();
    }

    @FXML
    void onMouseClickedEliminar(MouseEvent event) {
        if (idTextField.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("Complete los campos.");
            alert.showAndWait();
        }else {
            try {

                int id = Integer.parseInt(idTextField.getText());
                if (App.getAplication().eliminarSolicitud(id).equals("No eliminado")){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setContentText("No se ha podido eliminar la solicitud.");
                    alert.showAndWait();
                }else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Notificación");
                    alert.setContentText("Se ha eliminado la solicitud correctamente.");
                    alert.showAndWait();
                    App.getStageView().close();
                }

            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Ingrese datos numéricos.");
                alert.showAndWait();
            }
        }
    }

}