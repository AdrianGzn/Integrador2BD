package com.adr.proyectointegrador.models;

public class Objeto {
    String color;
    String descripción;
    String tipo;

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

    public Objeto(String color, String descripción, String tipo) {
        this.color = color;
        this.descripción = descripción;
        this.tipo = tipo;
    }
    public Objeto(){}

}
