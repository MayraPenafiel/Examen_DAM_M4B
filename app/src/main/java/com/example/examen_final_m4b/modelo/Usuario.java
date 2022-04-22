package com.example.examen_final_m4b.modelo;

public class Usuario {

    //Atributos
    private String id;
    private String nombreCorto;
    private String contrasena;
    private String permisos;
    private byte imagen;

    //Metodos getter y setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }

    public byte getImagen() {
        return imagen;
    }

    public void setImagen(byte imagen) {
        this.imagen = imagen;
    }

    //Constructor

    public Usuario() {
    }

    public Usuario(String id, String nombreCorto, String contrasena, String permisos, byte imagen) {
        this.id = id;
        this.nombreCorto = nombreCorto;
        this.contrasena = contrasena;
        this.permisos = permisos;
        this.imagen = imagen;
    }
}
