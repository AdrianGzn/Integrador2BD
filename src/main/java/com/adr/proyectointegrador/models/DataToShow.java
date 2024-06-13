package com.adr.proyectointegrador.models;

import java.time.LocalDate;

public class DataToShow {
    int id;
    int matricula;
    String color;
    String descripción;
    String tipo;
    LocalDate fecha;
    String aula;
    String status;

    public DataToShow(int id, int matricula, String color, String descripción, String tipo, LocalDate fecha, String aula, String status) {
        this.id = id;
        this.matricula = matricula;
        this.color = color;
        this.descripción = descripción;
        this.tipo = tipo;
        this.fecha = fecha;
        this.aula = aula;
        this.status = status;
    }
    public DataToShow() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
