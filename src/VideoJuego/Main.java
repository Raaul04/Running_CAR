package VideoJuego;

import Title.TitleManagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                titleManagement.setSize(200, 200);
                titleManagement.setVisible(true);

                // Agregar un ActionListener al botón "Iniciar juego" en TitleManagement
                titleManagement.addStartButtonActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Cuando se hace clic en "Iniciar juego", ocultar la pantalla de título y mostrar el juego
                        titleManagement.setVisible(false);

                        // Crear e iniciar el juego
                        Juego juego = new Juego();
                    }
                });
            }
        });
    }
}
