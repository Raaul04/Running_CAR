package Vehiculos;

public class Camion extends Vehiculo {
    private int posicion;
    public Camion() {
        super(15); // Velocidad constante del camión
        posicion=0;
    }

    @Override
    public void esquivarObstaculo() {
        // Implementación para actuar como un obstáculo (sin esquivar obstáculos).
        System.out.println("¡Camión en la posicion "+ posicion+"  debes esquivarlo");
        //Actualiza la posicion
        System.out.println("Camion esquivado con exito");
    }
    public void avanzar(){
        posicion++;
    }
}
