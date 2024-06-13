package com.adr.proyectointegrador.models;

public class Usuario {
    private int matricula;
    private String tipo;

    public Usuario(int matricula, String tipo) {
        this.matricula = matricula;
        this.tipo = tipo;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}