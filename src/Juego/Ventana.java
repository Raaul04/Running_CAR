package Juego;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame implements Runnable{
    private boolean running = false;
    private final int FPS = 60; //cantidad de fotogramas por segundo a la que queremos que funcione el juego,
    //60 ya que para este tipo de juego creemos que es lo adecuado
    private double tiempoRequerido = 1000000000/FPS; //tiempo requerido para cada FPS, usando nanosegundos ya que es mas preciso
    private double delta = 0; //almacena temporalmente el tiempo que va pasando
    private int averageFPS = FPS; //promedio de FPS para ver el numero de FPS en los que estamos ya que dependiendo de la accion estos pueden subir o bajar

    private Juego juego;
    private Coche_Player coche;

    public Ventana(Panel panel) {
        setSize(400, 400); // Tamaño de la ventana de juego
        add(panel);
        coche = new Coche_Player(this); //  la ventana como parámetro al constructor del Coche_Player
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // la ventana se cierre correctamente
        setVisible(true);


    }
    @Override
    public void run() {
        //funciones para restringir el ciclo y hacer que vaya a 60 FPS
        long now = 0;
        long lastTime = System.nanoTime();  //registros del tiempo
        int frames = 0;
        long time = 0;

        while(running){
            now = System.nanoTime();
            delta += (now-lastTime)/tiempoRequerido; //tiempo que ha transcurrido
            time += (now-lastTime); //tiempo total
            lastTime = now;

            if(delta >= 1){
                update();
                delta --;
                frames ++;
            }
            if(time >= 1000000000){ //funcion para que cada segundo se actualizen los FPS
                averageFPS = frames;
                frames = 0;
                time = 0;
            }

        }



    }

    private void update() {
    }
}
