package VideoJuego;

/**
 * Clase Singleton que garantiza la existencia de una unica instancia de la clase Juego.
 */
public class Singleton {

    // Instancia única del juego
    private static Juego juego;

    // Instancia única del Singleton
    private static Singleton instance;

    /**
     * Constructor para evitar la instanciación directa de la clase.
     * Se utiliza un constructor privado para forzar el uso del metodo getInstance().
     */
    public Singleton() {/* Constructor para evitar instanciación directa*/ }

    /**
     * Metodo para obtener la única instancia de la clase Singleton.
     * Si no existe una instancia, se crea una, emulando una inicializacion lenta.
     *
     * @return La unica instancia de Singleton.
     */
    public static Singleton getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(1000);  // Emulando inicialización lenta
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * Metodo para obtener la única instancia del juego.
     * Si no existe una instancia, se crea una.
     *
     * @return La unica instancia del juego.
     */
    public static Juego getJuego() {
        if (juego == null) {
            juego = new Juego(null);
        }
        return juego;
    }
}
