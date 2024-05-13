    package com.proyectodam.biblioteca.ui;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import com.proyectodam.biblioteca.dto.Usuario; // Asegúrate de importar correctamente

    public class sportlife extends JFrame {
        private GestorUsuarios gestorUsuarios = new GestorUsuarios(); // Usamos la clase GestorUsuarios
        private JTextField txtUsuarioNombre; // Campo de texto para el nombre del usuario
        private JTextField txtUsuarioContraseña;
        private JButton btnAgregarUsuario; // Botón para agregar usuarios

        public sportlife() {
            super("");
            setSize(800, 600);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLayout(new GridLayout(10, 2, 10, 10));
            JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("Archivo");
    menuBar.add(fileMenu);
    setJMenuBar(menuBar); // Añadir la barra de menú al JFrame
    // Diseño simple de dos columnas
            getContentPane().setBackground(Color.LIGHT_GRAY);
            
            initUI();
        }

        private void initUI() {
            // Campo para el nombre del usuario
            add(new JLabel("Nombre del Usuario:")); // Cambié de "Autor" a "Usuario"
            txtUsuarioNombre = new JTextField();
            add(txtUsuarioNombre);

            add(new JLabel("Contraseña:")); // Cambié de "Autor" a "Usuario"
            txtUsuarioContraseña= new JTextField();
            add(txtUsuarioContraseña);
            // Botón para agregar usuarios
            btnAgregarUsuario = new JButton("Agregar Usuario");
            btnAgregarUsuario.addActionListener(this::agregarUsuario);
            add(btnAgregarUsuario);
        }

       private void agregarUsuario(ActionEvent event) {
    String nombre = txtUsuarioNombre.getText();
    String contraseña = txtUsuarioContraseña.getText();

    // Verificar si el nombre o la contraseña están vacíos
    if (nombre.isEmpty() || contraseña.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor ingresa tanto el nombre como la contraseña del usuario.");
        return; // Detener el proceso de agregar usuario si falta el nombre o la contraseña
    }

    Usuario usuario = new Usuario(0, nombre, contraseña);
    if (gestorUsuarios.agregarUsuario(usuario)) {
        JOptionPane.showMessageDialog(this, "Usuario agregado exitosamente.");
    } else {
        JOptionPane.showMessageDialog(this, "Error al agregar usuario.");
    }
}
        
        

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                new sportlife().setVisible(true); // Se hace visible la GUI
            });
        }
    }