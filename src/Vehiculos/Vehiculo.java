package Vehiculos;

/**
 * La clase abstracta Vehiculo representa un tipo generico de vehiculo que se mueve en una carretera.
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
     * Mueve el vehiculo avanzando su posición en la carretera y llama al metodo para esquivar obstaculos.
     */
    public void mover() {
        posicionX += velocidad;
        esquivarObstaculo();
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
     * Metodo abstracto que debe ser implementado por las subclases para esquivar obstaculos de manera especifica.
     */
    public abstract void esquivarObstaculo();

    /**
     * Verifica si el vehiculo colisiona con otro vehiculo.
     *
     * @param otroVehiculo El vehiculo con el que se verifica la colision.
     * @return `true` si hay colision, `false` de lo contrario.
     */
    public boolean colisionCon(Vehiculo otroVehiculo) {
        int distancia = Math.abs(this.posicionX - otroVehiculo.getPosicionX());
        return distancia < 20; // Ajusta este valor según la lógica de colisión deseada
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
