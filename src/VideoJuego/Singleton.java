package VideoJuego;

/**
 * Clase Singleton que garantiza la existencia de una única instancia de la clase Juego.
 */
public final class Singleton {

    // Instancia única del juego
    private static Juego juego;

    // Instancia única del Singleton
    private static Singleton instance;

    /**
     * Constructor privado para evitar la instanciación directa de la clase.
     * Se utiliza un constructor privado para forzar el uso del método getInstance().
     */
    private Singleton() {/* Constructor privado para evitar instanciación directa*/ }

    /**
     * Método para obtener la única instancia de la clase Singleton.
     * Si no existe una instancia, se crea una, emulando una inicialización lenta.
     *
     * @return La única instancia de Singleton.
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
     * Método para obtener la única instancia del juego.
     * Si no existe una instancia, se crea una.
     *
     * @return La única instancia del juego.
     */
    public static Juego getJuego() {
        if (juego == null) {
            juego = new Juego(null);
        }
        return juego;
    }
}
