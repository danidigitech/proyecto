package com.proyectodam.biblioteca.dao;

import com.proyectodam.biblioteca.dto.RegistroUsuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/tu_base_de_datos";
    private static final String USER = "tu_usuario";
    private static final String PASSWORD = "tu_contraseña";

    public static boolean guardarUsuario(RegistroUsuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, contraseña, correoElectronico, fechaDeNacimiento, peso, altura, frecuenciaDeEjercicio) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getContraseña());
            pstmt.setString(3, usuario.getCorreoElectronico());
            pstmt.setString(4, usuario.getFechaDeNacimiento());
            pstmt.setString(5, usuario.getPeso());
            pstmt.setString(6, usuario.getAltura());
            pstmt.setString(7, usuario.getFrecuenciaDeEjercicio());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
