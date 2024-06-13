package com.adr.proyectointegrador.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Aplication {
    private ArrayList<Reporte> reportes = new ArrayList<>();
    private ArrayList<Solicitud> solicitudes = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private int usuarioActual;
    private String tipoUsuarioActual;
    private int idReportes = 100;
    private int idSolicitudes = 100;

    public ArrayList<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public ArrayList<Reporte> getReportes() {
        return reportes;
    }

    public String tipoUsuario(int matricula) {
        Usuario admin = new Usuario(233300, "admin");
        Usuario alumno1 = new Usuario(233301, "alumno");
        Usuario alumno2 = new Usuario(233302, "alumno");

        usuarios.add(admin);
        usuarios.add(alumno1);
        usuarios.add(alumno2);

        String tipo = "null";
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).getMatricula() == matricula) {
                    tipo = usuarios.get(i).getTipo();
                    usuarioActual = usuarios.get(i).getMatricula();
                    tipoUsuarioActual = usuarios.get(i).getTipo();
                    break;
                }
            }
        return tipo;
    }

    public boolean newSolicitud(String tipo, String descripcion, String color, LocalDate fecha, String aula) {
        System.out.println("Si llega al newSolicitud");
        boolean agregado = false;
        int idTemp = idSolicitudes + 1;
        idSolicitudes = idTemp;
        Objeto objeto = new Objeto(color, descripcion, tipo);
        Solicitud newSolicitud = new Solicitud(idTemp, usuarioActual, fecha, aula, "No resuelto", objeto);
        if(solicitudes.add(newSolicitud)) {
            agregado = true;
        }

        return agregado;
    }

    public boolean newReporte(String tipo, String descripcion, String color, LocalDate fecha, String aula) {
        System.out.println("Si llega al newReporte");
        boolean agregado = false;
        int idTemp = idReportes + 1;
        idReportes = idTemp;
        Objeto objeto= new Objeto(color, descripcion, tipo);
        Reporte newReporte = new Reporte(idTemp, usuarioActual, fecha, aula, "No resuelto", objeto);
        if(reportes.add(newReporte)) {
            agregado = true;
        }

        return agregado;
    }

    public String eliminarReporte(int id) {
        String status = "No eliminado";

        if (tipoUsuarioActual.equals("admin")){
            for (int i = 0; i < reportes.size(); i++) {
                if (id == reportes.get(i).getId()){
                    reportes.remove(i);
                    status = "Eliminado";
                }
            }

        } else if (tipoUsuarioActual.equals("alumno")) {
            for (int i = 0; i < reportes.size(); i++) {
                if (id == reportes.get(i).getId() && usuarioActual == reportes.get(i).getMatricula()) {
                    reportes.remove(i);
                    status = "Eliminado";
                    break;
                }
            }
        }

        return status;
    }

    public String eliminarSolicitud(int id) {
        String status = "No eliminado";

        if (tipoUsuarioActual.equals("admin")){
            for (int i = 0; i < solicitudes.size(); i++) {
                if (id == solicitudes.get(i).getId()){
                    solicitudes.remove(i);
                    status = "Eliminado";
                }
            }

        } else if (tipoUsuarioActual.equals("alumno")) {
            for (int i = 0; i < solicitudes.size(); i++) {
                if (id == solicitudes.get(i).getId() && usuarioActual == reportes.get(i).getMatricula()) {
                    solicitudes.remove(i);
                    status = "Eliminado";
                    break;
                }
            }
        }

        return status;
    }

    public ArrayList<Solicitud> getMySolicitudes()  {
        ArrayList<Solicitud> mySolicitudes = new ArrayList<>();
        for (int i = 0; i < solicitudes.size(); i++) {
            if (solicitudes.get(i).getMatricula() == usuarioActual){
                mySolicitudes.add(solicitudes.get(i));
            }
        }
        return mySolicitudes;
    }

    public ArrayList<Reporte> getMyReportes()  {
        ArrayList<Reporte> myReportes = new ArrayList<>();
        for (int i = 0; i < reportes.size(); i++) {
            if (reportes.get(i).getMatricula() == usuarioActual){
                myReportes.add(reportes.get(i));
            }
        }
        return myReportes;
    }

    public boolean changeStatusSolicitud(int id, String status) {
        boolean changed = false;

        for (int i = 0; i < solicitudes.size(); i++) {
            if (solicitudes.get(i).getId() == id){
                solicitudes.get(i).setStatus(status);
                changed = true;
            }
        }

        return changed;
    }

    public boolean changeStatusReporte(int id, String status) {
        boolean changed = false;

        for (int i = 0; i < reportes.size(); i++) {
            if (reportes.get(i).getId() == id){
                reportes.get(i).setStatus(status);
                changed = true;
            }
        }

        return changed;
    }
}