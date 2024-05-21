package com.proyectodam.biblioteca.dto;

public class RegistroUsuario {
    private int id;
    private String nombre;
    private String contraseña;
    private String correo;
    private String fechaNacimiento;
    private String peso;
    private String altura;
    private String frecuenciaEjercicio;
    
    
    public RegistroUsuario(int id, String nombre, String contraseña, String correo, String fechaNacimiento, String peso,
            String altura, String frecuenciaEjercicio) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
        this.altura = altura;
        this.frecuenciaEjercicio = frecuenciaEjercicio;
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
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getPeso() {
        return peso;
    }
    public void setPeso(String peso) {
        this.peso = peso;
    }
    public String getAltura() {
        return altura;
    }
    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getFrecuenciaEjercicio() {
        return frecuenciaEjercicio;
    }

    public void setFrecuenciaEjercicio(String frecuenciaEjercicio) {
        this.frecuenciaEjercicio = frecuenciaEjercicio;
    }
    
}
