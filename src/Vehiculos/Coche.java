package Vehiculos;

public class Coche extends Vehiculo {
    private int carrilActual;
    private int velocidad;

    public Coche() {
        super(10); // Velocidad constante del coche
        this.carrilActual = 2; // El coche comienza en el carril central.
    }

    public void cambiarCarrilIzquierdo() {
        if (carrilActual > 1) {
            cambiarDeCarril(carrilActual - 1);
        }
    }

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

    public void acelerar() {
        velocidad += 1;
    }

    public void frenar() {
        if (velocidad > 0) {
            velocidad -= 1;
        }
    }

    public void cambiarDeCarril(int nuevoCarril) {
        System.out.println("Vehiculos.Coche cambió del carril " + carrilActual + " al carril " + nuevoCarril);
        carrilActual = nuevoCarril;
    }
}
