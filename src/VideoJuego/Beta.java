package VideoJuego;

/**
 * La clase Beta representa un nivel específico del juego.
 */
public class Beta extends Nivel {

    /**
     * Instancia de la clase Juego asociada al nivel Beta.
     */
    private Juego juego;

    /**
     * Constructor de la clase Beta.
     *
     * @param numeroNivel Número de identificación del nivel.
     * @param juego       Instancia de la clase Juego asociada al nivel Beta.
     */
    public Beta(int numeroNivel, Juego juego) {
        super(numeroNivel);
        this.juego = juego;
    }

    /**
     * Inicializa el nivel Beta.
     * Imprime un mensaje indicando que se está inicializando el nivel.
     */
    @Override
    public void inicializar() {
        System.out.println("Inicializando nivel " + getNumeroNivel());
    }

    /**
     * Termina el nivel Beta.
     * Imprime un mensaje indicando que se ha terminado el nivel.
     */
    @Override
    public void terminarNivel() {
        System.out.println("Terminaste nivel " + getNumeroNivel());
    }
}
