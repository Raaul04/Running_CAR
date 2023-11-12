package Juego;

import Vehiculos.Vehiculo;

import javax.swing.*;
import java.awt.*;
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

        // Cargar la imagen desde el archivo png con fondo transparente
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/Coche.png"));

        // Redimensionar la imagen del coche
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(90, 90, Image.SCALE_SMOOTH);

        // Configurar el JLabel para mostrar la imagen del coche redimensionada
        cocheLabel = new JLabel(new ImageIcon(resizedImage));

        // Configurar el tamaño preferido del JLabel
        cocheLabel.setPreferredSize(new Dimension(50, 50));

        // Configurar el diseño del contenido del JFrame usando BorderLayout
        ventana.setLayout(new BorderLayout());

        // Agregar el JLabel al centro del contenido del JFrame
        ventana.add(cocheLabel, BorderLayout.CENTER);

        // Establecer la imagen del icono de la ventana usando el objeto ImageIcon
        ventana.setIconImage(resizedImage);
    }

    public JLabel getCocheLabel() {
        return cocheLabel;
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
     *
     * @param nuevoCarril el nuevo carril
     */
    public void cambiarDeCarril(int nuevoCarril) {
        System.out.println("El Coche cambio del carril " + carrilActual + " al carril " + nuevoCarril);
        carrilActual = nuevoCarril;
    }
}
