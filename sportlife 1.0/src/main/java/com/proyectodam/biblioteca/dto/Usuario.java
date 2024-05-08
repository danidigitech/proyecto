package com.proyectodam.biblioteca.dto;

public class Usuario {
    private int id;
    private String nombre;
    private String contraseña;

    public Usuario() {
    }

    public Usuario(int id, String nombre,String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña=contraseña;
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
    public String getContraseña(){
        return contraseña;
    }
    public void setContraseña(String contraseña)
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
