package Vehiculos;

/**
 *La clase Camion representa un tipo de vehículo que puede cambiar de carril aleatoriamente
 */
public class Camion extends Vehiculo {
    private int carrilActual;

    /**
     * Es el constructor
     * @param velocidadInicial La velocidad que va a tener el camion
     */

    public Camion(int velocidadInicial) {
        super(velocidadInicial);
        // Inicialmente, los camiones pueden estar en cualquier carril (1, 2 o 3).
        this.carrilActual = (int) (Math.random() * 4) ;
    }


    @Override
    /**
     * El metodo esquivarObstaculo hace que
     * los camiones cambian aleatoriamente de carril para dificultar el adelantamiento.
     */
    public void esquivarObstaculo() {
        int nuevoCarril;
        do {
            nuevoCarril = (int) (Math.random() * 4) ;
        } while (nuevoCarril == carrilActual);
        cambiarDeCarril(nuevoCarril);
    }

    /**
     * Cambia el carril del camion a un carril especificado.
     *
     * @param nuevoCarril El nuevo carril al que se movera el camion.
     */
    public void cambiarDeCarril(int nuevoCarril) {
        if (nuevoCarril != carrilActual) {
            System.out.println("Camión cambio del carril " + carrilActual + " al carril " + nuevoCarril);
            carrilActual = nuevoCarril;
        }
    }
}