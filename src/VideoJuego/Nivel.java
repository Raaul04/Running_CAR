package VideoJuego;

/**
 * La clase abstracta Nivel representa un nivel en el juego.
 */
public abstract class Nivel {

    /**
     * Número de identificación del nivel.
     */
    private int numeroNivel;

    /**
     * Constructor de la clase Nivel.
     *
     * @param numeroNivel Número de identificación del nivel.
     */
    public Nivel(int numeroNivel) {
        this.numeroNivel = numeroNivel;
    }

    /**
     * Obtiene el número de identificación del nivel.
     *
     * @return El número de identificación del nivel.
     */
    public int getNumeroNivel() {
        return numeroNivel;
    }

    /**
     * Método abstracto para inicializar el nivel.
     */
    public abstract void inicializar();

    /**
     * Método abstracto para terminar el nivel.
     */
    public abstract void terminarNivel();
}
