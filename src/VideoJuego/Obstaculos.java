package VideoJuego;

import java.awt.*;

/**
 * La clase Obstaculos representa un obstáculo en un videojuego. Cada obstáculo tiene una posición (x, y)
 * y dimensiones (ancho y alto) que determinan su área en el espacio del juego.
 */
public class Obstaculos {
    private int x, y, width, height;

    /**
     * Construye un nuevo objeto Obstaculos con la posición y dimensiones especificadas.
     *
     * @param x      La coordenada x del obstáculo.
     * @param y      La coordenada y del obstáculo.
     * @param width  El ancho del obstáculo.
     * @param height El alto del obstáculo.
     */
    public Obstaculos(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Devuelve un objeto Rectangle que representa el área delimitada por el obstáculo.
     *
     * @return Un objeto Rectangle que representa el área del obstáculo.
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
