package com.proyectodam.biblioteca.dao;

import com.proyectodam.biblioteca.dto.Usuario;
import java.sql.*;

public class UsuarioDAO {
    
    public static boolean insertarUsuario(Usuario usuario){
        String sql = "INSERT INTO Usuario (nombre, contraseña) VALUES (?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getContraseña()); // Aquí se establece el valor del segundo parámetro
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0; // Devuelve true si al menos una fila fue insertada con éxito
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    

}
