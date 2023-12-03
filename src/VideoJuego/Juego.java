package VideoJuego;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.Random;

/**
 * La clase Juego representa el juego principal que incluye la ventana de juego,
 * el coche del jugador y la logica asociada.
 * Extiende JPanel para proporcionar un lienzo en el que se representaran los elementos del juego.
 */
public class Juego extends JPanel {

    // Hilo del juego
    Thread gameThread;

    // Controlador de la mecanica del juego
    Mecanica ctrl;

    // Etiqueta para mostrar los puntos
    private JLabel puntosLabel;


    // Paneles para el coche, obstaculo y moto
    private JPanel carPanel;
    private JPanel obstaculoPanel;
    private JPanel motoPanel;

    // Ventana principal
    private JFrame fr;

    // Etiqueta de fondo y parametros de la ventana
    private JLabel background;
    private int velocidad_horizontal;
    private int width;
    private int height;

    // Generacion de numeros aleatorios
    private Random random = new Random();

    // Posiciones para el obstaculo y la moto
    private int xObstaculo;
    private int yObstaculo;
    private int motoX;
    private int motoY;

    // Puntuacion del juego
    private int puntos = 0;

    //Nivel del juego
    private Nivel beta =new Beta(1,this);


    /**
     * Constructor de la clase Juego.
     * Inicializa las variables de configuracion del juego y llama al metodo IniciarJuego().
     *
     * @param juego Instancia de la clase Juego.
     */
    public Juego(Juego juego) {
        width = 823;
        height = 645;
        velocidad_horizontal = 20;
        ctrl = new Mecanica(this);
        pantallaPrincipal();
        disenoPuntos();
        beta.inicializar();
    }

    /**
     * Inicializa y configura la ventana principal del juego.
     * Configura la interfaz grafica de usuario, establece el fondo y posiciona el coche.
     */
    public void pantallaPrincipal() {
        // Configuración de la ventana principal
        fr = new JFrame("Running Car");
        fr.setLayout(null);
        background = new JLabel("", new ImageIcon(Objects.requireNonNull(getClass().getResource("/background-image.jpg"))), JLabel.CENTER);
        background.setBounds(0, 0, width, height);
        fr.add(background);

        // Configuración del panel del coche
        carPanel = new JPanel();
        carPanel.setSize(90, 120);

        // Añadir imagen del coche al JPanel
        ImageIcon carIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Coche.png")));
        Image image = carIcon.getImage(); // Convertir el ImageIcon a Image
        Image scaledImage = image.getScaledInstance(90, 130, Image.SCALE_SMOOTH); // Escalar la imagen al tamaño deseado
        ImageIcon scaledCarIcon = new ImageIcon(scaledImage);
        JLabel carLabel = new JLabel(scaledCarIcon);
        carPanel.add(carLabel);
        carPanel.setLocation(400, 450);
        carPanel.setOpaque(false); // No mostrar el fondo transparente


        // Llamar a generarPosicionesAleatorias antes de establecer las ubicaciones
        generarPosicionesAleatorias();


        // Configuracion del panel del obstaculo
        obstaculoPanel = new JPanel();
        obstaculoPanel.setSize(100, 150);

        // Añadir imagen del Coche_Obstaculo al JPanel
        ImageIcon obstaculoIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Coche_Obstaculo.png")));
        Image image1 = obstaculoIcon.getImage();
        Image scaledImage1 = image1.getScaledInstance(100, 150, Image.SCALE_SMOOTH); // Escalar la imagen al tamaño deseado
        ImageIcon scaledObstaculoIcon = new ImageIcon(scaledImage1);
        JLabel obstaculo = new JLabel(scaledObstaculoIcon);
        obstaculoPanel.add(obstaculo);
        obstaculoPanel.setLocation(xObstaculo, yObstaculo); // Ajustar la ubicación del obstáculo
        obstaculoPanel.setOpaque(false); // No mostrar el fondo transparente

        // Configuracion del panel de la moto
        motoPanel = new JPanel();
        motoPanel.setSize(90, 143);

        // Añadir imagen de la Moto_Obstaculo al JPanel
        ImageIcon obstaculoIcon2 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Moto_Obstaculo.png")));
        Image image2 = obstaculoIcon2.getImage();
        Image scaledImage2 = image2.getScaledInstance(90, 143, Image.SCALE_SMOOTH); // Escalar la imagen al tamaño deseado
        ImageIcon scaledObstaculoIcon2 = new ImageIcon(scaledImage2);
        JLabel moto = new JLabel(scaledObstaculoIcon2);
        motoPanel.add(moto);
        motoPanel.setLocation(motoX, motoY); // Ajustar la ubicacion de la moto
        motoPanel.setOpaque(false); // No mostrar el fondo transparente


        // Configuración de la ventana principal
        background.add(carPanel);
        background.add(obstaculoPanel);
        background.add(motoPanel);
        fr.setSize(width, height); // Ajustar el tamaño
        fr.setVisible(true);
        fr.setResizable(false); // No permite cambiar el tamaño de la ventana
        fr.setLocationRelativeTo(null);
        fr.addKeyListener(ctrl);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Genera posiciones aleatorias para el obstáculo y la moto.
     */
    public void generarPosicionesAleatorias() {
        // Generar posicion aleatoria para el obstaculo
        xObstaculo = random.nextInt(401) + 120;
        yObstaculo = 0;

        // Generar posicion aleatoria para la moto
        motoX = random.nextInt(401) + 120;
        motoY = 0;

        // Verificar si las posiciones coinciden y generar nuevas posiciones si es necesario
        while (posicionesCoinciden()) {
            xObstaculo = random.nextInt(401) + 120;
            motoX = random.nextInt(401) + 120;
        }
    }

    /**
     * Verifica si las posiciones del obstáculo y la moto coinciden.
     *
     * @return true si las posiciones coinciden, false de lo contrario.
     */
    public boolean posicionesCoinciden() {
        // Verificar si las posiciones del obstaculo y la moto coinciden
        return (Math.abs(xObstaculo - motoX) < 100) && (Math.abs(yObstaculo - motoY) < 100);
    }

    /**
     * Inicia el hilo del juego.
     */
    public void starGameThread() {
        gameThread = new Gameloop(this);
        gameThread.start();
    }

    /**
     * Agrega un JLabel para mostrar los puntos en la interfaz grafica del juego.
     */

    public void disenoPuntos() {
        // Agregar un JLabel para mostrar los puntos
        puntosLabel = new JLabel("Puntos: " + puntos);
        puntosLabel.setForeground(Color.BLACK); // Establecer el color del texto
        // Agregar un fondo de color al JLabel para mejorar la visibilidad
        puntosLabel.setBackground(Color.WHITE); // Establecer el color de fondo
        puntosLabel.setOpaque(true); // Hacer que el fondo sea opaco
        puntosLabel.setFont(new Font("Arial", Font.PLAIN, 20)); // Establecer la fuente y tamaño
        puntosLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        puntosLabel.setBounds(1, 60, 125, 50); // Establecer la posición y tamaño del JLabel
        background.add(puntosLabel); // Agregar el JLabel al panel de fondo
    }

    /**
     * Aumenta la puntuacion del juego en la cantidad especificada.
     *
     * @param cantidad Cantidad de puntos que se agregaran.
     */
    public void aumentarPuntos(int cantidad) {
        puntos += cantidad;
        // Actualizar la interfaz grafica para mostrar los puntos, por ejemplo, en un JLabel
        actualizarInterfaz();
    }

    /**
     * Actualiza la interfaz grafica para reflejar la puntuacion actualizada.
     */
    public void actualizarInterfaz() {
        // Actualizar el texto del JLabel con los puntos actuales
        puntosLabel.setText("Puntos: " + puntos);
    }

    /**
     * Verifica si la puntuacion del juego alcanza el máximo (500 puntos) y muestra un mensaje de victoria.
     * Finaliza el juego si se alcanza la maxima puntuacion.
     */
    public void maximaPuntuacion() {
        if (puntos == 500) {
            JOptionPane.showMessageDialog(null, "HAS GANADO", "NIVEL 1", JOptionPane.INFORMATION_MESSAGE);
            gameThread = null;
            beta.terminarNivel();
            System.exit(0);
        }
    }


    /**
     * Obtiene la velocidad horizontal del juego.
     *
     * @return La velocidad horizontal actual.
     */
    public int getVelocidad_horizontal() {
        return velocidad_horizontal;
    }

    /**
     * Establece la velocidad horizontal del juego.
     *
     * @param velocidad_horizontal La nueva velocidad horizontal.
     */
    public void setVelocidad_horizontal(int velocidad_horizontal) {
        this.velocidad_horizontal = velocidad_horizontal;
    }
    /**
     * Obtiene la posicion horizontal actual del obstaculo.
     *
     * @return La posicion horizontal del obstáculo.
     */

    public int getxObstaculo() {
        return xObstaculo;
    }

    /**
     * Obtiene la posicion vertical actual del obstaculo.
     *
     * @return La posicion vertical del obstaculo.
     */

    public int getyObstaculo() {
        return yObstaculo;
    }

    /**
     * Obtiene la posicion horizontal actual de la moto.
     *
     * @return La posicion horizontal de la moto.
     */

    public int getMotoX() {
        return motoX;
    }
    /**
     * Obtiene la posicion vertical actual de la moto.
     *
     * @return La posicion vertical de la moto.
     */

    public int getMotoY() {
        return motoY;
    }

    /**
     * Obtiene el panel que contiene la representación grafica del coche.
     *
     * @return El panel del coche.
     */
    public JPanel getCarPanel() {
        return carPanel;
    }

    /**
     * Obtiene el panel que contiene la representación grafica del obstaculo.
     *
     * @return El panel del obstaculo.
     */
    public JPanel getObstaculoPanel() {
        return obstaculoPanel;
    }

    /**
     * Obtiene el panel que contiene la representación grafica de la moto.
     *
     * @return El panel de la moto.
     */
    public JPanel getMotoPanel() {
        return motoPanel;
    }

    /**
     * Obtiene la puntuacion actual del juego.
     *
     * @return La puntuacion actual.
     */
    public int getPuntos() {
        return puntos;
    }

}