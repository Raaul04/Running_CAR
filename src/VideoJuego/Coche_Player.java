package VideoJuego;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Coche_Player {
    int vidas;
    private int velocidadHorizontal = 15;

    public Coche_Player() {
        this.vidas = 3;
    }

    /**
     * Pinta la imagen del coche en las coordenadas dadas, escalándola al tamaño especificado.
     * @param g El contexto gráfico en el que se pinta el coche.
     * @param x La coordenada x donde se pintará el coche.
     * @param y La coordenada y donde se pintará el coche.
     * @param ancho El ancho al que se escalará la imagen del coche.
     * @param alto El alto al que se escalará la imagen del coche.
     */
    public void pintarCoche(Graphics g, int x, int y, int ancho, int alto) {
        ImageIcon cocheIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Coche.png")));
        Image image = cocheIcon.getImage();

        // Escalar la imagen al tamaño deseado
        Image scaledImage = image.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

        // Pintar la imagen escalada
        g.drawImage(scaledImage, x, y, ancho, alto, null);
    }


}
