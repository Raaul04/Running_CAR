package Juego;
import Title.TitleManagement;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // SwingUtilities.invokeLater se utiliza para asegurarse de que la interfaz de usuario se actualice en el Event Dispatch Thread (EDT),
        // Se necesita para operaciones relacionadas con la interfaz gráfica en Swing.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Creamos una instancia de TitleManagement para gestionar la transición entre la pantalla de título y el juego
                TitleManagement titleManagement = new TitleManagement();

                // Configurar y mostrar la ventana principal
                    titleManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    titleManagement.setSize(400, 400);
                    titleManagement.setVisible(true);
            }
        });

    }
}