package Juego;

import Vehiculos.Vehiculo;

/**
 *La clase Coche representa un tipo de vehiculo que puede cambiar de carril aleatoriamente para esquivar obstaculos.
 */
public class Coche_Player extends Vehiculo {
    private int carrilActual;
    private int velocidad;

    /**
     * Es el constructor
     */
    public Coche_Player() {
        super(10); // Velocidad constante del coche
        this.carrilActual = 2; // El coche comienza en el carril central.
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
