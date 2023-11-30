package VideoJuego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * La clase Controles implementa la interfaz KeyListener para manejar eventos de teclado en el juego.
 * Controla las acciones del jugador, como mover el coche hacia la izquierda o la derecha.
 */
public class Mecanica implements KeyListener {
    Juego juego;
    Coche_Player coche;

    private Random random;
    private int xObstaculo=0 ;
    private int yObstaculo;

    /**
     * Constructor de la clase Controles.
     *
     * @param ref La referencia al objeto Juego al que se aplicarán los controles.
     */
    public Mecanica(Juego ref) {
        this.juego = ref;
        this.random = new Random();
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

            if (x - juego.getVelocidad_horizontal() > 120) {
                juego.getCarPanel().setLocation(x - juego.getVelocidad_horizontal(), y);
                //moverObstaculoAleatorio();
                //System.out.println("Avanzando");
                /*if (yObstaculo >= 470) {
                    yObstaculo = 0;  // Restablece la posición y del obstáculo
                    juego.getObstaculoPanel().setLocation(xObstaculo, yObstaculo);
                }*/
            }
            else{
                System.out.println("Alcanzo el limite Izquierdo, no se mueve");
            }

        } else if (code == 39) { // Tecla derecha
            int x = juego.getCarPanel().getX();
            int y = juego.getCarPanel().getY();
            int carWidth = juego.getCarPanel().getWidth();
            int limiteDerecho = 520;

            if (x < limiteDerecho) {
                juego.getCarPanel().setLocation(x + juego.getVelocidad_horizontal(), y);
                //moverObstaculoAleatorio();
                //System.out.println("Avanzando");
                /*if (yObstaculo >= 470) {
                    yObstaculo = 0;  // Restablece la posición y del obstáculo
                    juego.getObstaculoPanel().setLocation(xObstaculo, yObstaculo);
                }*/
            } else {
                System.out.println("El coche alcanzó el límite derecho, no se mueve.");
            }
        }
    }

    /*
    public void moverObstaculoAleatorio() {
        int nuevoXObstaculo = xObstaculo + random.nextInt(201) - 100;

        // Ajusta los límites para xObstaculo
        int limiteIzquierdo = 120;
        int limiteDerecho = 520; // Ajusta este valor según tus necesidades

        if (nuevoXObstaculo < limiteIzquierdo) {
            nuevoXObstaculo = limiteIzquierdo;
        } else if (nuevoXObstaculo > limiteDerecho) {
            nuevoXObstaculo = limiteDerecho;
        }

        xObstaculo = nuevoXObstaculo;

        juego.getObstaculoCoche().setLocation(xObstaculo, yObstaculo += 15);
    }

     */
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