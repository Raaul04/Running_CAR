package VideoJuego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * La clase Controles implementa la interfaz KeyListener para manejar eventos de teclado en el juego.
 * Controla las acciones del jugador, como mover el coche hacia la izquierda o la derecha.
 */
public class Mecanica implements KeyListener {
    Juego juego;


    /**
     * Constructor de la clase Controles.
     *
     * @param ref La referencia al objeto Juego al que se aplicarán los controles.
     */
    public Mecanica(Juego ref) {
        this.juego = ref;
    }


    @Override
    public void keyTyped(KeyEvent e) {
        //no lo usamos
    }

    /**
     * Maneja el evento cuando una tecla es presionada.
     * Mueve el coche hacia la izquierda o la derecha según la tecla presionada.
     *
     * @param e El evento de teclado generado.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == 37) { // Tecla izquierda
            int x = juego.getCarPanel().getX();
            int y = juego.getCarPanel().getY();


            if (x - juego.getVelocidad_horizontal() > 145) {
                juego.getCarPanel().setLocation(x - juego.getVelocidad_horizontal(), y);
            }


        } else if (code == 39) { // Tecla derecha
            int x = juego.getCarPanel().getX();
            int y = juego.getCarPanel().getY();
            int carWidth = juego.getCarPanel().getWidth();
            int limiteDerecho = 550;


            if (x - juego.getVelocidad_horizontal() < limiteDerecho) {
                juego.getCarPanel().setLocation(x + juego.getVelocidad_horizontal(), y);
            }
        }
    }

    /**
     * No se utiliza en esta implementacion.
     *
     * @param e El evento de teclado generado.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        //no la usamos
    }
}