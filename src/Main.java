package Juego;
import Title.TitleManagement;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Crear una instancia de TitleManagement para gestionar la transición entre la pantalla de título y el juego
                TitleManagement titleManagement = new TitleManagement();

                // Configurar y mostrar la ventana principal
                titleManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                titleManagement.setSize(400, 400);
                titleManagement.setVisible(true);
            }
        });
    }
}