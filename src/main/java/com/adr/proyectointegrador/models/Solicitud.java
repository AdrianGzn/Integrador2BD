package com.adr.proyectointegrador.models;

import java.time.LocalDate;

public class Solicitud implements Información{

    private int id;
    private int matricula;

    private LocalDate fecha;
    private String aula;
    private String status;
    private Objeto objeto;

    public Solicitud(int id, int matricula, LocalDate fecha, String aula, String status, Objeto objeto) {
        this.id = id;
        this.matricula = matricula;
        this.fecha = fecha;
        this.aula = aula;
        this.status = status;
        this.objeto = objeto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int mactricula) {
        this.matricula = mactricula;
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

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }
}
