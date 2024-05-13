package com.proyectodam.biblioteca.ui;

import java.util.ArrayList;
import java.util.List;

import com.proyectodam.biblioteca.dto.Usuario; // Asegúrate de importar correctamente

public class GestorUsuarios {
    private List<Usuario> usuarios; // Cambié "autores" por "usuarios"

    public GestorUsuarios() {
        this.usuarios = new ArrayList<>(); // Asegura que la lista está inicializada
    }

    public boolean agregarUsuario(Usuario usuario) {
        try {
            usuarios.add(usuario); // Agrega un usuario a la lista
            return true; // Devuelve true si la operación es exitosa
        } catch (Exception e) {
            return false; // Retorna false si ocurre un error
        }
    }

    public List<Usuario> obtenerUsuarios() { // Devuelve la lista de usuarios
        return usuarios; 
    }
}
