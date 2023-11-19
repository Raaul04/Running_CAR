package VideoJuego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * La clase Controles implementa la interfaz KeyListener para manejar eventos de teclado en el juego.
 * Controla las acciones del jugador, como mover el coche hacia la izquierda o la derecha.
 */
public class Controles implements KeyListener {
    Juego juego;
    Coche_Player coche;

    /**
     * Constructor de la clase Controles.
     *
     * @param ref La referencia al objeto Juego al que se aplicarán los controles.
     */
    public Controles(Juego ref) {
        this.juego = ref;
    }

    /**
     * No se utiliza en esta implementación.
     *
     * @param e El evento de teclado generado.
     */
    @Override
    public void keyTyped(KeyEvent e) {
        //no la usamos
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

        if (code == 37) {
            System.out.println("Presiono boton izquierdo ");
            int x = juego.carPanel.getX();
            int y = juego.carPanel.getY();

            System.out.println("Coordenadas :"+x + "," + y);

            if (x - juego.velocidad > 120) {
                juego.carPanel.setLocation(x - juego.velocidad, y);
            }
        }
        else if (code == 39) {
            System.out.println("Presiono boton derecho");

            int x = juego.carPanel.getX();
            int y = juego.carPanel.getY();

            System.out.println(x + "," + y);
            //Ahora necesitamos el tamaño del size
            int carWidth = juego.carPanel.getWidth();
            int limiteDerecho = 520;  // Ajusta este valor según tus necesidades

            // Imprimo porque me esta dando errores
            System.out.println("Posición actual del coche (x): " + x);
            System.out.println("Velocidad del juego: " + juego.velocidad);
            System.out.println("Ancho del coche: " + carWidth);
            System.out.println("Límite derecho: " + limiteDerecho);

            if (x < limiteDerecho) {
                juego.carPanel.setLocation(x + juego.velocidad, y);
                System.out.println("Nueva posición del coche (x): " + (x + juego.velocidad));
            } else {
                System.out.println("El coche alcanzó el límite derecho, no se mueve.");
            }

        }

    }

    /**
     * No se utiliza en esta implementación.
     *
     * @param e El evento de teclado generado.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        //no la usamos
    }
}