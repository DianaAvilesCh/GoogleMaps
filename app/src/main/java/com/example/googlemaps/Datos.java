package com.example.googlemaps;

public class Datos {
    String nombre;
    String direccion;
    String decano;
    String contacto;
    String logo;
    Double latitud;
    Double longitud;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDecano() {
        return decano;
    }

    public void setDecano(String decano) {
        this.decano = decano;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Datos(String nombre, String direccion, String decano, String contacto, String logo, Double latitud, Double longitud) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.decano = decano;
        this.contacto = contacto;
        this.logo = logo;
        this.latitud = latitud;
        this.longitud = longitud;
    }
}
