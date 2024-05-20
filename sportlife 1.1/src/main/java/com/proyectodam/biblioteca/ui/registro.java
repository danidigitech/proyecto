package com.proyectodam.biblioteca.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import com.proyectodam.biblioteca.dto.Usuario;
import com.proyectodam.biblioteca.dao.GestorUsuarios;

public class registro extends JFrame {
    private GestorUsuarios gestorUsuarios;
    private JTextField txtUsuarioNombre;
    private JPasswordField txtUsuarioContraseña;
    private JButton btnAgregarUsuario;

    public registro(GestorUsuarios gestorUsuarios) {
        super("Ventana de Registro de Usuario");
        this.gestorUsuarios = gestorUsuarios;
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));
        getContentPane().setBackground(Color.LIGHT_GRAY);

        add(new JLabel("Nombre del Usuario:"));
        txtUsuarioNombre = new JTextField();
        add(txtUsuarioNombre);

        add(new JLabel("Contraseña:"));
        txtUsuarioContraseña = new JPasswordField();
        add(txtUsuarioContraseña);

        btnAgregarUsuario = new JButton("Agregar Usuario");
        btnAgregarUsuario.addActionListener(this::agregarUsuario);
        add(btnAgregarUsuario);
    }

    private void agregarUsuario(ActionEvent event) {
        String nombre = txtUsuarioNombre.getText();
        String contraseña = new String(txtUsuarioContraseña.getPassword());

        if (nombre.isEmpty() || contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingresa tanto el nombre como la contraseña del usuario.");
            return;
        }

        Usuario usuario = new Usuario(0, nombre, contraseña);
        if (gestorUsuarios.agregarUsuario(usuario)) {
            JOptionPane.showMessageDialog(this, "Usuario agregado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al agregar usuario.");
        }
    }
}
