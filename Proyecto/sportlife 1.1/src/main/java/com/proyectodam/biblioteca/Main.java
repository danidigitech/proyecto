package com.proyectodam.biblioteca;

import javax.swing.SwingUtilities;

import com.proyectodam.biblioteca.ui.sportLife;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            sportLife gui = new sportLife();
            gui.setVisible(true);
        });
    }
}
