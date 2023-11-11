package Juego;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Juego extends JPanel {
    private Coche_Player coche;
    public static boolean haChocado = false;
    private Trafico vehiculos = new Trafico(this);

    public Juego() {
        JFrame miVentana = new JFrame("Running Car");

        miVentana.add(this);
        miVentana.setSize(500, 900);
        miVentana.setVisible(true);
        miVentana.setResizable(false);
        miVentana.setLocationRelativeTo(null);
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear una instancia de Coche_Player y pasarlo a la ventana
        coche = new Coche_Player(miVentana);

        // Agregar el KeyListener al coche
        miVentana.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();

                if (key == KeyEvent.VK_A) {
                    // Presionó la tecla "a" (izquierda), implementa el giro a la izquierda aquí
                    coche.cambiarCarrilIzquierdo();
                } else if (key == KeyEvent.VK_D) {
                    // Presionó la tecla "d" (derecha), implementa el giro a la derecha aquí
                    coche.cambiarCarrilDerecho();
                }
            }


            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        setFocusable(true);

        // Agregar el JLabel del coche a la ventana principal
        miVentana.add(coche.getCocheLabel());
    }
}
