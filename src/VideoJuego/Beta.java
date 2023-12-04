package VideoJuego;

/**
 * La clase Beta representa un nivel especifico del juego.
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
        super(numeroNivel, getPuntuacionNecesaria(numeroNivel)); // Ajusta la puntuación necesaria según el nivel
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
     * Obtiene la puntuacion necesaria para subir de nivel según el número de nivel.
     *
     * @param numeroNivel Número de identificación del nivel.
     * @return Puntuación necesaria para subir de nivel.
     */
    public static int getPuntuacionNecesaria(int numeroNivel) {
        switch (numeroNivel) {
            case 1:
                return 100;
            case 2:
                return 200;
            case 3:
                return 300;
            case 4:
                return 500;
            default:
                return Integer.MAX_VALUE; // Puntuación maxima, nivel maximo
        }
    }

    /**
     * Termina el nivel Beta.
     * Imprime un mensaje indicando que se ha terminado el nivel.
     */
    @Override
    public void terminarNivel() {
        System.out.println("Terminaste nivel " + getNumeroNivel());
    }

    @Override
    public void aumentarNivel() {
        // Lógica específica para subir de nivel según tu diseño
        if (juego.getPuntos() >= getPuntuacionNecesaria(getNumeroNivel())) {
            juego.setVelocidadHorizontal(juego.getVelocidadHorizontal() + 1);
        }
    }

}
