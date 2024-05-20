package com.proyectodam.biblioteca.dao;

import com.proyectodam.biblioteca.dto.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestorUsuarios {

    public boolean agregarUsuario(Usuario usuario) {
        try (Connection connection = Conexion.getConnection()) {
            String query = "INSERT INTO Usuario (nombre, contraseña) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getContraseña());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean autenticarUsuario(String nombre, String contraseña) {
        try (Connection connection = Conexion.getConnection()) {
            String query = "SELECT * FROM Usuario WHERE nombre = ? AND contraseña = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nombre);
            statement.setString(2, contraseña);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // Devuelve true si se encuentra un registro que coincide
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
