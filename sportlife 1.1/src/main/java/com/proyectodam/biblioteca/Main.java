package com.proyectodam.biblioteca;

import javax.swing.SwingUtilities;

import com.proyectodam.biblioteca.ui.sportlife;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            sportlife gui = new sportlife();
            gui.setVisible(true);
        });
    }
}
