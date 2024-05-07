package com.proyectodam.biblioteca.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.proyectodam.biblioteca.dto.Usuario; // Asegúrate de importar correctamente

public class BibliotecaGUI extends JFrame {
    private GestorUsuarios gestorUsuarios = new GestorUsuarios(); // Usamos la clase GestorUsuarios

    private JTextField txtUsuarioNombre; // Campo de texto para el nombre del usuario
    private JButton btnAgregarUsuario; // Botón para agregar usuarios

    public BibliotecaGUI() {
        super("");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2, 10, 10)); // Diseño simple de dos columnas
        initUI();
    }

    private void initUI() {
        // Campo para el nombre del usuario
        add(new JLabel("Nombre del Usuario:")); // Cambié de "Autor" a "Usuario"
        txtUsuarioNombre = new JTextField();
        add(txtUsuarioNombre);

        add(new JLabel("Contraseña:")); // Cambié de "Autor" a "Usuario"
        txtUsuarioNombre = new JTextField();
        add(txtUsuarioNombre);
        // Botón para agregar usuarios
        btnAgregarUsuario = new JButton("Agregar Usuario");
        btnAgregarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarUsuario(e); // Llama al método para agregar usuarios
            }
        });
        add(btnAgregarUsuario);
    }

    private void agregarUsuario(ActionEvent event) {
        String nombre = txtUsuarioNombre.getText(); // Extraemos el nombre del campo de texto
        Usuario usuario = new Usuario(0, nombre); // Creación de un nuevo usuario
        if (gestorUsuarios.agregarUsuario(usuario)) { // Se usa el gestor para agregar
            JOptionPane.showMessageDialog(this, "Usuario agregado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al agregar usuario.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BibliotecaGUI().setVisible(true); // Se hace visible la GUI
        });
    }
}