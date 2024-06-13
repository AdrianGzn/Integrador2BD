package com.adr.proyectointegrador.models;

import java.time.LocalDate;

public interface Información {

    int getId();
    void setId(int id);
    int getMatricula();
    void setMatricula(int mactricula);
    LocalDate getFecha();
    void setFecha(LocalDate fecha);
    String getAula();
    void setAula(String aula);
    String isStatus();
    void setStatus(String status);
    String getStatus();
    Objeto getObjeto();
    void setObjeto(Objeto objeto);
}
