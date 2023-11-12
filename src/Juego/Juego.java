package Juego;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * La clase Juego representa el juego principal que incluye la ventana de juego,
 * el coche del jugador y la lógica asociada.
 * Extiende JPanel para proporcionar un lienzo en el que se representarán los elementos del juego.
 *
 */
public class Juego extends JPanel {

    /** Representa el coche del jugador en el juego. */
    private Coche_Player coche;

    /** Indica si el coche ha chocado o no. */
    public static boolean haChocado = false;

    /**
     * Constructor de la clase Juego. Inicializa la ventana de juego, el coche del jugador y
     * configura el KeyListener para detectar las teclas presionadas por el usuario.
     */
    public Juego() {
        // Crear la ventana de juego
        JFrame miVentana = new JFrame("Running Car");

        miVentana.add(this); // Agregar este panel a la ventana
        miVentana.setSize(500, 900);
        miVentana.setVisible(true);
        miVentana.setResizable(false);
        miVentana.setLocationRelativeTo(null);
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear una instancia de Coche_Player y pasarla a la ventana
        coche = new Coche_Player(miVentana);

        // Agregar el KeyListener al coche
        miVentana.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // No se utiliza en este juego
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();

                // Detectar la tecla presionada y realizar la acción correspondiente
                if (key == KeyEvent.VK_A) {
                    // Presionó la tecla "a" (izquierda), implementa el giro a la izquierda aquí
                    coche.cambiarCarrilIzquierdo();
                } else if (key == KeyEvent.VK_D) {
                    // Presionó la tecla "d" (derecha), implementa el giro a la derecha aquí
                    coche.cambiarCarrilDerecho();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // No se utiliza en este juego
            }
        });

        setFocusable(true); // Permite que este panel reciba el foco para detectar eventos de teclado

        // Agregar el JLabel del coche a la ventana principal
        miVentana.add(coche.getCocheLabel());
    }
}
