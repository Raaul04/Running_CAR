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
public class Juego extends JPanel  {

    Thread gameThread;
    private Coche_Player coche;
    Mecanica ctrl;


    private JFrame fr;
    private JPanel carPanel;
    private JPanel obstaculoPanel;
    //private JPanel motoPanel;

    private JPanel valla;
    private JLabel background;
    private int velocidad_horizontal;
    private int width;
    private int height;


    //public boolean running;
    private Random random = new Random();
    private int xObstaculo= random.nextInt(401) + 120;
    private int yObstaculo=0;

    private int nivel=0;
    private int puntos = 0;



    /**
     * Constructor de la clase Juego.
     * Inicializa las variables de configuración del juego y llama al método IniciarJuego().
     */
    public Juego(Juego juego) {
        width = 823;
        height = 645;
        velocidad_horizontal =15;
        ctrl = new Mecanica(this);
        MetodoPrincipal();
    }


    /**
     * Inicializa y configura la ventana principal del juego.
     * Configura la interfaz gráfica de usuario, establece el fondo y posiciona el coche.
     */
    public void MetodoPrincipal() {
        //running = true;
        ctrl.coche = new Coche_Player();

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
        obstaculoPanel.setSize(150,277);

        // Añadir imagen del Coche_Obstaculo al JPanel
        ImageIcon obstaculoIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Coche_Obstaculo.png")));
        Image image1 = obstaculoIcon.getImage();
        Image scaledImage1 = image1.getScaledInstance(150, 160, Image.SCALE_SMOOTH); // Escalar la imagen al tamaño deseado
        ImageIcon scaledObstaculoIcon = new ImageIcon(scaledImage1);
        JLabel obstaculo = new JLabel(scaledObstaculoIcon);
        obstaculoPanel.add(obstaculo);
        obstaculoPanel.setLocation(xObstaculo, yObstaculo);  // ajustar la ubicación del obstáculo
        System.out.println("primera posicion*");
        //Mecanica controles=new Mecanica(this);
        //controles.moveObstacle();
        obstaculoPanel.setOpaque(false); // No mostrar el fondo transparente



/*

        //Añadir imagen de la moto Obstaculo al JPanel
        motoPanel=new JPanel();
        motoPanel.setSize(123,277);

        // Añadir imagen del Coche_Obstaculo al JPanel
        ImageIcon obstaculoIcon2 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Moto_Obstaculo.png")));
        Image image2 = obstaculoIcon2.getImage();
        Image scaledImage2 = image1.getScaledInstance(120, 160, Image.SCALE_SMOOTH); // Escalar la imagen al tamaño deseado
        ImageIcon scaledObstaculoIcon1 = new ImageIcon(scaledImage1);
        JLabel moto = new JLabel(scaledObstaculoIcon1);
        motoPanel.add(moto);
        motoPanel.setLocation(200, 10);  // ajustar la ubicación del obstáculo
        motoPanel.setOpaque(false); // No mostrar el fondo transparente

*/







        //Añadir imagen de la valla al JPanel









        // Configuración de la ventana principal
        background.add(carPanel);
        background.add(obstaculoPanel);
        //background.add(motoPanel);
        //background.add(valla);
        fr.setSize(width, height); // Ajustar el tamaño
        fr.setVisible(true);
        fr.setResizable(false); // No deja ampliar pantalla del fr
        fr.setLocationRelativeTo(null);
        fr.addKeyListener(ctrl);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }



    public void starGameThread(){
        gameThread=new Gameloop(this);
        gameThread.start();
    }
    public boolean colision() {
        Rectangle carBounds = carPanel.getBounds();
        Rectangle obstaculoBounds = obstaculoPanel.getBounds();
        return carBounds.intersects(obstaculoBounds);
    }

    public void terminarJuego() {
        JOptionPane.showMessageDialog(null, "Game Over. ¡Chocaste!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        gameThread = null;
        System.exit(0);
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


    public int getxObstaculo() {
        return xObstaculo;
    }


    public int getyObstaculo() {
        return yObstaculo;
    }

    public JPanel getCarPanel() {
        return carPanel;
    }

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
    public int getPuntos(){

        return puntos;
    }

}
