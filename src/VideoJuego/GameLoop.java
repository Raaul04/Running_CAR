/*package VideoJuego;

import javax.swing.*;
import java.awt.*;

public class GameLoop extends JPanel implements Runnable{

    private Juego juego; // Referencia al juego que se actualizará
    Thread gameThread;
    int FPS=60;
    public GameLoop(Juego juego) {
        this.juego = juego;
    }

    public void starGameThread(){
        gameThread=new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        // Bucle principal de actualización del juego
         double dibujarIntervalo=1000000000/FPS;
         double siguenteDibujo=System.nanoTime()+dibujarIntervalo;

        while (gameThread!=null) {
            update();
            repaint();
            // );

            //Point posObstaculo = juego.getPosicionObstaculo();
            //posObstaculo.y += 5;
            //juego.setPosicionObstaculo(posObstaculo);

            // Pausa para mantener la frecuencia de actualización
            try {
                double tiempoEspera=siguenteDibujo-System.nanoTime();
                tiempoEspera=tiempoEspera/1000000;
                if(tiempoEspera<0){
                    tiempoEspera=0;
                }

                Thread.sleep((long)tiempoEspera);
                siguenteDibujo+=dibujarIntervalo;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void update(){

    }
    /**
     * Método de representación gráfica de los elementos del juego.
     * Se llama automáticamente para dibujar en el lienzo del JPanel.
     *
     * @param g El objeto Graphics utilizado para dibujar elementos en el lienzo.
     */
/*
    public void paintComponent(Graphics g ) {

        super.paintComponent(g);
        Graphics g2= (Graphics2D)g;
        g2.setColor(Color.WHITE);
        g2.fillRect(200,200,50,50);
        g2.dispose();

    }
}
*/