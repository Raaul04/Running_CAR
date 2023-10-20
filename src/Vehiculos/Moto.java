package Vehiculos;

/**
 * La clase Moto representa un tipo de vehículo que puede cambiar de carril aleatoriamente para esquivar obstáculos.
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
        this.carrilActual = (int) (Math.random() * 3) + 1;
    }

    /**
     * Implementación del método para que la moto esquive obstáculos cambiando de carril.
     */
    @Override
    public void esquivarObstaculo() {
        // Las motos cambian aleatoriamente de carril para dificultar el adelantamiento.
        int nuevoCarril;
        do {
            nuevoCarril = (int) (Math.random() * 3) + 1;
        } while (nuevoCarril == carrilActual);
        cambiarDeCarril(nuevoCarril);
    }

    /**
     * Cambia el carril actual de la moto a uno especificado.
     *
     * @param nuevoCarril El nuevo carril al que se moverá la moto.
     */
    public void cambiarDeCarril(int nuevoCarril) {
        if (nuevoCarril != carrilActual) {
            System.out.println("Moto cambió del carril " + carrilActual + " al carril " + nuevoCarril);
            carrilActual = nuevoCarril;
        }
    }
}
