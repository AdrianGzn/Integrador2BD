package com.adr.proyectointegrador.controllers;

import com.adr.proyectointegrador.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class AlumnonController {
    @FXML
    private Button cerrarButton;

    @FXML
    private Button deleteMyReporteButton;

    @FXML
    private Button deleteMySolicitudButton;

    @FXML
    private Button generateReporteButton;

    @FXML
    private Button generateSolicitudButton;

    @FXML
    private Label miLabel;

    @FXML
    private Button showMyReportesButton;

    @FXML
    private Button showMySolicitudesButton;

    @FXML
    private Button showReportesButton;

    @FXML
    private Button showSolicitudesButton;
    @FXML
    void onMouseClickedCerrar(MouseEvent event) {
        App.getStageView().close();
    }

    @FXML
    void onMouseClickedDeleteMyReporte(MouseEvent event) {
        App.newStage("delete-reporte-view", "Eliminar reporte");
    }

    @FXML
    void onMouseClickedDeleteMysolicitud(MouseEvent event) {
        App.newStage("delete-solicitud-view", "Eliminar solicitud");
    }

    @FXML
    void onMouseClickedGenerateSolicitud(MouseEvent event) {
        App.newStage("add-solicitud-view", "Generar solicitud");
    }

    @FXML
    void onMouseClickedShowMyReportes(MouseEvent event) {
        App.newStage("show-my-reportes-view", "Mis reportes");
    }

    @FXML
    void onMouseClickedShowMySolicitudes(MouseEvent event) {
        App.newStage("show-my-solicitudes-view", "Mis solicitudes");
    }

    @FXML
    void onMouseClickedShowReportes(MouseEvent event) {
        App.newStage("show-reportes-view", "Ver reportes");
    }

    @FXML
    void onMouseClickedShowSolicitudes(MouseEvent event) {
        App.newStage("show-solicitudes-view", "Ver solicitudes");
    }

    @FXML
    void onMouseClickedGenerateReporte(MouseEvent event) {
        App.newStage("add-reporte-view", "Generar reporte");
    }

}
