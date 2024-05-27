package com.proyectodam.biblioteca.ui;

import javax.swing.*;
import java.awt.*;

public class ventanaMancuernas extends JFrame {

    public ventanaMancuernas() {
        setTitle("Ejercicios con Mancuernas");
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(255, 255, 255));
        setLayout(new BorderLayout());

        // Panel con los ejercicios de mancuernas
        JPanel panelEjerciciosMancuernas = new JPanel(new GridLayout(5, 1, 10, 10));
        panelEjerciciosMancuernas.setBackground(new Color(255, 255, 255));

        String[] ejercicios = {
            "Press de banca con mancuernas",
            "Curl de bíceps con mancuernas",
            "Sentadillas con mancuernas",
            "Press militar con mancuernas",
            "Remo con mancuernas"
        };

        for (String ejercicio : ejercicios) {
            JLabel lblEjercicio = new JLabel(ejercicio);
            lblEjercicio.setFont(new Font("Arial", Font.PLAIN, 18));
            panelEjerciciosMancuernas.add(lblEjercicio);
        }

        add(panelEjerciciosMancuernas, BorderLayout.CENTER);
    }
}
