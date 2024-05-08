package com.proyectodam.biblioteca.dao;

import com.proyectodam.biblioteca.dto.Usuario;
import java.sql.*;

public class UsuarioDAO {
    
    public boolean insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuario (nombre) VALUES (?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNombre());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
