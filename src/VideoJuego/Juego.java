package VideoJuego;

import javax.swing.*;
import java.awt.*;

/**
 * La clase Juego representa el juego principal que incluye la ventana de juego,
 * el coche del jugador y la lógica asociada.
 * Extiende JPanel para proporcionar un lienzo en el que se representarán los elementos del juego.
 */
public class Juego extends JPanel implements Runnable {
    private boolean running = false;
    private final int FPS = 60; //cantidad de fotogramas por segundo a la que queremos que funcione el juego,
    //60 ya que para este tipo de juego creemos que es lo adecuado
    private double tiempoRequerido = 1000000000 / FPS; //tiempo requerido para cada FPS, usando nanosegundos ya que es mas preciso
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
    private Obstaculos[] obstaculos;

    /**
     * Constructor de la clase Juego.
     * Inicializa las variables de configuración del juego y llama al método IniciarJuego().
     */
    public Juego() {
        width = 823;
        height = 645;
        velocidad = 10;
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
        background = new JLabel("", new ImageIcon(getClass().getResource("/background-image.jpg")), JLabel.CENTER);
        background.setBounds(0, 0, width, height);
        fr.add(background);

        carPanel = new JPanel();
        carPanel.setSize(180, 150);

        // Añadir imagen del coche al JPanel
        ImageIcon carIcon = new ImageIcon(getClass().getResource("/Coche.png"));
        Image image = carIcon.getImage(); // Convertir el ImageIcon a Image
        Image scaledImage = image.getScaledInstance(180, 150, Image.SCALE_SMOOTH); // Escalar la imagen al tamaño deseado
        ImageIcon scaledCarIcon = new ImageIcon(scaledImage);
        JLabel carLabel = new JLabel(scaledCarIcon);
        carPanel.add(carLabel);
        carPanel.setLocation(400, 350);
        carPanel.setOpaque(false); // No mostrar el fondo transparente

        // Configuración de la ventana principal
        background.add(carPanel);
        fr.setSize(width, height); // Ajustar el tamaño
        fr.setVisible(true);
        fr.setResizable(false); // Evitar que el coche se mueva al ampliar el frame
        fr.setLocationRelativeTo(null);
        fr.addKeyListener(ctrl);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    /**
     * Implementación del método run de la interfaz Runnable.
     * Contiene la lógica principal para la ejecución del juego en un hilo separado.
     * Controla el ciclo del juego y actualiza la lógica a una frecuencia objetivo de 60 FPS.
     */
    @Override
    public void run() {
        // Registros de tiempo para el control de la frecuencia de actualización
        long now = 0;
        long lastTime = System.nanoTime();
        int frames = 0;
        long time = 0;

        // Bucle principal del juego
        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / tiempoRequerido; // Tiempo que ha transcurrido
            time += (now - lastTime); // Tiempo total
            lastTime = now;

            // Actualizar la lógica del juego si ha pasado el tiempo necesario para un nuevo fotograma
            if (delta >= 1) {
                update();
                delta--;
                frames++;
            }

            // Actualizar el promedio de FPS cada segundo
            if (time >= 1000000000) {
                averageFPS = frames;
                frames = 0;
                time = 0;
            }
        }
    }


    /**
     * Actualiza la lógica del juego, incluyendo la detección de colisiones con obstáculos.
     * Si el coche del jugador colisiona con algún obstáculo, el juego se detendrá.
     */
    private void update() {
        // Lógica de actualización del juego

        // Verificar colisiones con obstáculos
        for (Obstaculos obstaculo : obstaculos) {
            if (coche.getBounds().intersects(obstaculo.getBounds())) {
                // Manejar la colisión, por ejemplo, detener el juego
                running = false;
                System.out.println("Colisión con un obstáculo. Juego detenido.");
            }
        }
    }

    /**
     * Método de representación gráfica de los elementos del juego.
     * Se llama automáticamente para dibujar en el lienzo del JPanel.
     *
     * @param g El objeto Graphics utilizado para dibujar elementos en el lienzo.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar elementos del juego aquí (si es necesario)
    }

    /**
     * Inicia el hilo del juego para comenzar la ejecución.
     * Establece el indicador de ejecución (running) en verdadero y
     * crea un nuevo hilo para ejecutar el método run del juego.
     */
    public void startGame() {
        running = true;

        Thread gameThread = new Thread(this);
        gameThread.start();
    }
}
