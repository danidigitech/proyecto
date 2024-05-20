package com.proyectodam.biblioteca.ui;

import javax.swing.*;
import java.awt.*;

public class sportlife extends JFrame {

    public sportlife() {
        super("SportLife - Biblioteca");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de login
        JPanel panelLogin = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel lblUsuario = new JLabel("Nombre de Usuario:");
        JTextField txtUsuarioNombre = new JTextField();
        JLabel lblContraseña = new JLabel("Contraseña:");
        JPasswordField txtContraseña = new JPasswordField();
        JButton btnAcceder = new JButton("Acceder");

        btnAcceder.addActionListener(e -> {
            // Aquí podrías realizar la autenticación del usuario
            // Por ahora, simplemente mostraremos un mensaje
            JOptionPane.showMessageDialog(this, "Acceso exitoso.");
            abrirVentanaPrincipal();
            dispose(); // Cerrar la ventana de inicio de sesión
        });

        panelLogin.add(lblUsuario);
        panelLogin.add(txtUsuarioNombre);
        panelLogin.add(lblContraseña);
        panelLogin.add(txtContraseña);
        panelLogin.add(btnAcceder);

        // Añadir el panel de login al centro del BorderLayout
        add(panelLogin, BorderLayout.CENTER);
    }

    private void abrirVentanaPrincipal() {
        JFrame ventanaPrincipal = new JFrame("Ventana Principal");
        ventanaPrincipal.setSize(1600, 900);
        ventanaPrincipal.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Crear el panel para la lista de ejercicios
        JPanel panelEjercicios = new JPanel(new FlowLayout());

        // Cargar las imágenes de los ejercicios y ajustar su tamaño
        ImageIcon flexionesIcon = new ImageIcon("imagenes/pngtree-push-ups-fitness-fitness-man-the-man-png-image_478311.jpg");
        flexionesIcon.setImage(flexionesIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));

        ImageIcon sentadillasIcon = new ImageIcon("imagenes/sentadilla-1-1024x536.png");
        sentadillasIcon.setImage(sentadillasIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));

        ImageIcon planchaIcon = new ImageIcon("imagenes/plancha-horizontal-isometrica-init-pos-6722.png");
        planchaIcon.setImage(planchaIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));

        ImageIcon abdominalesIcon = new ImageIcon("imagenes/images.jpeg");
        abdominalesIcon.setImage(abdominalesIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));

        ImageIcon saltarCuerdaIcon = new ImageIcon("imagenes/pngtree-cartoon-cartoon-girl-little-girl-lovely-png-image_474305.jpg");
        saltarCuerdaIcon.setImage(saltarCuerdaIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));

        // Crear etiquetas para mostrar las imágenes
        JLabel flexionesLabel = new JLabel(flexionesIcon);
        JLabel sentadillasLabel = new JLabel(sentadillasIcon);
        JLabel planchaLabel = new JLabel(planchaIcon);
        JLabel abdominalesLabel = new JLabel(abdominalesIcon);
        JLabel saltarCuerdaLabel = new JLabel(saltarCuerdaIcon);

        // Agregar las etiquetas al panel de ejercicios
        panelEjercicios.add(flexionesLabel);
        panelEjercicios.add(sentadillasLabel);
        panelEjercicios.add(planchaLabel);
        panelEjercicios.add(abdominalesLabel);
        panelEjercicios.add(saltarCuerdaLabel);

        // Añadir el panel de ejercicios al frame
        ventanaPrincipal.add(panelEjercicios);

        // Hacer visible el frame
        ventanaPrincipal.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new sportlife().setVisible(true);
        });
    }
}
