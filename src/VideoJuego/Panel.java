package VideoJuego;

import javax.swing.JPanel;
import java.awt.Graphics;

/**
 * La clase Panel es una extensión de JPanel y se utiliza para representar un panel
 * en el juego. Override el método paintComponent para personalizar el dibujo en el panel.
 */
public class Panel extends JPanel {
    private JPanel panel;

    /**
     * Override del método paintComponent para personalizar el dibujo en el panel.
     *
     * @param g El objeto Graphics utilizado para dibujar elementos en el panel.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar un rectángulo en el panel en la posición (100, 100) con ancho 10 y altura 10
        g.fillRect(100, 100, 10, 10);
    }
}
