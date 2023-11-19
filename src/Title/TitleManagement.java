package Title;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase TitleManagement es responsable de la gestión de la pantalla de inicio
 * y la transición al juego principal.
 */
public class TitleManagement extends JFrame {
    private Title title;
    private VideoJuego.Juego game;

    /**
     * Constructor de la clase TitleManagement.
     * Configura la pantalla de inicio y la hace visible.
     */
    public TitleManagement() {
        setTitle("Pantalla de Inicio");
        setSize(300, 200);
        setBackground(Color.BLACK);
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
        game = new VideoJuego.Juego();
        add(game, BorderLayout.CENTER);
        pack(); // Ajustar el tamaño de la ventana
        setLocationRelativeTo(null);
    }

    /**
     * Agrega un ActionListener al botón de inicio en la pantalla de título.
     *
     * @param listener ActionListener a agregar.
     */
    public void addStartButtonActionListener(ActionListener listener) {
        title.addStartButtonActionListener(listener);
    }
}
