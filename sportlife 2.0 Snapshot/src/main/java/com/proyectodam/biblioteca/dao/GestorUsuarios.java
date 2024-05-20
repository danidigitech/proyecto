package com.proyectodam.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.proyectodam.biblioteca.dto.RegistroUsuario;

public class GestorUsuarios {

    public boolean agregarUsuario(RegistroUsuario usuario) {
        try (Connection connection = Conexion.getConnection()) {
            String query = "INSERT INTO Usuario (nombre, contraseña, correoElectronico, fechaDeNacimiento, peso, altura, frecuenciaDeEjercicio) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getContraseña());
            statement.setString(3, usuario.getCorreo());
            statement.setString(4, usuario.getFechaNacimiento());
            statement.setString(5, usuario.getPeso());
            statement.setString(6, usuario.getAltura());
            statement.setString(7, usuario.getFrecuenciaEjercicio());
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
