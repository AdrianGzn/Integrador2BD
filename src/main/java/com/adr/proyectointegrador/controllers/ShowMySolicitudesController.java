package com.adr.proyectointegrador.controllers;

import com.adr.proyectointegrador.App;
import com.adr.proyectointegrador.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ShowMySolicitudesController implements Initializable {

    @FXML
    private Button cerrarButton;

    @FXML
    private TableColumn aulaColumna;

    @FXML
    private TableColumn colorColumna;

    @FXML
    private TableColumn descripcionColumna;

    @FXML
    private TableColumn estatusColumna;

    @FXML
    private TableColumn fechaColumna;

    @FXML
    private TableColumn idColumna;

    @FXML
    private TableColumn matriculaColumna;

    @FXML
    private TableColumn tipoColumna;

    @FXML
    private TableView<DataToShow> solicitudesTable;

    @FXML
    void onMouseClickedCerrar(MouseEvent event) {
        App.getStageView().close();
    }

    private ObservableList<DataToShow> solicitudes = FXCollections.observableArrayList();;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Solicitud> listaSolicitudes = App.getAplication().getMySolicitudes();
        ArrayList<DataToShow> datos = new ArrayList<>();
        for (int i = 0; i < listaSolicitudes.size(); i++) {
            DataToShow data = new DataToShow(listaSolicitudes.get(i).getId(), listaSolicitudes.get(i).getMatricula(), listaSolicitudes.get(i).getObjeto().getColor(), listaSolicitudes.get(i).getObjeto().getDescripción(), listaSolicitudes.get(i).getObjeto().getTipo(), listaSolicitudes.get(i).getFecha(), listaSolicitudes.get(i).getAula(), listaSolicitudes.get(i).getStatus());
            datos.add(data);
        }

        this.idColumna.setCellValueFactory(new PropertyValueFactory("id"));
        this.matriculaColumna.setCellValueFactory(new PropertyValueFactory("matricula"));
        this.tipoColumna.setCellValueFactory(new PropertyValueFactory("tipo"));
        this.descripcionColumna.setCellValueFactory(new PropertyValueFactory("descripción"));
        this.colorColumna.setCellValueFactory(new PropertyValueFactory("color"));
        this.fechaColumna.setCellValueFactory(new PropertyValueFactory("fecha"));
        this.aulaColumna.setCellValueFactory(new PropertyValueFactory("aula"));
        this.estatusColumna.setCellValueFactory(new PropertyValueFactory("status"));

        for (int i = 0; i < datos.size(); i++) {
            solicitudes.add(datos.get(i));
        }

        solicitudesTable.setItems(solicitudes);
    }
}