package Vehiculos;

public class Moto extends Vehiculo {
    private int posicion;

    public Moto() {
        super(25); // Velocidad constante de la moto
        this.posicion = 0; // Inicialmente, la moto comienza en la posición 0.
    }

    @Override
    public void esquivarObstaculo() {
        // Implementación para actuar como un obstáculo (sin esquivar obstáculos).
        System.out.println("Moto en el camino en la posición " + posicion + " Debes esquivarla.");
        // Actualiza la posición de la moto hacia adelante en cada llamada.
        System.out.println("Moto esquivada con exito");
        avanzar();
    }

    public void avanzar() {
        // Simplemente incrementa la posición en cada llamada.
        posicion++;
    }
}
