package Usuario;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

/**
 * La clase Player representa al jugador en un juego y maneja su interacción con el teclado.
 */
public class Player implements KeyListener {
    public static int x = 10, y = 10;
    private boolean[] keys = new boolean[256]; // Debido a que hay 256 teclas y cada número es una de ellas
    public static boolean LEFT, RIGHT; // Declaramos los controles que se usarán en el juego para moverse de un lado a otro

    /**
     * Constructor para crear una nueva instancia de Player y configurar los controles iniciales.
     */
    public Player() {
        LEFT = false;
        RIGHT = false;
    }

    /**
     * Actualiza el estado de los controles LEFT y RIGHT basados en las teclas presionadas.
     */
    public void update() {
        LEFT = keys[KeyEvent.VK_LEFT];
        RIGHT = keys[KeyEvent.VK_RIGHT];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (x > 0) {
                x = x - 20;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (x > 0) {
                x = x - 20;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Obtiene los limites del objeto Player como una forma elíptica.
     *
     * @return Un objeto Ellipse2D que representa los limites del jugador.
     */
    public Ellipse2D getBoundsCoche() {
        return new Ellipse2D.Double(x + 10, y + 30, 80, 50);
    }
}
