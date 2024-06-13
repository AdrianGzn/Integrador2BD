package com.adr.proyectointegrador.controllers;

import com.adr.proyectointegrador.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class AdminController {

    @FXML
    private Button cerrarButton;

    @FXML
    private Button eliminarReporteButton;

    @FXML
    private Button eliminarSolicitudButton;

    @FXML
    private Button statusReporteButton;

    @FXML
    private Button statusSolicitudButton;

    @FXML
    private Button verReportesButton;

    @FXML
    private Button verSolicitudesButton;

    @FXML
    void onMouseClickedButtonEliminarReporte(MouseEvent event) {
        App.newStage("delete-reporte-view", "Eliminar reporte");
    }

    @FXML
    void onMouseClickedCerrarButton(MouseEvent event) {
        App.getStageView().close();
    }

    @FXML
    void onMouseClickedEliminarSolicitud(MouseEvent event) {
        App.newStage("delete-solicitud-view", "Eliminar solicitud");
    }

    @FXML
    void onMouseClickedStatusReporte(MouseEvent event) {
        App.newStage("status-reporte-view", "Cambiar status");
    }

    @FXML
    void onMouseClickedStatusSolicitud(MouseEvent event) {
        App.newStage("status-solicitud-view", "Cambiar estatus");
    }

    @FXML
    void onMouseClickedVerReportes(MouseEvent event) {
        App.newStage("show-reportes-view", "Ver reportes");
    }

    @FXML
    void onMouseClickedVerSolicitudes(MouseEvent event) {
        App.newStage("show-solicitudes-view", "Ver reportes");
    }

}