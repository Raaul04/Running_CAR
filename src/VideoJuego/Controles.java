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
    private int xObstaculo= 200, yObstaculo=5;


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
            int x = juego.getCarPanel().getX();
            int y = juego.getCarPanel().getY();

            System.out.println("Coordenadas :"+x + "," + y);

            if (x - juego.getVelocidad_horizontal() > 120) {
                juego.getCarPanel().setLocation(x - juego.getVelocidad_horizontal(), y);
                //juego.getObstaculoCoche().setLocation(xObstaculo,yObstaculo+=5);

            }
        }
        else if (code == 39) {
            System.out.println("Presiono boton derecho");

            int x = juego.getCarPanel().getX();
            int y = juego.getCarPanel().getY();

            System.out.println(x + "," + y);
            //Ahora necesitamos el tamaño del size
            int carWidth = juego.getCarPanel().getWidth();
            int limiteDerecho = 520;  // Ajusto este valor según  mis necesidades

            // DEPURAR porque me esta dando errores
            System.out.println("Posición actual del coche (x): " + x);
            System.out.println("Velocidad del juego: " + juego.getVelocidad_horizontal());
            System.out.println("Ancho del coche: " + carWidth);
            System.out.println("Límite derecho: " + limiteDerecho);

            if (x < limiteDerecho) {
                juego.getCarPanel().setLocation(x + juego.getVelocidad_horizontal(), y);
                //juego.getObstaculoPanel().setLocation(xObstaculo,yObstaculo+=5);
                System.out.println("Nueva posición del coche (x): " + (x + juego.getVelocidad_horizontal()));
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