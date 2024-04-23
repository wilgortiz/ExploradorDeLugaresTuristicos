package com.wilgon.exploradordelugaresturisticos.ui.LugaresTuristicos;

public class LugaresTuristicos {
    private String horarioApertura;
    private int id;
    private String nombre;
    private String descripcion;
    private double latitud;
    private double longitud;
    private int imagen;
    private int imagen2;


    public LugaresTuristicos(String horarioApertura, int id, String nombre, String descripcion, double latitud, double longitud, int imagen, int imagen2) {
        this.horarioApertura=horarioApertura;
        this.id = id;

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.imagen = imagen;
        this.imagen2 = imagen2;
    }


    public int getImagen2() {
        return imagen2;
    }

    public void setImagen2(int imagen2) {
        this.imagen2 = imagen2;
    }

    public String getHorarioApertura() {
        return horarioApertura;
    }

    public void setHorarioApertura(String horarioApertura) {
        this.horarioApertura = horarioApertura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
