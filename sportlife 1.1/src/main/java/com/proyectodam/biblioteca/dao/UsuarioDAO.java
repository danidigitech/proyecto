package com.proyectodam.biblioteca.dao;

import com.proyectodam.biblioteca.dto.Usuario;
import java.sql.*;

public class UsuarioDAO {
    
    public boolean insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuario (id,nombre,contraseña) VALUES (?,?,?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, usuario.getId());
            pstmt.setString(2, usuario.getNombre());
            pstmt.setString(3, usuario.getContraseña());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
