package com.proyectodam.biblioteca.ui;

import com.proyectodam.biblioteca.dao.GestorUsuarios;
import com.proyectodam.biblioteca.dao.UsuarioDAO;
import com.proyectodam.biblioteca.dto.RegistroUsuario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SportLife extends JFrame {

    private GestorUsuarios gestorUsuarios;

    public SportLife() {
        super("SportLife - Biblioteca");
        gestorUsuarios = new GestorUsuarios();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de login
        JPanel panelLogin = new JPanel(new GridLayout(8, 2, 10, 10));
        JLabel lblUsuario = new JLabel("Nombre de Usuario:");
        JTextField txtUsuarioNombre = new JTextField();
        JLabel lblContraseña = new JLabel("Contraseña:");
        JPasswordField txtContraseña = new JPasswordField();
        JButton btnAcceder = new JButton("Acceder");
        JLabel lblNuevoUsuario = new JLabel("¿Nuevo Usuario?");
        JButton btnRegistro = new JButton("Registrarse");

        // Agregar ActionListener al botón de registro
        btnRegistro.addActionListener(e -> abrirVentanaRegistro());

        // Agregar ActionListener al botón de acceso
        btnAcceder.addActionListener(e -> {
            String nombreUsuario = txtUsuarioNombre.getText();
            String contraseña = new String(txtContraseña.getPassword());

            // Autenticar al usuario utilizando el método autenticarUsuario en GestorUsuarios
            if (gestorUsuarios.autenticarUsuario(nombreUsuario, contraseña)) {
                JOptionPane.showMessageDialog(this, "Acceso exitoso.");
                abrirVentanaPrincipal();
                dispose(); // Cerrar la ventana de inicio de sesión
            } else {
                JOptionPane.showMessageDialog(this, "Nombre de usuario o contraseña incorrectos.");
            }
        });

        // Agregar componentes al panel de login
        panelLogin.add(lblUsuario);
        panelLogin.add(txtUsuarioNombre);
        panelLogin.add(lblContraseña);
        panelLogin.add(txtContraseña);
        panelLogin.add(btnAcceder);
        panelLogin.add(new JLabel()); // Espacio vacío para alineación
        panelLogin.add(lblNuevoUsuario);
        panelLogin.add(btnRegistro);

        // Crear un panel exterior con BorderLayout y añadir márgenes
        JPanel panelExterior = new JPanel(new BorderLayout());
        panelExterior.setBorder(new EmptyBorder(100, 100, 100, 100)); // Ajustar los márgenes aquí
        panelExterior.add(panelLogin, BorderLayout.CENTER);

        // Añadir el panel exterior al centro del BorderLayout
        add(panelExterior, BorderLayout.CENTER);
    }

    private void abrirVentanaPrincipal() {
        JFrame ventanaPrincipal = new JFrame("Ventana Principal");
        ventanaPrincipal.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventanaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH); // Configura la ventana a pantalla completa

        // Crear un JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Crear paneles para las pestañas
        JPanel panelEjercicios = new JPanel();
        panelEjercicios.add(new JLabel("Aquí irían los ejercicios"));

        JPanel panelEstadisticas = new JPanel();
        panelEstadisticas.add(new JLabel("Aquí irían las estadísticas"));

        JPanel panelConfiguracion = new JPanel();
        panelConfiguracion.add(new JLabel("Aquí irían las configuraciones"));

        // Añadir los paneles al JTabbedPane
        tabbedPane.addTab("Ejercicios", panelEjercicios);
        tabbedPane.addTab("Estadísticas", panelEstadisticas);
        tabbedPane.addTab("Configuraciones", panelConfiguracion);

        // Añadir el JTabbedPane al frame principal
        ventanaPrincipal.add(tabbedPane, BorderLayout.CENTER);

        // Hacer visible el frame
        ventanaPrincipal.setVisible(true);
    }

    private void abrirVentanaRegistro() {
        JFrame ventanaRegistro = new JFrame("Registro de Usuario");
        ventanaRegistro.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ventanaRegistro.setExtendedState(JFrame.MAXIMIZED_BOTH); // Configura la ventana a pantalla completa

        // Crear componentes para el registro de usuario
        JPanel panelRegistro = new JPanel(new GridLayout(8, 2, 10, 10));
        JTextField txtNombre = new JTextField();
        JPasswordField txtContraseña = new JPasswordField();
        JTextField txtCorreo = new JTextField();
        JTextField txtFechaNacimiento = new JTextField();
        JTextField txtPeso = new JTextField();
        JTextField txtAltura = new JTextField();

        // Crear JComboBox para la frecuencia de ejercicio
        String[] opcionesFrecuencia = {"Diariamente", "Una o dos veces por semana", "Alguna que otra vez", "Nunca"};
        JComboBox<String> comboFrecuenciaEjercicio = new JComboBox<>(opcionesFrecuencia);

        JButton btnGuardar = new JButton("Guardar");

        // Agregar componentes al panel de registro
        panelRegistro.add(new JLabel("Nombre de Usuario:"));
        panelRegistro.add(txtNombre);
        panelRegistro.add(new JLabel("Contraseña:"));
        panelRegistro.add(txtContraseña);
        panelRegistro.add(new JLabel("Correo Electrónico:"));
        panelRegistro.add(txtCorreo);
        panelRegistro.add(new JLabel("Fecha de Nacimiento:"));
        panelRegistro.add(txtFechaNacimiento);
        panelRegistro.add(new JLabel("Peso:"));
        panelRegistro.add(txtPeso);
        panelRegistro.add(new JLabel("Altura:"));
        panelRegistro.add(txtAltura);
        panelRegistro.add(new JLabel("Frecuencia de Ejercicio:"));
        panelRegistro.add(comboFrecuenciaEjercicio);
        panelRegistro.add(new JLabel()); // Espacio vacío para alineación
        panelRegistro.add(btnGuardar);

        // Agregar ActionListener al botón de guardar
        btnGuardar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            String contraseña = new String(txtContraseña.getPassword());
            String correo = txtCorreo.getText();
            String fechaNacimiento = txtFechaNacimiento.getText();
            String peso = txtPeso.getText();
            String altura = txtAltura.getText();
            String frecuenciaEjercicio = (String) comboFrecuenciaEjercicio.getSelectedItem();

            // Crear un objeto RegistroUsuario
            RegistroUsuario usuario = new RegistroUsuario(0, nombre, contraseña, correo, fechaNacimiento, peso, altura, frecuenciaEjercicio);

            // Guardar el usuario en la base de datos
            if (UsuarioDAO.guardarUsuario(usuario)) {
                JOptionPane.showMessageDialog(ventanaRegistro, "Datos guardados correctamente");
                ventanaRegistro.dispose(); // Cerrar la ventana de registro y regresar al login
                new SportLife().setVisible(true); // Reabrir la ventana de login
            } else {
                JOptionPane.showMessageDialog(ventanaRegistro, "Error al guardar los datos");
            }
        });

        // Crear un panel exterior con BorderLayout y añadir márgenes
        JPanel panelExterior = new JPanel(new BorderLayout());
        panelExterior.setBorder(new EmptyBorder(100, 100, 100, 100)); // Ajustar los márgenes aquí
        panelExterior.add(panelRegistro, BorderLayout.CENTER);

        // Añadir el panel exterior a la ventana de registro
        ventanaRegistro.add(panelExterior);
        ventanaRegistro.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SportLife frame = new SportLife();
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Configura la ventana a pantalla completa
            frame.setVisible(true);
        });
    }
}
