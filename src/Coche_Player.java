package Juego;
import Vehiculos.Vehiculo;
import javax.swing.*;
import java.awt.event.KeyEvent;

public class Coche_Player extends Vehiculo {
    private int carrilActual;
    private int velocidad;
    private JFrame ventana;
    private JLabel cocheLabel; // JLabel para mostrar la imagen del coche

    public Coche_Player(JFrame ventana) {
        super(20);
        this.carrilActual = 2; // El coche comienza en el carril central.
        this.ventana = ventana;

        // Crear un objeto ImageIcon a partir de la ruta del archivo png
        ImageIcon icono = new ImageIcon("res/resources/Coche.png");

        // Configurar el JLabel para mostrar la imagen del coche
        cocheLabel = new JLabel(icono);

        // Establecer la imagen del icono de la ventana usando el objeto ImageIcon
        ventana.setIconImage(icono.getImage());
    }

    public JLabel getCocheLabel() {
        return cocheLabel;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) {
            // Presionó la tecla "a" (izquierda), implementa el giro a la izquierda aquí
            cambiarCarrilIzquierdo();
        } else if (key == KeyEvent.VK_D) {
            // Presionó la tecla "d" (derecha), implementa el giro a la derecha aquí
            cambiarCarrilDerecho();
        }
    }



    /**
     * Metodo para cambiar al carril izquierdo
     */
    public void cambiarCarrilIzquierdo() {
        if (carrilActual > 1) {
            cambiarDeCarril(carrilActual - 1);
        }
    }

    /**
     * Metodo para cambiar al carril derecho
     */

    public void cambiarCarrilDerecho() {
        if (carrilActual < 3) {
            cambiarDeCarril(carrilActual + 1);
        }
    }

    @Override
    public void esquivarObstaculo() {
        // La lógica de esquiva de obstáculos se maneja por el usuario.
        // El coche no cambia de carril automáticamente.
    }
    /**
     * Metodo para acelerar el vehiculo
     */
    public void acelerar() {
        velocidad += 1;
    }

    /**
     * Metodo para frenar el vehiculo
     */
    public void frenar() {
        if (velocidad > 0) {
            velocidad -= 1;
        }
    }

    /**
     * Metodo para cambiar de Carril
     * @param nuevoCarril el nuevo carril
     */
    public void cambiarDeCarril(int nuevoCarril) {
        System.out.println("El Coche cambio del carril " + carrilActual + " al carril " + nuevoCarril);
        carrilActual = nuevoCarril;
    }


}
