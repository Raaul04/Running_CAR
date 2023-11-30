package VideoJuego;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Gameloop  extends Thread {
    private int FPS=60;//cantidad de fotogramas por segundo a la que queremos que funcione el juego,
    private Juego juego;
    boolean haTerminado=true;
    Gameloop(Juego juego){
        this.juego=juego;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000); // Pausa de 1 segundo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Bucle principal de actualización del juego
        double dibujarIntervalo = 1000000000.0 / FPS;
        double siguenteDibujo=System.nanoTime()+dibujarIntervalo;
        JPanel obstaculo=juego.getObstaculoPanel();
         int obstaculoY= juego.getyObstaculo();
        Random random=new Random();
        int obstaculoX= random.nextInt(401) + 120;


        while (haTerminado) {
            // Pausa para mantener la frecuencia de actualización
            try {
                double tiempoEspera=siguenteDibujo-System.nanoTime();
                tiempoEspera=tiempoEspera/1000000;

                if(tiempoEspera<0){
                    tiempoEspera=0;
                }

                obstaculo.setLocation(obstaculo.getX(),obstaculo.getY()+5);

                if (obstaculo.getY() >= 470) {
                    // Generar una nueva posición aleatoria para el obstáculo
                    obstaculoY = 0;
                    obstaculoX = random.nextInt(401) + 120;
                    obstaculo.setLocation(obstaculoX, obstaculoY);
                }


                Thread.sleep((long)tiempoEspera);
                siguenteDibujo+=dibujarIntervalo;

                if (colision()) {
                    System.out.println("¡Chocaste!");
                    terminarJuego();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    // Función para verificar colisiones
    public boolean colision() {
        Rectangle carBounds = juego.getCarPanel().getBounds();
        Rectangle obstaculoBounds = juego.getObstaculoPanel().getBounds();
        return ((Rectangle) carBounds).intersects(obstaculoBounds);
    }

    private void terminarJuego() {
        JOptionPane.showMessageDialog(null, "Game Over. ¡Chocaste!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        haTerminado = false;
        System.exit(0);
    }
}
