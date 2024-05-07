package com.proyectodam.biblioteca;

import com.proyectodam.biblioteca.ui.BibliotecaGUI;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BibliotecaGUI gui = new BibliotecaGUI();
            gui.setVisible(true);
        });
    }
}
