package com.proyectodam.biblioteca.dto;

public class Usuario {
    private int id;
    private String nombre;

    public Usuario() {
    }

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public void setId(int usuarioId) {
        throw new UnsupportedOperationException("No hacer 'setId', es autonumérico en la BD");
    }

   

}
