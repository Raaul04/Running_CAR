package Vehiculos;

/**
 * La clase abstracta Vehiculo representa un tipo genérico de vehículo que se mueve en una carretera.
 */
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
     * Mueve el vehículo avanzando su posición en la carretera y llama al método para esquivar obstáculos.
     */
    public void mover() {
        posicionX += velocidad;
        esquivarObstaculo();
    }

    /**
     * Aumenta la velocidad del vehículo en una unidad.
     */
    public void acelerar() {
        velocidad += 1;
    }

    /**
     * Reduce la velocidad del vehículo en una unidad, si es mayor que cero.
     */
    public void frenar() {
        if (velocidad > 0) {
            velocidad -= 1;
        }
    }

    /**
     * Obtiene la velocidad actual del vehículo.
     *
     * @return La velocidad actual del vehículo.
     */
    public int getVelocidad() {
        return velocidad;
    }

    /**
     * Obtiene la posición actual del vehículo en la carretera.
     *
     * @return La posición actual del vehículo.
     */
    public int getPosicionX() {
        return posicionX;
    }

    /**
     * Método abstracto que debe ser implementado por las subclases para esquivar obstáculos de manera específica.
     */
    public abstract void esquivarObstaculo();

    /**
     * Verifica si el vehículo colisiona con otro vehículo.
     *
     * @param otroVehiculo El vehículo con el que se verifica la colisión.
     * @return `true` si hay colisión, `false` de lo contrario.
     */
    public boolean colisionCon(Vehiculo otroVehiculo) {
        int distancia = Math.abs(this.posicionX - otroVehiculo.getPosicionX());
        return distancia < 20; // Ajusta este valor según la lógica de colisión deseada
    }

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
