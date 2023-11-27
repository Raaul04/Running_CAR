/*package VideoJuego;

import java.util.Random;

public class gameThread extends Thread{
    private int xObstaculo=250;
    private int yObstaculo=5;
    Juego juego;
    private int FPS=60;//cantidad de fotogramas por segundo a la que queremos que funcione el juego,
    private int tiempoEspera;
    private int i=0;

    gameThread(Juego juego){
        this.juego=juego;
    }
    @Override
    public void run() {
        // Bucle principal de actualización del juego
        double dibujarIntervalo=1000000000/FPS;
        double siguenteDibujo=System.nanoTime()+dibujarIntervalo;
        Random random = new Random();



        while (true) {

            // Pausa para mantener la frecuencia de actualización
            try {
                //double tiempoEspera=siguenteDibujo-System.nanoTime();
                //tiempoEspera=tiempoEspera/1000000;

                juego.obstaculoPanel.setLocation(xObstaculo, yObstaculo+=5);
                i++;
                System.out.println("i: "+ i);



                /*
                if(obstaculoPanel.getY()>=645||obstaculoPanel.getX()<120||obstaculoPanel.getX()>520){

                    obstaculoPanel.y =5 ;
                    obstaculoPanel.x = random.nextInt(401)+120;//Ajusta el rango segun los limites izquierdo y derechos


                    //obstaculoPanel.getGame().sumaPuntos(obstaculoPanel.getPuntos());
                }*/
                //obstaculoPanel.setLocation();
/*
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
}
*/
