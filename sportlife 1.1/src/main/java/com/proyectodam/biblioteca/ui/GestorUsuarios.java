package com.proyectodam.biblioteca.ui;

import com.proyectodam.biblioteca.dao.UsuarioDAO;
import com.proyectodam.biblioteca.dto.Usuario;

public class GestorUsuarios {

    public boolean agregarUsuario(Usuario usuario) {
        return UsuarioDAO.insertarUsuario(usuario);
    }

}
