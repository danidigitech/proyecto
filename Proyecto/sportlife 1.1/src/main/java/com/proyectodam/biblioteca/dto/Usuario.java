package com.proyectodam.biblioteca.dto;

public class Usuario {
    private int id;
    private String nombre;
    private String contraseña;
    private int altura;
    private int peso;
    private int edad;
    private int gimnasioIdGimnasio;

    

    //constructor
    public Usuario() {
    }
     
    public Usuario(int id, String nombre,String contraseña,int altura, int peso, int edad, int gimnasioIdGimnasio) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña=contraseña;
        this.altura = altura;
        this.peso = peso;
        this.edad = edad;
    }
    public int getId() {
        return id;
    }
//objeto
    public int getGimnasioIdGimnasio() {
        return gimnasioIdGimnasio;
    }

    public void setGimnasioIdGimnasio(int gimnasioIdGimnasio) {
        this.gimnasioIdGimnasio = gimnasioIdGimnasio;
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
    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }
    
    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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
