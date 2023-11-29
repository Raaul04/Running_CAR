package VideoJuego;

import javax.swing.*;
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
        // Bucle principal de actualización del juego
        double dibujarIntervalo=1000000000/FPS;
        double siguenteDibujo=System.nanoTime()+dibujarIntervalo;
        int i=1;
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

                /*if (colision()) {
                    System.out.println("¡Chocaste!");
                    terminarJuego();
                }*/

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
