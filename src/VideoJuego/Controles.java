package VideoJuego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controles implements KeyListener {
    Juego juego;
    Coche_Player coche;

    public Controles(Juego ref) {
        this.juego = ref;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //no la usamos
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == 37) {
            System.out.println("Presiono boton izquierdo ");
            int x = juego.carPanel.getX();
            int y = juego.carPanel.getY();

            System.out.println("Coordenadas :"+x + "," + y);

            if (x - juego.velocidad > 120) {
                juego.carPanel.setLocation(x - juego.velocidad, y);
            }
        }
        else if (code == 39) {
            System.out.println("Presiono boton derecho");

            int x = juego.carPanel.getX();
            int y = juego.carPanel.getY();

            System.out.println(x + "," + y);
            //Ahora necesitamos el tamaño del size
            int carWidth = juego.carPanel.getWidth();
            int limiteDerecho = 520;  // Ajusta este valor según tus necesidades

            // Imprimo porque me esta dando errores
            System.out.println("Posición actual del coche (x): " + x);
            System.out.println("Velocidad del juego: " + juego.velocidad);
            System.out.println("Ancho del coche: " + carWidth);
            System.out.println("Límite derecho: " + limiteDerecho);

            if (x < limiteDerecho) {
                juego.carPanel.setLocation(x + juego.velocidad, y);
                System.out.println("Nueva posición del coche (x): " + (x + juego.velocidad));
            } else {
                System.out.println("El coche alcanzó el límite derecho, no se mueve.");
            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //no la usamos
    }
}