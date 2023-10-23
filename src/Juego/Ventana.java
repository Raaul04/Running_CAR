package Juego;

import Juego.Juego;
import Juego.Panel;

import javax.swing.JFrame;

/**
 * La clase Ventana representa la ventana principal del juego y contiene el panel de juego y al jugador.
 */
public class Ventana extends JFrame {
    private JFrame ventana;
    private Juego juego;
    private Player player;

    /**
     * Constructor para crear una nueva instancia de Ventana.
     *
     * @param panel El panel de juego que se agregara a la ventana.
     */
    public Ventana(Panel panel) {
        ventana = new JFrame();
        ventana.setSize(400, 400); // Tamaño de la ventana de juego
        ventana.add(panel);
        ventana.setVisible(true);
        player = new Player();
    }
}
