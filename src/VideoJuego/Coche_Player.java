package VideoJuego;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Coche_Player extends Vehiculo {
    private int carrilActual;
    private int velocidad;
    private JFrame frame;
    private JLabel cocheLabel; // JLabel para mostrar la imagen del coche

    Coche_Player() {
        super(15);
        this.carrilActual = 2; // El coche comienza en el carril central.
        this.frame = frame;

    }

    public void actualizarPosicion() {
        cocheLabel.setBounds(250 + carrilActual * 100, 500, 90, 90);
        cocheLabel.repaint();
    }

    /**
     * Metodo para acelerar el vehiculo
     */
    public void acelerar() {
        velocidad += 1;
        actualizarPosicion();

    }

    /**
     * Metodo para frenar el vehiculo
     */
    public void frenar() {
        if (velocidad > 0) {
            velocidad -= 1;
            actualizarPosicion();

        }
    }



    public JLabel getCocheLabel() {
        return cocheLabel;
    }
}