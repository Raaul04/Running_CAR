package Vehiculos;

/**
 * La clase Moto representa un tipo de vehiculo que puede cambiar de carril aleatoriamente.
 */
public class Moto extends Vehiculo {
    private int carrilActual;

    /**
     * Constructor para crear una nueva instancia de Moto.
     *
     * @param velocidadInicial La velocidad inicial de la moto.
     */
    public Moto(int velocidadInicial) {
        super(velocidadInicial);
        // Inicialmente, las motos pueden estar en cualquier carril (1, 2 o 3).
        this.carrilActual = (int) (Math.random() * 4);
    }

    /**
     * Implementación del metodo para que la moto esquive obstaculos cambiando de carril.
     */
    @Override
    public void esquivarObstaculo() {
        // Las motos cambian aleatoriamente de carril para dificultar el adelantamiento.
        int nuevoCarril;
        do {
            nuevoCarril = (int) (Math.random() * 4) ;
        } while (nuevoCarril == carrilActual);
        cambiarDeCarril(nuevoCarril);
    }

    /**
     * Cambia el carril actual de la moto a uno especificado.
     *
     * @param nuevoCarril El nuevo carril al que se movera la moto.
     */
    public void cambiarDeCarril(int nuevoCarril) {
        if (nuevoCarril != carrilActual) {
            System.out.println("Moto cambio del carril " + carrilActual + " al carril " + nuevoCarril);
            carrilActual = nuevoCarril;
        }
    }
}
