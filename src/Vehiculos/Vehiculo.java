package Vehiculos;

public abstract class Vehiculo {
    private int posicionX;
    private int velocidad;

    public Vehiculo(int velocidadInicial) {
        this.velocidad = velocidadInicial;
        this.posicionX = 0;
    }

    public void mover() {
        posicionX += velocidad;
        esquivarObstaculo();
    }

    public void acelerar() {
        velocidad += 1;
    }

    public void frenar() {
        if (velocidad > 0) {
            velocidad -= 1;
        }
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public abstract void esquivarObstaculo();

    /**
     * Devuelve una representación en forma de cadena del objeto que incluye el nombre de la clase
     * y la posición actual del vehículo.
     *
     * @return Una cadena que muestra el tipo de vehículo y su posición.
     */
    @Override
    public String toString() {
        return this.getClass().getName() + " en la posición " + posicionX;
    }
}
