package com.proyectodam.biblioteca.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import com.proyectodam.biblioteca.dao.GestorUsuarios;

public class sportlife extends JFrame {
    private GestorUsuarios gestorUsuarios = new GestorUsuarios();

    public sportlife() {
        super("SportLife - Biblioteca");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        JMenuBar menuBar = new JMenuBar();
        JMenu registro = new JMenu("REGISTRAR USUARIO");
        JMenuItem itemRegistro = new JMenuItem("Nuevo Registro");
        itemRegistro.addActionListener(this::mostrarVentanaRegistro);
        registro.add(itemRegistro);

        JMenu informacion = new JMenu("INFORMACION");
        JMenuItem itemLink = new JMenuItem("Ir a mi sitio web");
        itemLink.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://o2cw.es/gimnasios/malaga/"));
            } catch (IOException | URISyntaxException ex) {
                ex.printStackTrace();
            }
        });
        informacion.add(itemLink);

        menuBar.add(registro);
        menuBar.add(informacion);
        setJMenuBar(menuBar);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        initUI();
    }

    private void initUI() {
        JLabel lblUsuario = new JLabel("Nombre de Usuario:");
        JTextField txtUsuarioNombre = new JTextField();
        JLabel lblContraseña = new JLabel("Contraseña:");
        JPasswordField txtContraseña = new JPasswordField();
        JButton btnAcceder = new JButton("Acceder");

        btnAcceder.addActionListener(e -> {
            String nombreUsuario = txtUsuarioNombre.getText();
            String contraseña = new String(txtContraseña.getPassword());

            if (gestorUsuarios.autenticarUsuario(nombreUsuario, contraseña)) {
                JOptionPane.showMessageDialog(this, "Acceso exitoso.");
                abrirVentanaPrincipal();
            } else {
                JOptionPane.showMessageDialog(this, "Nombre de usuario o contraseña incorrectos.");
            }
        });

        setLayout(new GridLayout(3, 2, 10, 10));
        add(lblUsuario);
        add(txtUsuarioNombre);
        add(lblContraseña);
        add(txtContraseña);
        add(btnAcceder);
    }

    private void mostrarVentanaRegistro(ActionEvent event) {
        registro registroUsuarioFrame = new registro(gestorUsuarios);
        registroUsuarioFrame.setVisible(true);
    }

    private void abrirVentanaPrincipal() {
        JFrame ventanaPrincipal = new JFrame("Ventana Principal");
        ventanaPrincipal.setSize(800, 600);
        ventanaPrincipal.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventanaPrincipal.setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new sportlife().setVisible(true);
        });
    }
}
