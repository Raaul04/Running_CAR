package VideoJuego;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.Random;

/**
 * La clase Juego representa el juego principal que incluye la ventana de juego,
 * el coche del jugador y la lógica asociada.
 * Extiende JPanel para proporcionar un lienzo en el que se representarán los elementos del juego.
 */
public class Juego extends JPanel implements Runnable {

    Thread gameThread;
    private int FPS=60;//cantidad de fotogramas por segundo a la que queremos que funcione el juego,
    private Coche_Player coche;
    Controles ctrl;


    private JFrame fr;
    private JPanel carPanel;
    private JPanel obstaculoPanel;
    private JLabel background;
    private int velocidad_horizontal;
    private int width;
    private int height;

    private int xObstaculo=250;
    private int yObstaculo=5;

    private int nivel=0;
    private int puntos = 0;


    /**
     * Constructor de la clase Juego.
     * Inicializa las variables de configuración del juego y llama al método IniciarJuego().
     */
    public Juego() {
        width = 823;
        height = 645;
        velocidad_horizontal =15;
        ctrl = new Controles(this);
        IniciarJuego();
    }

    /**
     * Inicializa y configura la ventana principal del juego.
     * Configura la interfaz gráfica de usuario, establece el fondo y posiciona el coche.
     */
    private void IniciarJuego() {
        fr = new JFrame("Running Car");
        fr.setLayout(null);
        background = new JLabel("", new ImageIcon(Objects.requireNonNull(getClass().getResource("/background-image.jpg"))), JLabel.CENTER);
        background.setBounds(0, 0, width, height);
        fr.add(background);

        carPanel = new JPanel();
        carPanel.setSize(180, 150);

        // Añadir imagen del coche al JPanel
        ImageIcon carIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Coche.png")));
        Image image = carIcon.getImage(); // Convertir el ImageIcon a Image
        Image scaledImage = image.getScaledInstance(180, 150, Image.SCALE_SMOOTH); // Escalar la imagen al tamaño deseado
        ImageIcon scaledCarIcon = new ImageIcon(scaledImage);
        JLabel carLabel = new JLabel(scaledCarIcon);
        carPanel.add(carLabel);
        carPanel.setLocation(400, 350);
        carPanel.setOpaque(false); // No mostrar el fondo transparente


        obstaculoPanel=new JPanel();
        obstaculoPanel.setSize(123,277);

        // Añadir imagen del Coche_Obstaculo al JPanel
        ImageIcon obstaculoIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Coche_Obstaculo.png")));
        Image image1 = obstaculoIcon.getImage();
        Image scaledImage1 = image1.getScaledInstance(90, 160, Image.SCALE_SMOOTH); // Escalar la imagen al tamaño deseado
        ImageIcon scaledObstaculoIcon = new ImageIcon(scaledImage1);
        JLabel obstaculo = new JLabel(scaledObstaculoIcon);
        obstaculoPanel.add(obstaculo);
        obstaculoPanel.setLocation(250, 5);  // ajustar la ubicación del obstáculo
        System.out.println("OBSTACULO EN POSICION");

        obstaculoPanel.setOpaque(false); // No mostrar el fondo transparente



        //Añadir imagen de la moto Obstaculo al JPanel









        //Añadir imagen de la valla al JPanel









        // Configuración de la ventana principal
        background.add(carPanel);
        background.add(obstaculoPanel);
        fr.setSize(width, height); // Ajustar el tamaño
        fr.setVisible(true);
        fr.setResizable(false); // Evitar que el coche se mueva al ampliar el frame
        fr.setLocationRelativeTo(null);
        fr.addKeyListener(ctrl);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //UN hilo


    }




    public JPanel getObstaculoPanel() {
        return obstaculoPanel;
    }

    public int getVelocidad_horizontal() {
        return velocidad_horizontal;
    }

    public void setVelocidad_horizontal(int velocidad_horizontal) {
        this.velocidad_horizontal = velocidad_horizontal;
    }

    /**
     * Implementación del método run de la interfaz Runnable.
     * Contiene la lógica principal para la ejecución del juego en un hilo separado.
     * Controla el ciclo del juego y actualiza la lógica a una frecuencia objetivo de 60 FPS.
     */
    public void starGameThread(){
        gameThread=new Thread(this);
        gameThread.start();
    }
    public void run() {
        // Bucle principal de actualización del juego
        double dibujarIntervalo=1000000000/FPS;
        double siguenteDibujo=System.nanoTime()+dibujarIntervalo;
        Random random = new Random();


        int i=5;

        while (gameThread!=null) {

            // Pausa para mantener la frecuencia de actualización
            try {
                double tiempoEspera=siguenteDibujo-System.nanoTime();
                tiempoEspera=tiempoEspera/1000000;

                obstaculoPanel.setLocation(xObstaculo, yObstaculo+=5);
                i++;
                System.out.println("i: "+ i);



                /*
                if(obstaculoPanel.getY()>=645||obstaculoPanel.getX()<120||obstaculoPanel.getX()>520){

                    obstaculoPanel.y =5 ;
                    obstaculoPanel.x = random.nextInt(401)+120;//Ajusta el rango segun los limites izquierdo y derechos


                    //obstaculoPanel.getGame().sumaPuntos(obstaculoPanel.getPuntos());
                }*/
                //obstaculoPanel.setLocation();

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

    public int getFPS() {
        return FPS;
    }

    public JPanel getCarPanel() {
        return carPanel;
    }

    public void setFPS(int fps) {
        this.FPS = fps;
    }

    /**
     * Devuelve la posicion en X del obstaculo.
     */


    /**
     * Devuelve la posicion en Y del obstaculo.
     */

    public JPanel getObstaculoCoche(){
        return obstaculoPanel;
    }
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void sumaPuntos(int puntos) {

    }
    /**
     * Devuelve los puntos del obstaculo.
     * @return puntos del obstaculo
     */
    public int getPuntos(){

        return puntos;
    }

}
