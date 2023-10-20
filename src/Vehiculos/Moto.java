package Vehiculos;

public class Moto extends Vehiculo {
    private int carrilActual;

    public Moto(int velocidadInicial) {
        super(velocidadInicial);
        // Inicialmente, las motos pueden estar en cualquier carril (1, 2 o 3).
        this.carrilActual = (int) (Math.random() * 3) + 1;
    }

    @Override
    public void esquivarObstaculo() {
        // Las motos cambian aleatoriamente de carril para dificultar el adelantamiento.
        int nuevoCarril;
        do {
            nuevoCarril = (int) (Math.random() * 3) + 1;
        } while (nuevoCarril == carrilActual);
        cambiarDeCarril(nuevoCarril);
    }

    public void cambiarDeCarril(int nuevoCarril) {
        if (nuevoCarril != carrilActual) {
            System.out.println("Moto cambió del carril " + carrilActual + " al carril " + nuevoCarril);
            carrilActual = nuevoCarril;
        }
    }
}
