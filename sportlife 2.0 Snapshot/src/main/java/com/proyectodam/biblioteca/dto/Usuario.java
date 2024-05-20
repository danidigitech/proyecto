package com.proyectodam.biblioteca.dto;

public class Usuario {
    private int id;
    private String nombre;
    private String contraseña;

    public Usuario(int id, String nombre, String contraseña, String correoElectronico, String fechaDeNacimiento, String peso, String altura, String frecuenciaEjercicio) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
    }


    // Getters y setters
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
