package VideoJuego;

/**
 * La clase abstracta Nivel representa un nivel en el juego.
 */
public abstract class Nivel {
    /**
     * Número de identificacion del nivel.
     */
    private int numeroNivel;

    /**
     * Dificultad del nivel.
     */
    private String dificultad;

    /**
     * Puntuación necesaria para subir de nivel.
     */
    private int puntuacionNecesaria;

    /**
     * Constructor de la clase Nivel.
     *
     * @param numeroNivel        Número de identificación del nivel.
     * @param puntuacionNecesaria Puntuación necesaria para subir de nivel.
     */
    public Nivel(int numeroNivel, int puntuacionNecesaria) {
        this.numeroNivel = numeroNivel;
        this.puntuacionNecesaria = puntuacionNecesaria;
    }

    /**
     * Constructor de la clase Nivel con dificultad.
     *
     * @param numeroNivel Número de identificación del nivel.
     * @param dificultad   Dificultad del nivel.
     */
    public Nivel(int numeroNivel, String dificultad) {
        this.numeroNivel = numeroNivel;
        this.dificultad = dificultad;
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
     * Obtiene la dificultad del nivel.
     *
     * @return La dificultad del nivel.
     */
    public String getDificultad() {
        return dificultad;
    }

    /**
     * Método abstracto para inicializar el nivel.
     */
    public abstract void inicializar();

    /**
     * Método abstracto para terminar el nivel.
     */
    public abstract void terminarNivel();

    public abstract void aumentarNivel();
}
