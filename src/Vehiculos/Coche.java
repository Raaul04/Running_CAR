package Vehiculos;

public class Coche extends Vehiculo {
    private int carrilActual;

    public Coche() {
        super(10); // Velocidad constante del coche
        this.carrilActual = 2; // El coche comienza en el carril central.
    }

    @Override
    public void esquivarObstaculo() {
        // Simulación simple: Cambiar de carril para esquivar obstáculos.
        int nuevoCarril = carrilActual; // Inicialmente, el coche no cambia de carril.

        // Lógica para esquivar obstáculos.
        if (carrilActual == 1) {
            nuevoCarril = 2;
        } else if (carrilActual == 2) {
            // El coche alterna entre los carriles 1 y 3 para esquivar obstáculos.
            nuevoCarril = (Math.random() < 0.5) ? 1 : 3;
        } else if (carrilActual == 3) {
            nuevoCarril = 2;
        }

        if (nuevoCarril != carrilActual) {
            cambiarDeCarril(nuevoCarril);
        }
    }

    public void cambiarDeCarril(int nuevoCarril) {
        carrilActual = nuevoCarril;
        System.out.println("Vehiculos.Coche cambió al carril " + nuevoCarril);
    }


}
