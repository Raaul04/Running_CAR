package Title;

import javax.swing.*;
import java.awt.*;

/**
 * La clase TitleManagement es responsable de la gestión de la pantalla de inicio
 * y la transición al juego principal.
 */
public class TitleManagement extends JFrame {
    private Title title;
    private Juego.Juego game;

    /**
     * Constructor de la clase TitleManagement.
     * Configura la pantalla de inicio y la hace visible.
     */
    public TitleManagement() {
        setTitle("Pantalla de Inicio");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        title = new Title(this);
        add(title);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Inicia el juego ocultando la pantalla de inicio y mostrando el juego principal.
     */
    public void startGame() {
        // Ocultar la pantalla de título
        title.setVisible(false);

        // Crear y mostrar el juego
        game = new Juego.Juego();
        add(game, BorderLayout.CENTER);
        pack(); // Ajustar el tamaño de la ventana
        setLocationRelativeTo(null);
    }

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args Los argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TitleManagement();
            }
        });
    }
}
