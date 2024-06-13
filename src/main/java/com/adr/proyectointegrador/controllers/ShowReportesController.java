package com.adr.proyectointegrador.controllers;

import com.adr.proyectointegrador.App;
import com.adr.proyectointegrador.models.DataToShow;
import com.adr.proyectointegrador.models.Reporte;
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

public class ShowReportesController implements Initializable {

    @FXML
    private TableColumn matriculaColumna;

    @FXML
    private TableColumn aulaColumna;

    @FXML
    private Button cerrarButton;

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
    private TableView<DataToShow> reportesTable;

    @FXML
    private TableColumn tipoColumna;

    private ObservableList<DataToShow> reportes = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Reporte> listaReportes = App.getAplication().getReportes();
        ArrayList<DataToShow> datos = new ArrayList<>();
        for (int i = 0; i < listaReportes.size(); i++) {
            DataToShow data = new DataToShow(listaReportes.get(i).getId(), listaReportes.get(i).getMatricula(), listaReportes.get(i).getObjeto().getColor(), listaReportes.get(i).getObjeto().getDescripción(), listaReportes.get(i).getObjeto().getTipo(), listaReportes.get(i).getFecha(), listaReportes.get(i).getAula(), listaReportes.get(i).getStatus());
            datos.add(data);
        }

        this.idColumna.setCellValueFactory(new PropertyValueFactory("id"));
        this.matriculaColumna.setCellValueFactory(new PropertyValueFactory("matricula"));
        this.tipoColumna.setCellValueFactory(new PropertyValueFactory("id"));
        this.descripcionColumna.setCellValueFactory(new PropertyValueFactory("descripción"));
        this.colorColumna.setCellValueFactory(new PropertyValueFactory("color"));
        this.fechaColumna.setCellValueFactory(new PropertyValueFactory("fecha"));
        this.aulaColumna.setCellValueFactory(new PropertyValueFactory("aula"));
        this.estatusColumna.setCellValueFactory(new PropertyValueFactory("status"));

        for (int i = 0; i < listaReportes.size(); i++) {
            reportes.add(datos.get(i));
        }

        reportesTable.setItems(reportes);

    }

    public void onMouseClickedCerrar(MouseEvent mouseEvent) {
        App.getStageView().close();
    }
}
