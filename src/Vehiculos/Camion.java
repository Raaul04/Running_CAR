package Vehiculos;

public class Camion extends Vehiculo {
    private int carrilActual;

    public Camion(int velocidadInicial) {
        super(velocidadInicial);
        // Inicialmente, los camiones pueden estar en cualquier carril (1, 2 o 3).
        this.carrilActual = (int) (Math.random() * 3) + 1;
    }

    @Override
    public void esquivarObstaculo() {
        // Los camiones cambian aleatoriamente de carril para dificultar el adelantamiento.
        int nuevoCarril;
        do {
            nuevoCarril = (int) (Math.random() * 3) + 1;
        } while (nuevoCarril == carrilActual);
        cambiarDeCarril(nuevoCarril);
    }

    public void cambiarDeCarril(int nuevoCarril) {
        if (nuevoCarril != carrilActual) {
            System.out.println("Camion cambió del carril " + carrilActual + " al carril " + nuevoCarril);
            carrilActual = nuevoCarril;
        }
    }
}
