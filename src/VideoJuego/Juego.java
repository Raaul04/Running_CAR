package VideoJuego;
import VideoJuego.Coche_Player;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * La clase Juego representa el juego principal que incluye la ventana de juego,
 * el coche del jugador y la lógica asociada.
 * Extiende JPanel para proporcionar un lienzo en el que se representarán los elementos del juego.
 */
public class Juego extends JPanel implements Runnable{
    private boolean running = false;
    private final int FPS = 60; //cantidad de fotogramas por segundo a la que queremos que funcione el juego,
    //60 ya que para este tipo de juego creemos que es lo adecuado
    private double tiempoRequerido = 1000000000/FPS; //tiempo requerido para cada FPS, usando nanosegundos ya que es mas preciso
    private double delta = 0; //almacena temporalmente el tiempo que va pasando
    private int averageFPS = FPS; //promedio de FPS para ver el numero de FPS en los que estamos ya que dependiendo de la accion estos pueden subir o bajar
    private Coche_Player coche;
    JFrame fr;
    JPanel carPanel;
    Controles ctrl;
    JLabel background;
    int velocidad;
    int width;
    int height;

    public Juego(){
        width=823;
        height=645;
        velocidad=10;
        ctrl=new Controles(this);
        IniciarJuego();
    }

        private void IniciarJuego() {

            fr = new JFrame("Running Car");
            fr.setLayout(null);
            background = new JLabel("", new ImageIcon(getClass().getResource("/background-image.jpg")), JLabel.CENTER);
            background.setBounds(0,0,width,height);
            fr.add(background);
            carPanel=new JPanel();
            carPanel.setSize(180,150);

            //Lo añadimos al JPanel
            ImageIcon carIcon = new ImageIcon(getClass().getResource("/Coche.png"));
            Image image = carIcon.getImage(); // Convertimos el ImageIcon a Image
            Image scaledImage = image.getScaledInstance(180, 150, Image.SCALE_SMOOTH); // Escala la imagen al tamaño deseado
            ImageIcon scaledCarIcon = new ImageIcon(scaledImage);
            JLabel carLabel = new JLabel(scaledCarIcon);

            carPanel.add(carLabel);
            carPanel.setLocation(400,350);
            //Que no se vea el fondo transparente
            carPanel.setOpaque(false);


            // Configurar la ventana principal
            background.add(carPanel);
            //fr.add(carPanel);
            fr.setSize(width,height);// Ajusta el tamaño
            fr.setVisible(true);
            fr.setResizable(false);//con esto no se mueve el coche al ampliar el frame
            fr.setLocationRelativeTo(null);
            fr.addKeyListener(ctrl);
            fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar elementos del juego aquí (si es necesario)
    }

    public void startGame() {
        running = true;

        Thread gameThread = new Thread(this);
        gameThread.start();
    }

}


