package VideoJuego;

public abstract class Vehiculo {
    private int posicionX;
    private int velocidad;

    /**
     * Constructor para crear una nueva instancia de Vehiculo con una velocidad inicial.
     *
     * @param velocidadInicial La velocidad inicial del vehículo.
     */
    public Vehiculo(int velocidadInicial) {
        this.velocidad = velocidadInicial;
        this.posicionX = 0;
    }

    /**
     * Mueve el vehiculo avanzando su posición en la carretera y llama al metodo para esquivar obstaculos.
     */
    public void mover() {
        posicionX += velocidad;
    }

    /**
     * Aumenta la velocidad del vehiculo en una unidad.
     */
    public void acelerar() {
        velocidad += 1;
    }

    /**
     * Reduce la velocidad del vehiculo en una unidad, si es mayor que cero.
     */
    public void frenar() {
        if (velocidad > 0) {
            velocidad -= 1;
        }
    }

    /**
     * Obtiene la velocidad actual del vehiculo.
     *
     * @return La velocidad actual del vehiculo.
     */
    public int getVelocidad() {
        return velocidad;
    }
    /**
     * Obtiene la posicion actual del vehiculo en la carretera.
     *
     * @return La posicion actual del vehiculo.
     */
    public int getPosicionX() {
        return posicionX;
    }
    /**
     * Devuelve una representacion en forma de cadena del objeto que incluye el nombre de la clase
     * y la posición actual del vehículo.
     *
     * @return Una cadena que muestra el tipo de vehículo y su posicion.
     */
    @Override
    public String toString() {
        return this.getClass().getName() + " en la posicion " + posicionX;
    }

}